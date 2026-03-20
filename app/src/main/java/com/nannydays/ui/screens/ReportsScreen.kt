package com.nannydays.ui.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nannydays.data.model.Child
import com.nannydays.data.model.ChildReport
import com.nannydays.ui.components.EmptyState
import com.nannydays.ui.components.InfoRow
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.components.SectionHeader
import com.nannydays.ui.viewmodel.ExportResult
import com.nannydays.ui.viewmodel.ReportViewModel
import com.nannydays.util.DateTimeUtils
import java.util.*

/**
 * Screen for generating and exporting reports.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportsScreen(
    viewModel: ReportViewModel,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    
    val children by viewModel.allChildren.collectAsState()
    val selectedChild by viewModel.selectedChild.collectAsState()
    val startDate by viewModel.startDate.collectAsState()
    val endDate by viewModel.endDate.collectAsState()
    val report by viewModel.report.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val exportResult by viewModel.exportResult.collectAsState(initial = null)
    
    var showChildPicker by remember { mutableStateOf(false) }
    
    // Date picker dialogs
    val startCalendar = Calendar.getInstance().apply { timeInMillis = startDate }
    val endCalendar = Calendar.getInstance().apply { timeInMillis = endDate }
    
    val startDatePicker = DatePickerDialog(
        context,
        { _, year, month, day ->
            val calendar = Calendar.getInstance().apply { set(year, month, day) }
            viewModel.setDateRange(
                DateTimeUtils.getStartOfDay(calendar.timeInMillis),
                endDate
            )
        },
        startCalendar.get(Calendar.YEAR),
        startCalendar.get(Calendar.MONTH),
        startCalendar.get(Calendar.DAY_OF_MONTH)
    )
    
    val endDatePicker = DatePickerDialog(
        context,
        { _, year, month, day ->
            val calendar = Calendar.getInstance().apply { set(year, month, day) }
            viewModel.setDateRange(
                startDate,
                DateTimeUtils.getEndOfDay(calendar.timeInMillis)
            )
        },
        endCalendar.get(Calendar.YEAR),
        endCalendar.get(Calendar.MONTH),
        endCalendar.get(Calendar.DAY_OF_MONTH)
    )
    
    // Handle export results
    LaunchedEffect(exportResult) {
        when (val result = exportResult) {
            is ExportResult.Success -> {
                snackbarHostState.showSnackbar(
                    message = "${result.format} saved to: ${result.filePath}",
                    actionLabel = "OK",
                    duration = SnackbarDuration.Long
                )
            }
            is ExportResult.Error -> {
                snackbarHostState.showSnackbar("Error: ${result.message}")
            }
            null -> {}
        }
    }
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = "Reports",
                onNavigateBack = onNavigateBack
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        if (children.isEmpty()) {
            EmptyState(
                message = "Add children to generate reports",
                modifier = Modifier.padding(padding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Child selector
                item {
                    Text(
                        text = "Select Child",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showChildPicker = true }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.Person, contentDescription = null)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = selectedChild?.name ?: "Select a child",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                        }
                    }
                }
                
                // Date range selector
                item {
                    Text(
                        text = "Date Range",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Start date
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { startDatePicker.show() }
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Text(
                                    text = "From",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Default.CalendarToday,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = DateTimeUtils.formatShortDate(startDate),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                        
                        // End date
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { endDatePicker.show() }
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp)
                            ) {
                                Text(
                                    text = "To",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.Default.CalendarToday,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = DateTimeUtils.formatShortDate(endDate),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
                
                // Quick date presets
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = false,
                            onClick = {
                                val now = System.currentTimeMillis()
                                viewModel.setDateRange(
                                    DateTimeUtils.getStartOfWeek(now),
                                    DateTimeUtils.getEndOfWeek(now)
                                )
                            },
                            label = { Text("This Week") }
                        )
                        FilterChip(
                            selected = false,
                            onClick = {
                                val now = System.currentTimeMillis()
                                viewModel.setDateRange(
                                    DateTimeUtils.getStartOfMonth(now),
                                    DateTimeUtils.getEndOfMonth(now)
                                )
                            },
                            label = { Text("This Month") }
                        )
                        FilterChip(
                            selected = false,
                            onClick = {
                                val calendar = Calendar.getInstance().apply {
                                    add(Calendar.MONTH, -1)
                                }
                                viewModel.setDateRange(
                                    DateTimeUtils.getStartOfMonth(calendar.timeInMillis),
                                    DateTimeUtils.getEndOfMonth(calendar.timeInMillis)
                                )
                            },
                            label = { Text("Last Month") }
                        )
                    }
                }
                
                // Generate button
                item {
                    Button(
                        onClick = { viewModel.generateReport() },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = selectedChild != null && !isLoading
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        Icon(Icons.Default.Assessment, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Generate Report")
                    }
                }
                
                // Report display
                report?.let { currentReport ->
                    item {
                        Divider(modifier = Modifier.padding(vertical = 8.dp))
                    }
                    
                    item {
                        ReportSummaryCard(report = currentReport)
                    }
                    
                    // Session list
                    if (currentReport.sessions.isNotEmpty()) {
                        item {
                            SectionHeader(title = "Sessions (${currentReport.sessions.size})")
                        }
                        
                        items(currentReport.sessions) { session ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 2.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = DateTimeUtils.formatDate(session.checkInTime),
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium
                                        )
                                        Text(
                                            text = "${DateTimeUtils.formatTime(session.checkInTime)} - ${
                                                session.checkOutTime?.let { DateTimeUtils.formatTime(it) } ?: "Active"
                                            }",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                    Text(
                                        text = if (session.checkOutTime != null) {
                                            DateTimeUtils.formatDuration(session.getDurationHours())
                                        } else {
                                            "In Progress"
                                        },
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    } else {
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "No sessions in this period",
                                    modifier = Modifier.padding(16.dp),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                    
                    // Export buttons
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedButton(
                                onClick = { viewModel.exportToCsv(context) },
                                modifier = Modifier.weight(1f),
                                enabled = !isLoading
                            ) {
                                Icon(Icons.Default.TableChart, contentDescription = null)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Export CSV")
                            }
                            Button(
                                onClick = { viewModel.exportToPdf(context) },
                                modifier = Modifier.weight(1f),
                                enabled = !isLoading
                            ) {
                                Icon(Icons.Default.PictureAsPdf, contentDescription = null)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Export PDF")
                            }
                        }
                    }
                }
            }
        }
        
        // Child picker dialog
        if (showChildPicker) {
            AlertDialog(
                onDismissRequest = { showChildPicker = false },
                title = { Text("Select Child") },
                text = {
                    LazyColumn {
                        items(children) { child ->
                            ListItem(
                                headlineContent = { Text(child.name) },
                                leadingContent = {
                                    RadioButton(
                                        selected = selectedChild?.id == child.id,
                                        onClick = {
                                            viewModel.selectChild(child)
                                            showChildPicker = false
                                        }
                                    )
                                },
                                modifier = Modifier.clickable {
                                    viewModel.selectChild(child)
                                    showChildPicker = false
                                }
                            )
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showChildPicker = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Composable
private fun ReportSummaryCard(report: ChildReport) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = report.child.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = "${DateTimeUtils.formatDate(report.startDate)} - ${DateTimeUtils.formatDate(report.endDate)}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(
                    label = "Total Hours",
                    value = String.format("%.1f", report.totalHours)
                )
                StatItem(
                    label = "Sessions",
                    value = report.sessions.size.toString()
                )
                StatItem(
                    label = "Avg/Session",
                    value = if (report.sessions.isNotEmpty()) {
                        String.format("%.1fh", report.totalHours / report.sessions.size)
                    } else {
                        "0h"
                    }
                )
            }
        }
    }
}

@Composable
private fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}
