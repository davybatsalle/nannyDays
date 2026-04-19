package com.nannydays.ui.viewmodel

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nannydays.data.model.CareSession
import com.nannydays.data.model.Child
import com.nannydays.data.model.ChildReport
import com.nannydays.data.repository.CareSessionRepository
import com.nannydays.data.repository.ChildRepository
import com.nannydays.util.DateTimeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.OutputStream

/**
 * ViewModel for generating and exporting reports.
 */
class ReportViewModel(
    private val childRepository: ChildRepository,
    private val careSessionRepository: CareSessionRepository
) : ViewModel() {

    val allChildren: StateFlow<List<Child>> = childRepository.allChildren
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _selectedChild = MutableStateFlow<Child?>(null)
    val selectedChild: StateFlow<Child?> = _selectedChild.asStateFlow()

    private val _startDate = MutableStateFlow(DateTimeUtils.getStartOfMonth(System.currentTimeMillis()))
    val startDate: StateFlow<Long> = _startDate.asStateFlow()

    private val _endDate = MutableStateFlow(DateTimeUtils.getEndOfMonth(System.currentTimeMillis()))
    val endDate: StateFlow<Long> = _endDate.asStateFlow()

    private val _report = MutableStateFlow<ChildReport?>(null)
    val report: StateFlow<ChildReport?> = _report.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _exportResult = MutableSharedFlow<ExportResult>()
    val exportResult: SharedFlow<ExportResult> = _exportResult.asSharedFlow()

    private val _taxOfficeFormat = MutableStateFlow(false)
    val taxOfficeFormat: StateFlow<Boolean> = _taxOfficeFormat.asStateFlow()

    fun setTaxOfficeFormat(enabled: Boolean) {
        _taxOfficeFormat.value = enabled
    }

    fun selectChild(child: Child?) {
        _selectedChild.value = child
    }

    fun setDateRange(start: Long, end: Long) {
        _startDate.value = start
        _endDate.value = end
    }

    fun generateReport() {
        val child = _selectedChild.value ?: return
        
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val sessions = careSessionRepository.getSessionsByChildIdAndDateRangeSync(
                    child.id,
                    _startDate.value,
                    _endDate.value
                )
                
                val totalHours = sessions
                    .filter { it.checkOutTime != null }
                    .sumOf { it.getDurationHours().toDouble() }
                    .toFloat()

                val (taxDaysOver, taxHoursPartial) = computeTaxOfficeDayStats(sessions)

                _report.value = ChildReport(
                    child = child,
                    sessions = sessions,
                    totalHours = totalHours,
                    startDate = _startDate.value,
                    endDate = _endDate.value,
                    taxDaysOverThreshold = taxDaysOver,
                    taxHoursOnDaysBelowThreshold = taxHoursPartial
                )
            } catch (e: Exception) {
                _exportResult.emit(ExportResult.Error(e.message ?: "Failed to generate report"))
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun exportToCsv(context: Context) {
        val currentReport = _report.value ?: return
        
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fileName = "NannyDays_${currentReport.child.name.replace(" ", "_")}_${
                    DateTimeUtils.formatShortDate(_startDate.value).replace("/", "-")
                }_to_${
                    DateTimeUtils.formatShortDate(_endDate.value).replace("/", "-")
                }.csv"
                
                val (outputStream, filePath) = getOutputStreamForFile(context, fileName, "text/csv")
                
                outputStream.bufferedWriter().use { writer ->
                    // Header
                    writer.append("NannyDays Care Report\n")
                    writer.append("Child Name,${currentReport.child.name}\n")
                    writer.append("Period,${DateTimeUtils.formatDate(_startDate.value)} - ${DateTimeUtils.formatDate(_endDate.value)}\n")
                    if (_taxOfficeFormat.value) {
                        writer.append(
                            "Care days (>= ${ChildReport.TAX_DAY_THRESHOLD_HOURS.toInt()} h),${currentReport.taxDaysOverThreshold}\n"
                        )
                        writer.append(
                            "Hours on days (< ${ChildReport.TAX_DAY_THRESHOLD_HOURS.toInt()} h),${
                                String.format("%.2f", currentReport.taxHoursOnDaysBelowThreshold)
                            }\n"
                        )
                    } else {
                        writer.append("Total Hours,${String.format("%.2f", currentReport.totalHours)}\n")
                    }
                    writer.append("\n")
                    
                    // Session details header
                    writer.append("Date,Check In,Check Out,Duration (hours),Notes\n")
                    
                    // Session rows
                    for (session in currentReport.sessions) {
                        val date = DateTimeUtils.formatDate(session.checkInTime)
                        val checkIn = DateTimeUtils.formatTime(session.checkInTime)
                        val checkOut = session.checkOutTime?.let { DateTimeUtils.formatTime(it) } ?: "Active"
                        val duration = if (session.checkOutTime != null) {
                            String.format("%.2f", session.getDurationHours())
                        } else {
                            "In Progress"
                        }
                        val notes = session.notes.replace(",", ";").replace("\n", " ")
                        
                        writer.append("$date,$checkIn,$checkOut,$duration,$notes\n")
                    }
                }
                
                _exportResult.emit(ExportResult.Success(filePath, "CSV"))
            } catch (e: Exception) {
                _exportResult.emit(ExportResult.Error(e.message ?: "Failed to export CSV"))
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun exportToPdf(context: Context) {
        val currentReport = _report.value ?: return
        
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fileName = "NannyDays_${currentReport.child.name.replace(" ", "_")}_${
                    DateTimeUtils.formatShortDate(_startDate.value).replace("/", "-")
                }_to_${
                    DateTimeUtils.formatShortDate(_endDate.value).replace("/", "-")
                }.pdf"
                
                val (outputStream, filePath) = getOutputStreamForFile(context, fileName, "application/pdf")
                
                // Create PDF using iText
                val pdfWriter = com.itextpdf.kernel.pdf.PdfWriter(outputStream)
                val pdfDocument = com.itextpdf.kernel.pdf.PdfDocument(pdfWriter)
                val document = com.itextpdf.layout.Document(pdfDocument)
                
                // Title
                document.add(
                    com.itextpdf.layout.element.Paragraph("NannyDays Care Report")
                        .setFontSize(20f)
                        .setBold()
                )
                
                // Child info
                document.add(com.itextpdf.layout.element.Paragraph("Child: ${currentReport.child.name}"))
                document.add(com.itextpdf.layout.element.Paragraph(
                    "Period: ${DateTimeUtils.formatDate(_startDate.value)} - ${DateTimeUtils.formatDate(_endDate.value)}"
                ))
                if (_taxOfficeFormat.value) {
                    document.add(com.itextpdf.layout.element.Paragraph(
                        "Care days (>= ${ChildReport.TAX_DAY_THRESHOLD_HOURS.toInt()} h): ${currentReport.taxDaysOverThreshold}"
                    ).setBold())
                    document.add(com.itextpdf.layout.element.Paragraph(
                        "Hours on days (< ${ChildReport.TAX_DAY_THRESHOLD_HOURS.toInt()} h): ${
                            String.format("%.2f", currentReport.taxHoursOnDaysBelowThreshold)
                        }"
                    ).setBold())
                } else {
                    document.add(com.itextpdf.layout.element.Paragraph(
                        "Total Hours: ${String.format("%.2f", currentReport.totalHours)}"
                    ).setBold())
                }
                document.add(com.itextpdf.layout.element.Paragraph("\n"))
                
                // Sessions table
                val table = com.itextpdf.layout.element.Table(5)
                    .useAllAvailableWidth()
                
                // Table headers
                listOf("Date", "Check In", "Check Out", "Duration", "Notes").forEach { header ->
                    table.addCell(
                        com.itextpdf.layout.element.Cell()
                            .add(com.itextpdf.layout.element.Paragraph(header).setBold())
                            .setBackgroundColor(com.itextpdf.kernel.colors.ColorConstants.LIGHT_GRAY)
                    )
                }
                
                // Table rows
                for (session in currentReport.sessions) {
                    table.addCell(DateTimeUtils.formatDate(session.checkInTime))
                    table.addCell(DateTimeUtils.formatTime(session.checkInTime))
                    table.addCell(session.checkOutTime?.let { DateTimeUtils.formatTime(it) } ?: "Active")
                    table.addCell(
                        if (session.checkOutTime != null) 
                            DateTimeUtils.formatDuration(session.getDurationHours())
                        else "In Progress"
                    )
                    table.addCell(session.notes.ifEmpty { "-" })
                }
                
                document.add(table)
                document.close()
                
                _exportResult.emit(ExportResult.Success(filePath, "PDF"))
            } catch (e: Exception) {
                _exportResult.emit(ExportResult.Error(e.message ?: "Failed to export PDF"))
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Per calendar day (local timezone, day of check-in): count days with completed hours &gt;= 8
     * (including exactly 8 h), and sum hours on days with completed hours &lt; 8.
     */
    private fun computeTaxOfficeDayStats(sessions: List<CareSession>): Pair<Int, Float> {
        val threshold = ChildReport.TAX_DAY_THRESHOLD_HOURS.toDouble()
        val completedByDay = sessions
            .filter { it.checkOutTime != null }
            .groupBy { DateTimeUtils.getStartOfDay(it.checkInTime) }
        var daysOver = 0
        var hoursOnPartialDays = 0.0
        for ((_, daySessions) in completedByDay) {
            val dayHours = daySessions.sumOf { it.getDurationHours().toDouble() }
            when {
                dayHours >= threshold -> daysOver++
                dayHours < threshold -> hoursOnPartialDays += dayHours
            }
        }
        return Pair(daysOver, hoursOnPartialDays.toFloat())
    }

    /**
     * Get an output stream for saving a file to the Downloads folder.
     * Uses MediaStore API for Android 10+ and direct file access for older versions.
     */
    private suspend fun getOutputStreamForFile(
        context: Context,
        fileName: String,
        mimeType: String
    ): Pair<OutputStream, String> = withContext(Dispatchers.IO) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+ use MediaStore
            val contentValues = ContentValues().apply {
                put(MediaStore.Downloads.DISPLAY_NAME, fileName)
                put(MediaStore.Downloads.MIME_TYPE, mimeType)
                put(MediaStore.Downloads.IS_PENDING, 1)
            }
            
            val resolver = context.contentResolver
            val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
                ?: throw Exception("Failed to create file")
            
            val outputStream = resolver.openOutputStream(uri)
                ?: throw Exception("Failed to open output stream")
            
            // Mark as not pending when done (caller should close the stream)
            contentValues.clear()
            contentValues.put(MediaStore.Downloads.IS_PENDING, 0)
            resolver.update(uri, contentValues, null, null)
            
            val filePath = "Downloads/$fileName"
            Pair(outputStream, filePath)
        } else {
            // Older Android versions - write to Downloads folder directly
            @Suppress("DEPRECATION")
            val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs()
            }
            val file = File(downloadsDir, fileName)
            val outputStream = FileOutputStream(file)
            Pair(outputStream, file.absolutePath)
        }
    }

    class Factory(
        private val childRepository: ChildRepository,
        private val careSessionRepository: CareSessionRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ReportViewModel::class.java)) {
                return ReportViewModel(childRepository, careSessionRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

/**
 * Sealed class for export operation results.
 */
sealed class ExportResult {
    data class Success(val filePath: String, val format: String) : ExportResult()
    data class Error(val message: String) : ExportResult()
}
