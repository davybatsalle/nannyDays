package com.nannydays.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Entity representing a child profile in the NannyDays app.
 */
@Entity(tableName = "children")
data class Child(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val dateOfBirth: Long, // Stored as epoch millis
    val standardHoursPerWeek: Float,
    val parentName: String = "",
    val parentContact: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    /**
     * Generates QR code data for this child
     */
    fun getQrCodeData(): String {
        return "NANNYDAYS:CHILD:$id"
    }
}
