package com.nannydays.ui.viewmodel

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nannydays.R
import com.nannydays.data.model.Child
import com.nannydays.data.model.ChildWithSummary
import com.nannydays.data.repository.CareSessionRepository
import com.nannydays.data.repository.ChildRepository
import com.nannydays.util.ChildrenQrSheetPdf
import com.nannydays.util.DateTimeUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

/**
 * ViewModel for managing child data and operations.
 */
class ChildViewModel(
    private val childRepository: ChildRepository,
    private val careSessionRepository: CareSessionRepository
) : ViewModel() {

    val allChildren: StateFlow<List<Child>> = childRepository.allChildren
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _selectedChild = MutableStateFlow<Child?>(null)
    val selectedChild: StateFlow<Child?> = _selectedChild.asStateFlow()

    private val _childWithSummary = MutableStateFlow<ChildWithSummary?>(null)
    val childWithSummary: StateFlow<ChildWithSummary?> = _childWithSummary.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _isGeneratingChildrenQrSheet = MutableStateFlow(false)
    val isGeneratingChildrenQrSheet: StateFlow<Boolean> = _isGeneratingChildrenQrSheet.asStateFlow()

    private val _childrenQrSheetExportResult = MutableSharedFlow<ExportResult>(extraBufferCapacity = 1)
    val childrenQrSheetExportResult: SharedFlow<ExportResult> = _childrenQrSheetExportResult.asSharedFlow()

    fun getChildById(childId: String): Flow<Child?> = childRepository.getChildById(childId)

    fun loadChild(childId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                childRepository.getChildById(childId).collect { child ->
                    _selectedChild.value = child
                    child?.let { loadChildSummary(it) }
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun loadChildSummary(child: Child) {
        viewModelScope.launch {
            val totalHours = careSessionRepository.getTotalHoursForChild(child.id).first() ?: 0f
            val sessionCount = careSessionRepository.getSessionCountForChild(child.id).first()
            val activeSession = careSessionRepository.getActiveSessionForChildSync(child.id)
            
            _childWithSummary.value = ChildWithSummary(
                child = child,
                totalHours = totalHours,
                sessionCount = sessionCount,
                hasActiveSession = activeSession != null
            )
        }
    }

    fun addChild(
        name: String,
        dateOfBirth: Long,
        standardHoursPerWeek: Float,
        parentName: String = "",
        parentContact: String = "",
        notes: String = ""
    ) {
        viewModelScope.launch {
            try {
                val child = Child(
                    name = name,
                    dateOfBirth = dateOfBirth,
                    standardHoursPerWeek = standardHoursPerWeek,
                    parentName = parentName,
                    parentContact = parentContact,
                    notes = notes
                )
                childRepository.insertChild(child)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun updateChild(child: Child) {
        viewModelScope.launch {
            try {
                childRepository.updateChild(child)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun deleteChild(child: Child) {
        viewModelScope.launch {
            try {
                childRepository.deleteChild(child)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }

    fun exportChildrenQrSheetPdf(context: Context) {
        val children = allChildren.value
        if (children.isEmpty()) return

        viewModelScope.launch {
            _isGeneratingChildrenQrSheet.value = true
            try {
                val stamp = DateTimeUtils.formatShortDate(System.currentTimeMillis()).replace("/", "-")
                val fileName = "NannyDays_Children_QR_$stamp.pdf"

                val (outputStream, filePath) = getOutputStreamForFile(context, fileName, "application/pdf")
                outputStream.use { stream ->
                    ChildrenQrSheetPdf.write(
                        outputStream = stream,
                        children = children,
                        title = context.getString(R.string.children_qr_sheet_doc_title),
                        subtitle = context.getString(R.string.children_qr_sheet_doc_subtitle)
                    ) { child ->
                        context.getString(
                            R.string.age_years,
                            DateTimeUtils.calculateAge(child.dateOfBirth)
                        )
                    }
                }
                _childrenQrSheetExportResult.emit(ExportResult.Success(filePath, "PDF"))
            } catch (e: Exception) {
                _childrenQrSheetExportResult.emit(
                    ExportResult.Error(e.message ?: "Failed to export PDF")
                )
            } finally {
                _isGeneratingChildrenQrSheet.value = false
            }
        }
    }

    private suspend fun getOutputStreamForFile(
        context: Context,
        fileName: String,
        mimeType: String
    ): Pair<OutputStream, String> = withContext(Dispatchers.IO) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
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

            contentValues.clear()
            contentValues.put(MediaStore.Downloads.IS_PENDING, 0)
            resolver.update(uri, contentValues, null, null)

            val filePath = "Downloads/$fileName"
            Pair(outputStream, filePath)
        } else {
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
            if (modelClass.isAssignableFrom(ChildViewModel::class.java)) {
                return ChildViewModel(childRepository, careSessionRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
