package com.nannydays.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nannydays.data.model.Child
import com.nannydays.data.model.ChildWithSummary
import com.nannydays.data.repository.CareSessionRepository
import com.nannydays.data.repository.ChildRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

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
