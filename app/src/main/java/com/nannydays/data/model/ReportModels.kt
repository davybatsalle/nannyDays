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
    val endDate: Long,
    /** Days in range whose total completed hours are at least [TAX_DAY_THRESHOLD_HOURS] (includes exactly 8 h). */
    val taxDaysOverThreshold: Int = 0,
    /** Sum of completed hours on days whose daily total is strictly less than [TAX_DAY_THRESHOLD_HOURS]. */
    val taxHoursOnDaysBelowThreshold: Float = 0f
) {
    companion object {
        const val TAX_DAY_THRESHOLD_HOURS = 8f
    }
}

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
