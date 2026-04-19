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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nannydays.R
import com.nannydays.ui.components.SectionHeader
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.ui.viewmodel.CheckInResult
import com.nannydays.ui.viewmodel.SessionViewModel
import com.nannydays.ui.viewmodel.SessionWithChild
import com.nannydays.util.DateTimeUtils

/**
 * Home screen / Dashboard showing active sessions and quick actions.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    childViewModel: ChildViewModel,
    sessionViewModel: SessionViewModel,
    onNavigateToChildren: () -> Unit,
    onNavigateToSessions: () -> Unit,
    onNavigateToReports: () -> Unit,
    onNavigateToQrScanner: () -> Unit,
    onNavigateToChildDetail: (String) -> Unit
) {
    val children by childViewModel.allChildren.collectAsState()
    val activeSessionsWithChildren by sessionViewModel.activeSessionsWithChildren.collectAsState()
    val checkInResult by sessionViewModel.checkInResult.collectAsState(initial = null)
    
    var snackbarMessage by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    
    val context = androidx.compose.ui.platform.LocalContext.current
    
    LaunchedEffect(checkInResult) {
        when (val result = checkInResult) {
            is CheckInResult.Success -> {
                snackbarMessage = if (result.isCheckIn) {
                    context.getString(R.string.checked_in_success, result.childName)
                } else {
                    context.getString(R.string.checked_out_success, result.childName)
                }
            }
            is CheckInResult.AlreadyCheckedIn -> {
                snackbarMessage = context.getString(R.string.already_checked_in, result.childName)
            }
            is CheckInResult.Error -> {
                snackbarMessage = context.getString(R.string.error_message, result.message)
            }
            else -> {}
        }
    }
    
    LaunchedEffect(snackbarMessage) {
        snackbarMessage?.let {
            snackbarHostState.showSnackbar(it)
            snackbarMessage = null
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToQrScanner,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.QrCodeScanner, contentDescription = stringResource(R.string.scan_qr_code))
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(bottom = 88.dp)
        ) {
            // Quick Actions
            item {
                QuickActionsSection(
                    onNavigateToChildren = onNavigateToChildren,
                    onNavigateToSessions = onNavigateToSessions,
                    onNavigateToReports = onNavigateToReports,
                    onNavigateToQrScanner = onNavigateToQrScanner
                )
            }
            
            // Active Sessions Section
            item {
                SectionHeader(
                    title = stringResource(R.string.active_sessions_count, activeSessionsWithChildren.size),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            
            if (activeSessionsWithChildren.isEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.no_active_sessions),
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                items(activeSessionsWithChildren) { sessionWithChild ->
                    ActiveSessionCard(
                        sessionWithChild = sessionWithChild,
                        onCheckOut = { sessionViewModel.checkOut(sessionWithChild.session.childId) },
                        onClick = { onNavigateToChildDetail(sessionWithChild.session.childId) }
                    )
                }
            }
            
            // Children Section (Quick check-in)
            item {
                SectionHeader(
                    title = stringResource(R.string.children_count, children.size),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            
            if (children.isEmpty()) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable { onNavigateToChildren() }
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = stringResource(R.string.add_first_child),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            } else {
                items(children) { child ->
                    val isActive = activeSessionsWithChildren.any { it.session.childId == child.id }
                    ChildQuickCard(
                        childName = child.name,
                        isActive = isActive,
                        onCheckIn = { sessionViewModel.checkIn(child.id) },
                        onCheckOut = { sessionViewModel.checkOut(child.id) },
                        onClick = { onNavigateToChildDetail(child.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickActionsSection(
    onNavigateToChildren: () -> Unit,
    onNavigateToSessions: () -> Unit,
    onNavigateToReports: () -> Unit,
    onNavigateToQrScanner: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        QuickActionCard(
            icon = Icons.Default.People,
            label = stringResource(R.string.nav_children),
            onClick = onNavigateToChildren
        )
        QuickActionCard(
            icon = Icons.Default.Schedule,
            label = stringResource(R.string.nav_sessions),
            onClick = onNavigateToSessions
        )
        QuickActionCard(
            icon = Icons.Default.Assessment,
            label = stringResource(R.string.nav_reports),
            onClick = onNavigateToReports
        )
        QuickActionCard(
            icon = Icons.Default.QrCodeScanner,
            label = stringResource(R.string.scan_short),
            onClick = onNavigateToQrScanner
        )
    }
}

@Composable
private fun QuickActionCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(80.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Composable
private fun ActiveSessionCard(
    sessionWithChild: SessionWithChild,
    onCheckOut: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = sessionWithChild.child?.name ?: stringResource(R.string.unknown),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.checked_in_at, DateTimeUtils.formatTime(sessionWithChild.session.checkInTime)),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = stringResource(R.string.duration, DateTimeUtils.formatMinutes(sessionWithChild.session.getDurationMinutes())),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Button(
                onClick = onCheckOut,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text(stringResource(R.string.check_out))
            }
        }
    }
}

@Composable
private fun ChildQuickCard(
    childName: String,
    isActive: Boolean,
    onCheckIn: () -> Unit,
    onCheckOut: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                if (isActive) Icons.Default.CheckCircle else Icons.Default.Person,
                contentDescription = null,
                tint = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = childName,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            if (isActive) {
                OutlinedButton(onClick = onCheckOut) {
                    Text(stringResource(R.string.check_out_short))
                }
            } else {
                FilledTonalButton(onClick = onCheckIn) {
                    Text(stringResource(R.string.check_in_short))
                }
            }
        }
    }
}
