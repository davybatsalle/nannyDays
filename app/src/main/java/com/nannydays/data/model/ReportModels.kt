package com.nannydays.data.model

/**
 * Data class containing a child and their care session summary.
 */
data class ChildWithSummary(
    val child: Child,
    val totalHours: Float,
    val sessionCount: Int,
    val hasActiveSession: Boolean
)

/**
 * Data class for report generation with detailed session information.
 */
data class ChildReport(
    val child: Child,
    val sessions: List<CareSession>,
    val totalHours: Float,
    val startDate: Long,
    val endDate: Long
)

/**
 * Data class for daily summary.
 */
data class DailySummary(
    val date: Long,
    val childId: String,
    val childName: String,
    val totalHours: Float,
    val sessionCount: Int
)
