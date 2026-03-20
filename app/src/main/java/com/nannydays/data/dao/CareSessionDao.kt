package com.nannydays.data.dao

import androidx.room.*
import com.nannydays.data.model.CareSession
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for CareSession entity operations.
 */
@Dao
interface CareSessionDao {
    
    @Query("SELECT * FROM care_sessions ORDER BY checkInTime DESC")
    fun getAllSessions(): Flow<List<CareSession>>
    
    @Query("SELECT * FROM care_sessions WHERE childId = :childId ORDER BY checkInTime DESC")
    fun getSessionsByChildId(childId: String): Flow<List<CareSession>>
    
    @Query("SELECT * FROM care_sessions WHERE id = :sessionId")
    fun getSessionById(sessionId: String): Flow<CareSession?>
    
    @Query("SELECT * FROM care_sessions WHERE id = :sessionId")
    suspend fun getSessionByIdSync(sessionId: String): CareSession?
    
    @Query("SELECT * FROM care_sessions WHERE childId = :childId AND checkOutTime IS NULL LIMIT 1")
    fun getActiveSessionForChild(childId: String): Flow<CareSession?>
    
    @Query("SELECT * FROM care_sessions WHERE childId = :childId AND checkOutTime IS NULL LIMIT 1")
    suspend fun getActiveSessionForChildSync(childId: String): CareSession?
    
    @Query("SELECT * FROM care_sessions WHERE checkOutTime IS NULL")
    fun getAllActiveSessions(): Flow<List<CareSession>>
    
    @Query("""
        SELECT * FROM care_sessions 
        WHERE childId = :childId 
        AND checkInTime >= :startTime 
        AND checkInTime <= :endTime 
        ORDER BY checkInTime ASC
    """)
    fun getSessionsByChildIdAndDateRange(
        childId: String, 
        startTime: Long, 
        endTime: Long
    ): Flow<List<CareSession>>
    
    @Query("""
        SELECT * FROM care_sessions 
        WHERE childId = :childId 
        AND checkInTime >= :startTime 
        AND checkInTime <= :endTime 
        ORDER BY checkInTime ASC
    """)
    suspend fun getSessionsByChildIdAndDateRangeSync(
        childId: String, 
        startTime: Long, 
        endTime: Long
    ): List<CareSession>
    
    @Query("""
        SELECT * FROM care_sessions 
        WHERE checkInTime >= :startTime 
        AND checkInTime <= :endTime 
        ORDER BY checkInTime DESC
    """)
    fun getSessionsByDateRange(startTime: Long, endTime: Long): Flow<List<CareSession>>
    
    @Query("""
        SELECT SUM(
            CASE 
                WHEN checkOutTime IS NOT NULL THEN (checkOutTime - checkInTime) 
                ELSE 0 
            END
        ) / 3600000.0 
        FROM care_sessions 
        WHERE childId = :childId
    """)
    fun getTotalHoursForChild(childId: String): Flow<Float?>
    
    @Query("""
        SELECT SUM(
            CASE 
                WHEN checkOutTime IS NOT NULL THEN (checkOutTime - checkInTime) 
                ELSE 0 
            END
        ) / 3600000.0 
        FROM care_sessions 
        WHERE childId = :childId 
        AND checkInTime >= :startTime 
        AND checkInTime <= :endTime
    """)
    fun getTotalHoursForChildInRange(childId: String, startTime: Long, endTime: Long): Flow<Float?>
    
    @Query("SELECT COUNT(*) FROM care_sessions WHERE childId = :childId")
    fun getSessionCountForChild(childId: String): Flow<Int>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: CareSession)
    
    @Update
    suspend fun updateSession(session: CareSession)
    
    @Delete
    suspend fun deleteSession(session: CareSession)
    
    @Query("DELETE FROM care_sessions WHERE id = :sessionId")
    suspend fun deleteSessionById(sessionId: String)
}
