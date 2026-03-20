package com.nannydays.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Entity representing a care session (check-in/check-out record).
 */
@Entity(
    tableName = "care_sessions",
    foreignKeys = [
        ForeignKey(
            entity = Child::class,
            parentColumns = ["id"],
            childColumns = ["childId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["childId"])]
)
data class CareSession(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val childId: String,
    val checkInTime: Long, // Stored as epoch millis
    val checkOutTime: Long? = null, // Null if session is still active
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    /**
     * Returns whether the session is currently active (not checked out)
     */
    fun isActive(): Boolean = checkOutTime == null

    /**
     * Calculates the duration of the session in hours
     */
    fun getDurationHours(): Float {
        val endTime = checkOutTime ?: System.currentTimeMillis()
        val durationMillis = endTime - checkInTime
        return durationMillis / (1000f * 60f * 60f)
    }
    
    /**
     * Calculates the duration of the session in minutes
     */
    fun getDurationMinutes(): Long {
        val endTime = checkOutTime ?: System.currentTimeMillis()
        val durationMillis = endTime - checkInTime
        return durationMillis / (1000L * 60L)
    }
}
