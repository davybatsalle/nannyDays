package com.nannydays.ui.screens

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nannydays.R
import com.nannydays.data.model.CareSession
import com.nannydays.data.model.Child
import com.nannydays.ui.components.ConfirmationDialog
import com.nannydays.ui.components.EmptyState
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.ui.viewmodel.SessionViewModel
import com.nannydays.util.DateTimeUtils

/**
 * Screen displaying list of care sessions.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionListScreen(
    sessionViewModel: SessionViewModel,
    childViewModel: ChildViewModel,
    childId: String?,
    onNavigateBack: () -> Unit
) {
    val allSessions by sessionViewModel.allSessions.collectAsState()
    val children by childViewModel.allChildren.collectAsState()
    val childSessions = remember(childId, allSessions) {
        if (childId != null) {
            allSessions.filter { it.childId == childId }
        } else {
            allSessions
        }
    }
    
    val child = remember(childId, children) {
        children.find { it.id == childId }
    }
    
    var sessionToDelete by remember { mutableStateOf<CareSession?>(null) }
    var expandedSessionId by remember { mutableStateOf<String?>(null) }
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = if (child != null) stringResource(R.string.child_sessions_title, child.name) else stringResource(R.string.all_sessions_title),
                onNavigateBack = onNavigateBack
            )
        }
    ) { padding ->
        if (childSessions.isEmpty()) {
            EmptyState(
                message = stringResource(R.string.no_sessions_recorded),
                modifier = Modifier.padding(padding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                // Group sessions by date
                val groupedSessions = childSessions.groupBy { session ->
                    DateTimeUtils.formatDate(session.checkInTime)
                }
                
                groupedSessions.forEach { (date, sessions) ->
                    item {
                        Text(
                            text = date,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }
                    
                    items(sessions, key = { it.id }) { session ->
                        val sessionChild = if (childId == null) {
                            children.find { it.id == session.childId }
                        } else {
                            child
                        }
                        
                        SessionListItem(
                            session = session,
                            childName = sessionChild?.name,
                            showChildName = childId == null,
                            isExpanded = expandedSessionId == session.id,
                            onClick = {
                                expandedSessionId = if (expandedSessionId == session.id) null else session.id
                            },
                            onCheckOut = { sessionViewModel.checkOut(session.childId) },
                            onDelete = { sessionToDelete = session }
                        )
                    }
                }
            }
        }
        
        // Delete confirmation
        sessionToDelete?.let { session ->
            ConfirmationDialog(
                title = stringResource(R.string.delete_session_title),
                message = stringResource(R.string.delete_session_message),
                confirmText = stringResource(R.string.delete),
                onConfirm = {
                    sessionViewModel.deleteSession(session)
                    sessionToDelete = null
                },
                onDismiss = { sessionToDelete = null }
            )
        }
    }
}

@Composable
private fun SessionListItem(
    session: CareSession,
    childName: String?,
    showChildName: Boolean,
    isExpanded: Boolean,
    onClick: () -> Unit,
    onCheckOut: () -> Unit,
    onDelete: () -> Unit
) {
    val isActive = session.checkOutTime == null
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isActive) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Status icon
                Icon(
                    if (isActive) Icons.Default.PlayArrow else Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = if (isActive) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    modifier = Modifier.size(24.dp)
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    if (showChildName && childName != null) {
                        Text(
                            text = childName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = DateTimeUtils.formatTime(session.checkInTime),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = " → ",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = session.checkOutTime?.let { DateTimeUtils.formatTime(it) } ?: stringResource(R.string.session_active),
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                
                // Duration
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = if (isActive) {
                            DateTimeUtils.formatMinutes(session.getDurationMinutes())
                        } else {
                            DateTimeUtils.formatDuration(session.getDurationHours())
                        },
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                    if (isActive) {
                        Text(
                            text = stringResource(R.string.ongoing),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                
                // Expand icon
                Icon(
                    if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = stringResource(R.string.expand_description),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            // Expanded content
            if (isExpanded) {
                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(12.dp))
                
                // Session details
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.check_in),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = DateTimeUtils.formatDateTime(session.checkInTime),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = stringResource(R.string.check_out),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = session.checkOutTime?.let { 
                                DateTimeUtils.formatDateTime(it) 
                            } ?: stringResource(R.string.not_checked_out),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                
                // Notes
                if (session.notes.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.notes_label, session.notes),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                // Actions
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    if (isActive) {
                        Button(
                            onClick = onCheckOut,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Icon(Icons.Default.Logout, contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(stringResource(R.string.check_out))
                        }
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    OutlinedButton(
                        onClick = onDelete,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(stringResource(R.string.delete))
                    }
                }
            }
        }
    }
}
