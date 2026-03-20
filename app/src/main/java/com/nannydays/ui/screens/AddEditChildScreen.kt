package com.nannydays.ui.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.nannydays.data.model.Child
import com.nannydays.ui.components.NannyDaysTopBar
import com.nannydays.ui.viewmodel.ChildViewModel
import com.nannydays.util.DateTimeUtils
import java.util.*

/**
 * Screen for adding or editing a child profile.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditChildScreen(
    viewModel: ChildViewModel,
    childId: String?,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val isEditing = childId != null
    
    // State for form fields
    var name by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf(System.currentTimeMillis()) }
    var standardHoursPerWeek by remember { mutableStateOf("20") }
    var parentName by remember { mutableStateOf("") }
    var parentContact by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var isLoaded by remember { mutableStateOf(false) }
    
    // Load existing child data if editing
    LaunchedEffect(childId) {
        if (childId != null && !isLoaded) {
            viewModel.getChildById(childId).collect { child ->
                child?.let {
                    name = it.name
                    dateOfBirth = it.dateOfBirth
                    standardHoursPerWeek = it.standardHoursPerWeek.toString()
                    parentName = it.parentName
                    parentContact = it.parentContact
                    notes = it.notes
                    isLoaded = true
                }
            }
        } else if (childId == null) {
            isLoaded = true
        }
    }
    
    // Validation
    val isNameValid = name.trim().isNotEmpty()
    val isHoursValid = standardHoursPerWeek.toFloatOrNull()?.let { it > 0 } ?: false
    val isFormValid = isNameValid && isHoursValid
    
    // Date picker
    val calendar = Calendar.getInstance().apply { timeInMillis = dateOfBirth }
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val newCalendar = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            dateOfBirth = newCalendar.timeInMillis
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    
    Scaffold(
        topBar = {
            NannyDaysTopBar(
                title = if (isEditing) "Edit Child" else "Add Child",
                onNavigateBack = onNavigateBack,
                actions = {
                    IconButton(
                        onClick = {
                            if (isFormValid) {
                                val hours = standardHoursPerWeek.toFloatOrNull() ?: 20f
                                if (isEditing && childId != null) {
                                    viewModel.getChildById(childId)
                                    // For editing, we need to update with the existing ID
                                    viewModel.updateChild(
                                        Child(
                                            id = childId,
                                            name = name.trim(),
                                            dateOfBirth = dateOfBirth,
                                            standardHoursPerWeek = hours,
                                            parentName = parentName.trim(),
                                            parentContact = parentContact.trim(),
                                            notes = notes.trim()
                                        )
                                    )
                                } else {
                                    viewModel.addChild(
                                        name = name.trim(),
                                        dateOfBirth = dateOfBirth,
                                        standardHoursPerWeek = hours,
                                        parentName = parentName.trim(),
                                        parentContact = parentContact.trim(),
                                        notes = notes.trim()
                                    )
                                }
                                onNavigateBack()
                            }
                        },
                        enabled = isFormValid
                    ) {
                        Icon(Icons.Default.Check, contentDescription = "Save")
                    }
                }
            )
        }
    ) { padding ->
        if (!isLoaded) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Name field
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Child's Name *") },
                    placeholder = { Text("Enter child's name") },
                    singleLine = true,
                    isError = name.isNotEmpty() && !isNameValid,
                    modifier = Modifier.fillMaxWidth()
                )
                
                // Date of Birth field
                OutlinedTextField(
                    value = DateTimeUtils.formatDate(dateOfBirth),
                    onValueChange = { },
                    label = { Text("Date of Birth *") },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { datePickerDialog.show() }) {
                            Icon(Icons.Default.CalendarToday, contentDescription = "Select date")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                
                // Age display
                Text(
                    text = "Age: ${DateTimeUtils.calculateAge(dateOfBirth)} years old",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                // Standard hours per week
                OutlinedTextField(
                    value = standardHoursPerWeek,
                    onValueChange = { standardHoursPerWeek = it },
                    label = { Text("Standard Hours/Week *") },
                    placeholder = { Text("e.g., 20") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    isError = standardHoursPerWeek.isNotEmpty() && !isHoursValid,
                    supportingText = if (standardHoursPerWeek.isNotEmpty() && !isHoursValid) {
                        { Text("Please enter a valid number") }
                    } else null,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                
                Text(
                    text = "Parent/Guardian Information",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                
                // Parent name
                OutlinedTextField(
                    value = parentName,
                    onValueChange = { parentName = it },
                    label = { Text("Parent/Guardian Name") },
                    placeholder = { Text("Enter parent's name") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                
                // Parent contact
                OutlinedTextField(
                    value = parentContact,
                    onValueChange = { parentContact = it },
                    label = { Text("Contact Information") },
                    placeholder = { Text("Phone or email") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )
                
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                
                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes") },
                    placeholder = { Text("Any additional notes...") },
                    minLines = 3,
                    maxLines = 5,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
