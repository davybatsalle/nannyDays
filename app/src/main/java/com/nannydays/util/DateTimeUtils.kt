package com.nannydays.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Utility class for date and time formatting operations.
 */
object DateTimeUtils {
    
    private val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    private val dateTimeFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
    private val shortDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    
    /**
     * Formats epoch millis to date string (e.g., "Mar 20, 2026")
     */
    fun formatDate(millis: Long): String {
        return dateFormat.format(Date(millis))
    }
    
    /**
     * Formats epoch millis to time string (e.g., "14:30")
     */
    fun formatTime(millis: Long): String {
        return timeFormat.format(Date(millis))
    }
    
    /**
     * Formats epoch millis to date-time string (e.g., "Mar 20, 2026 14:30")
     */
    fun formatDateTime(millis: Long): String {
        return dateTimeFormat.format(Date(millis))
    }
    
    /**
     * Formats epoch millis to short date string (e.g., "20/03/2026")
     */
    fun formatShortDate(millis: Long): String {
        return shortDateFormat.format(Date(millis))
    }
    
    /**
     * Formats duration in hours to readable string (e.g., "2h 30m")
     */
    fun formatDuration(hours: Float): String {
        val totalMinutes = (hours * 60).toInt()
        val h = totalMinutes / 60
        val m = totalMinutes % 60
        return when {
            h > 0 && m > 0 -> "${h}h ${m}m"
            h > 0 -> "${h}h"
            else -> "${m}m"
        }
    }
    
    /**
     * Formats minutes to readable string (e.g., "2h 30m")
     */
    fun formatMinutes(minutes: Long): String {
        val h = minutes / 60
        val m = minutes % 60
        return when {
            h > 0 && m > 0 -> "${h}h ${m}m"
            h > 0 -> "${h}h"
            else -> "${m}m"
        }
    }
    
    /**
     * Calculates age from birth date in millis.
     */
    fun calculateAge(birthDateMillis: Long): Int {
        val birthCalendar = Calendar.getInstance().apply { timeInMillis = birthDateMillis }
        val todayCalendar = Calendar.getInstance()
        
        var age = todayCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR)
        if (todayCalendar.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age
    }
    
    /**
     * Gets start of day epoch millis for a given date.
     */
    fun getStartOfDay(millis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }
    
    /**
     * Gets end of day epoch millis for a given date.
     */
    fun getEndOfDay(millis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }
        return calendar.timeInMillis
    }
    
    /**
     * Gets start of week epoch millis.
     */
    fun getStartOfWeek(millis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = millis
            firstDayOfWeek = Calendar.MONDAY
            set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }
    
    /**
     * Gets end of week epoch millis.
     */
    fun getEndOfWeek(millis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = millis
            firstDayOfWeek = Calendar.MONDAY
            set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }
        return calendar.timeInMillis
    }
    
    /**
     * Gets start of month epoch millis.
     */
    fun getStartOfMonth(millis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.DAY_OF_MONTH, 1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }
    
    /**
     * Gets end of month epoch millis.
     */
    fun getEndOfMonth(millis: Long): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.DAY_OF_MONTH, getActualMaximum(Calendar.DAY_OF_MONTH))
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }
        return calendar.timeInMillis
    }
}
