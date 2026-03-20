package com.nannydays.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nannydays.data.model.CareSession
import com.nannydays.data.model.Child
import com.nannydays.ui.components.ConfirmationDialog
import com.nannydays.ui.components.InfoRow
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.components.SectionHeader
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.ui.viewmodel.SessionViewModel
import com.nannydays.util.DateTimeUtils

/**
 * Screen displaying detailed information about a child.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildDetailScreen(
    childId: String,
    childViewModel: ChildViewModel,
    sessionViewModel: SessionViewModel,
    onNavigateBack: () -> Unit,
    onNavigateToEdit: () -> Unit,
    onNavigateToQrCode: () -> Unit,
    onNavigateToSessions: () -> Unit
) {
    val child by childViewModel.getChildById(childId).collectAsState(initial = null)
    val activeSession by sessionViewModel.getActiveSessionForChild(childId).collectAsState(initial = null)
    val sessions by sessionViewModel.getSessionsForChild(childId).collectAsState(initial = emptyList())
    
    var showDeleteDialog by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = child?.name ?: "Child Details",
                onNavigateBack = onNavigateBack,
                actions = {
                    IconButton(onClick = onNavigateToEdit) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            )
        }
    ) { padding ->
        child?.let { currentChild ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                // Header Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
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
                        // Avatar
                        Surface(
                            modifier = Modifier.size(80.dp),
                            shape = MaterialTheme.shapes.large,
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = currentChild.name.take(1).uppercase(),
                                    style = MaterialTheme.typography.headlineLarge,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = currentChild.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Text(
                            text = "${DateTimeUtils.calculateAge(currentChild.dateOfBirth)} years old",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        
                        // Status indicator
                        Spacer(modifier = Modifier.height(12.dp))
                        if (activeSession != null) {
                            Surface(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = MaterialTheme.shapes.small
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp),
                                        tint = MaterialTheme.colorScheme.onTertiary
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Currently Checked In",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                }
                            }
                        }
                    }
                }
                
                // Quick Actions
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = Icons.Default.QrCode,
                        label = "QR Code",
                        onClick = onNavigateToQrCode
                    )
                    
                    if (activeSession != null) {
                        ActionButton(
                            icon = Icons.Default.Logout,
                            label = "Check Out",
                            onClick = { sessionViewModel.checkOut(childId) },
                            containerColor = MaterialTheme.colorScheme.errorContainer
                        )
                    } else {
                        ActionButton(
                            icon = Icons.Default.Login,
                            label = "Check In",
                            onClick = { sessionViewModel.checkIn(childId) }
                        )
                    }
                    
                    ActionButton(
                        icon = Icons.Default.History,
                        label = "Sessions",
                        onClick = onNavigateToSessions
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Child Information
                SectionHeader(title = "Child Information")
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Column {
                        InfoRow("Date of Birth", DateTimeUtils.formatDate(currentChild.dateOfBirth))
                        InfoRow("Age", "${DateTimeUtils.calculateAge(currentChild.dateOfBirth)} years")
                        InfoRow("Standard Hours/Week", "${currentChild.standardHoursPerWeek}h")
                    }
                }
                
                // Parent Information
                if (currentChild.parentName.isNotEmpty() || currentChild.parentContact.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(title = "Parent/Guardian")
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    ) {
                        Column {
                            if (currentChild.parentName.isNotEmpty()) {
                                InfoRow("Name", currentChild.parentName)
                            }
                            if (currentChild.parentContact.isNotEmpty()) {
                                InfoRow("Contact", currentChild.parentContact)
                            }
                        }
                    }
                }
                
                // Notes
                if (currentChild.notes.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(title = "Notes")
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = currentChild.notes,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                
                // Summary Statistics
                Spacer(modifier = Modifier.height(8.dp))
                SectionHeader(title = "Statistics")
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    val completedSessions = sessions.filter { it.checkOutTime != null }
                    val totalHours = completedSessions.sumOf { it.getDurationHours().toDouble() }.toFloat()
                    
                    Column {
                        InfoRow("Total Sessions", sessions.size.toString())
                        InfoRow("Total Hours", DateTimeUtils.formatDuration(totalHours))
                    }
                }
                
                // Recent Sessions
                if (sessions.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    SectionHeader(title = "Recent Sessions")
                    
                    sessions.take(3).forEach { session ->
                        RecentSessionItem(session)
                    }
                    
                    if (sessions.size > 3) {
                        TextButton(
                            onClick = onNavigateToSessions,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Text("View All Sessions (${sessions.size})")
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
            }
        } ?: run {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        
        // Delete confirmation
        if (showDeleteDialog && child != null) {
            ConfirmationDialog(
                title = "Delete Child",
                message = "Are you sure you want to delete ${child!!.name}? This will also delete all their care sessions.",
                confirmText = "Delete",
                onConfirm = {
                    childViewModel.deleteChild(child!!)
                    showDeleteDialog = false
                    onNavigateBack()
                },
                onDismiss = { showDeleteDialog = false }
            )
        }
    }
}

@Composable
private fun ActionButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit,
    containerColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.secondaryContainer
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = label)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
private fun RecentSessionItem(session: CareSession) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp)
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
                color = if (session.checkOutTime != null) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.tertiary
                }
            )
        }
    }
}
