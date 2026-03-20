package com.nannydays.data.repository

import com.nannydays.data.dao.CareSessionDao
import com.nannydays.data.model.CareSession
import kotlinx.coroutines.flow.Flow

/**
 * Repository for managing CareSession data operations.
 */
class CareSessionRepository(private val careSessionDao: CareSessionDao) {
    
    val allSessions: Flow<List<CareSession>> = careSessionDao.getAllSessions()
    
    fun getSessionsByChildId(childId: String): Flow<List<CareSession>> = 
        careSessionDao.getSessionsByChildId(childId)
    
    fun getSessionById(sessionId: String): Flow<CareSession?> = 
        careSessionDao.getSessionById(sessionId)
    
    suspend fun getSessionByIdSync(sessionId: String): CareSession? = 
        careSessionDao.getSessionByIdSync(sessionId)
    
    fun getActiveSessionForChild(childId: String): Flow<CareSession?> = 
        careSessionDao.getActiveSessionForChild(childId)
    
    suspend fun getActiveSessionForChildSync(childId: String): CareSession? = 
        careSessionDao.getActiveSessionForChildSync(childId)
    
    fun getAllActiveSessions(): Flow<List<CareSession>> = 
        careSessionDao.getAllActiveSessions()
    
    fun getSessionsByDateRange(startTime: Long, endTime: Long): Flow<List<CareSession>> = 
        careSessionDao.getSessionsByDateRange(startTime, endTime)
    
    fun getSessionsByChildIdAndDateRange(
        childId: String, 
        startTime: Long, 
        endTime: Long
    ): Flow<List<CareSession>> = 
        careSessionDao.getSessionsByChildIdAndDateRange(childId, startTime, endTime)
    
    suspend fun getSessionsByChildIdAndDateRangeSync(
        childId: String, 
        startTime: Long, 
        endTime: Long
    ): List<CareSession> = 
        careSessionDao.getSessionsByChildIdAndDateRangeSync(childId, startTime, endTime)
    
    fun getTotalHoursForChild(childId: String): Flow<Float?> = 
        careSessionDao.getTotalHoursForChild(childId)
    
    fun getTotalHoursForChildInRange(
        childId: String, 
        startTime: Long, 
        endTime: Long
    ): Flow<Float?> = 
        careSessionDao.getTotalHoursForChildInRange(childId, startTime, endTime)
    
    fun getSessionCountForChild(childId: String): Flow<Int> = 
        careSessionDao.getSessionCountForChild(childId)
    
    /**
     * Check in a child - start a new care session.
     */
    suspend fun checkIn(childId: String, notes: String = ""): CareSession {
        val session = CareSession(
            childId = childId,
            checkInTime = System.currentTimeMillis(),
            notes = notes
        )
        careSessionDao.insertSession(session)
        return session
    }
    
    /**
     * Check out a child - end an active care session.
     */
    suspend fun checkOut(sessionId: String, notes: String? = null): Boolean {
        val session = careSessionDao.getSessionByIdSync(sessionId) ?: return false
        if (session.checkOutTime != null) return false // Already checked out
        
        val updatedSession = session.copy(
            checkOutTime = System.currentTimeMillis(),
            notes = notes ?: session.notes,
            updatedAt = System.currentTimeMillis()
        )
        careSessionDao.updateSession(updatedSession)
        return true
    }
    
    /**
     * Check out a child by child ID - end active session if exists.
     */
    suspend fun checkOutByChildId(childId: String): Boolean {
        val activeSession = careSessionDao.getActiveSessionForChildSync(childId) ?: return false
        return checkOut(activeSession.id)
    }
    
    suspend fun insertSession(session: CareSession) {
        careSessionDao.insertSession(session)
    }
    
    suspend fun updateSession(session: CareSession) {
        careSessionDao.updateSession(session.copy(updatedAt = System.currentTimeMillis()))
    }
    
    suspend fun deleteSession(session: CareSession) {
        careSessionDao.deleteSession(session)
    }
    
    suspend fun deleteSessionById(sessionId: String) {
        careSessionDao.deleteSessionById(sessionId)
    }
}
