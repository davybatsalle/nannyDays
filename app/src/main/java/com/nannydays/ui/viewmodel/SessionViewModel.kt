package com.nannydays.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.nannydays.data.model.CareSession
import com.nannydays.data.model.Child
import com.nannydays.data.repository.CareSessionRepository
import com.nannydays.data.repository.ChildRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Data class combining a session with its child info.
 */
data class SessionWithChild(
    val session: CareSession,
    val child: Child?
)

/**
 * ViewModel for managing care session data and operations.
 */
class SessionViewModel(
    private val careSessionRepository: CareSessionRepository,
    private val childRepository: ChildRepository
) : ViewModel() {

    val allSessions: StateFlow<List<CareSession>> = careSessionRepository.allSessions
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeSessions: StateFlow<List<CareSession>> = careSessionRepository.getAllActiveSessions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _activeSessionsWithChildren = MutableStateFlow<List<SessionWithChild>>(emptyList())
    val activeSessionsWithChildren: StateFlow<List<SessionWithChild>> = _activeSessionsWithChildren.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _checkInResult = MutableSharedFlow<CheckInResult>()
    val checkInResult: SharedFlow<CheckInResult> = _checkInResult.asSharedFlow()

    init {
        loadActiveSessionsWithChildren()
    }

    private fun loadActiveSessionsWithChildren() {
        viewModelScope.launch {
            careSessionRepository.getAllActiveSessions().collect { sessions ->
                val sessionsWithChildren = sessions.map { session ->
                    val child = childRepository.getChildByIdSync(session.childId)
                    SessionWithChild(session, child)
                }
                _activeSessionsWithChildren.value = sessionsWithChildren
            }
        }
    }

    fun getSessionsForChild(childId: String): Flow<List<CareSession>> =
        careSessionRepository.getSessionsByChildId(childId)

    fun getActiveSessionForChild(childId: String): Flow<CareSession?> =
        careSessionRepository.getActiveSessionForChild(childId)

    /**
     * Check in a child - start a new care session.
     */
    fun checkIn(childId: String, notes: String = "") {
        viewModelScope.launch {
            try {
                // Check if child exists
                val child = childRepository.getChildByIdSync(childId)
                if (child == null) {
                    _checkInResult.emit(CheckInResult.ChildNotFound)
                    return@launch
                }

                // Check if already checked in
                val activeSession = careSessionRepository.getActiveSessionForChildSync(childId)
                if (activeSession != null) {
                    _checkInResult.emit(CheckInResult.AlreadyCheckedIn(child.name))
                    return@launch
                }

                val session = careSessionRepository.checkIn(childId, notes)
                _checkInResult.emit(CheckInResult.Success(child.name, true))
            } catch (e: Exception) {
                _errorMessage.value = e.message
                _checkInResult.emit(CheckInResult.Error(e.message ?: "Unknown error"))
            }
        }
    }

    /**
     * Check out a child - end active care session.
     */
    fun checkOut(childId: String) {
        viewModelScope.launch {
            try {
                val child = childRepository.getChildByIdSync(childId)
                val success = careSessionRepository.checkOutByChildId(childId)
                if (success) {
                    _checkInResult.emit(CheckInResult.Success(child?.name ?: "Child", false))
                } else {
                    _checkInResult.emit(CheckInResult.NotCheckedIn)
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
                _checkInResult.emit(CheckInResult.Error(e.message ?: "Unknown error"))
            }
        }
    }

    /**
     * Toggle check-in/out for a child based on current state.
     */
    fun toggleCheckInOut(childId: String) {
        viewModelScope.launch {
            try {
                val activeSession = careSessionRepository.getActiveSessionForChildSync(childId)
                if (activeSession != null) {
                    checkOut(childId)
                } else {
                    checkIn(childId)
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    /**
     * Process QR code scan and perform check-in/out.
     */
    fun processQrCode(qrData: String) {
        viewModelScope.launch {
            val childId = com.nannydays.util.QrCodeUtils.parseQrCode(qrData)
            if (childId == null) {
                _checkInResult.emit(CheckInResult.InvalidQrCode)
                return@launch
            }
            toggleCheckInOut(childId)
        }
    }

    fun updateSession(session: CareSession) {
        viewModelScope.launch {
            try {
                careSessionRepository.updateSession(session)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun deleteSession(session: CareSession) {
        viewModelScope.launch {
            try {
                careSessionRepository.deleteSession(session)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }

    class Factory(
        private val careSessionRepository: CareSessionRepository,
        private val childRepository: ChildRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SessionViewModel::class.java)) {
                return SessionViewModel(careSessionRepository, childRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

/**
 * Sealed class for check-in/out operation results.
 */
sealed class CheckInResult {
    data class Success(val childName: String, val isCheckIn: Boolean) : CheckInResult()
    data class AlreadyCheckedIn(val childName: String) : CheckInResult()
    object NotCheckedIn : CheckInResult()
    object ChildNotFound : CheckInResult()
    object InvalidQrCode : CheckInResult()
    data class Error(val message: String) : CheckInResult()
}
