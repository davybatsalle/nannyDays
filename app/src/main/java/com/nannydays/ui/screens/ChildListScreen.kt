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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import com.nannydays.R
import com.nannydays.data.model.Child
import com.nannydays.ui.components.ConfirmationDialog
import com.nannydays.ui.components.EmptyState
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.util.DateTimeUtils

/**
 * Screen displaying list of all children.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildListScreen(
    viewModel: ChildViewModel,
    onNavigateToAddChild: () -> Unit,
    onNavigateToChildDetail: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val children by viewModel.allChildren.collectAsState()
    var childToDelete by remember { mutableStateOf<Child?>(null) }
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = stringResource(R.string.nav_children),
                onNavigateBack = onNavigateBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToAddChild,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = stringResource(R.string.add_child))
            }
        }
    ) { padding ->
        if (children.isEmpty()) {
            EmptyState(
                message = stringResource(R.string.no_children_message),
                modifier = Modifier.padding(padding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(children, key = { it.id }) { child ->
                    ChildListItem(
                        child = child,
                        onClick = { onNavigateToChildDetail(child.id) },
                        onDelete = { childToDelete = child }
                    )
                }
            }
        }
        
        // Delete confirmation dialog
        childToDelete?.let { child ->
            ConfirmationDialog(
                title = stringResource(R.string.delete_child_title),
                message = stringResource(R.string.delete_child_confirm_message, child.name),
                confirmText = stringResource(R.string.delete),
                onConfirm = {
                    viewModel.deleteChild(child)
                    childToDelete = null
                },
                onDismiss = { childToDelete = null }
            )
        }
    }
}

@Composable
private fun ChildListItem(
    child: Child,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }
    
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
            // Avatar
            Surface(
                modifier = Modifier.size(48.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = child.name.take(1).uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = child.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.age_years, DateTimeUtils.calculateAge(child.dateOfBirth)),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                if (child.parentName.isNotEmpty()) {
                    Text(
                        text = stringResource(R.string.parent_label, child.parentName),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            Box {
                IconButton(onClick = { showMenu = true }) {
                    Icon(Icons.Default.MoreVert, contentDescription = stringResource(R.string.more_options))
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.view_details)) },
                        onClick = {
                            showMenu = false
                            onClick()
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Visibility, contentDescription = null)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.delete)) },
                        onClick = {
                            showMenu = false
                            onDelete()
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    )
                }
            }
        }
    }
}
