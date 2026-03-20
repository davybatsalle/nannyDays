package com.nannydays.util;

/**
 * Utility class for date and time formatting operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/nannydays/util/DateTimeUtils;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "dateTimeFormat", "shortDateFormat", "timeFormat", "calculateAge", "", "birthDateMillis", "", "formatDate", "", "millis", "formatDateTime", "formatDuration", "hours", "", "formatMinutes", "minutes", "formatShortDate", "formatTime", "getEndOfDay", "getEndOfMonth", "getEndOfWeek", "getStartOfDay", "getStartOfMonth", "getStartOfWeek", "app_debug"})
public final class DateTimeUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat dateFormat = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat timeFormat = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat dateTimeFormat = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat shortDateFormat = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.nannydays.util.DateTimeUtils INSTANCE = null;
    
    private DateTimeUtils() {
        super();
    }
    
    /**
     * Formats epoch millis to date string (e.g., "Mar 20, 2026")
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDate(long millis) {
        return null;
    }
    
    /**
     * Formats epoch millis to time string (e.g., "14:30")
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatTime(long millis) {
        return null;
    }
    
    /**
     * Formats epoch millis to date-time string (e.g., "Mar 20, 2026 14:30")
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDateTime(long millis) {
        return null;
    }
    
    /**
     * Formats epoch millis to short date string (e.g., "20/03/2026")
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatShortDate(long millis) {
        return null;
    }
    
    /**
     * Formats duration in hours to readable string (e.g., "2h 30m")
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDuration(float hours) {
        return null;
    }
    
    /**
     * Formats minutes to readable string (e.g., "2h 30m")
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatMinutes(long minutes) {
        return null;
    }
    
    /**
     * Calculates age from birth date in millis.
     */
    public final int calculateAge(long birthDateMillis) {
        return 0;
    }
    
    /**
     * Gets start of day epoch millis for a given date.
     */
    public final long getStartOfDay(long millis) {
        return 0L;
    }
    
    /**
     * Gets end of day epoch millis for a given date.
     */
    public final long getEndOfDay(long millis) {
        return 0L;
    }
    
    /**
     * Gets start of week epoch millis.
     */
    public final long getStartOfWeek(long millis) {
        return 0L;
    }
    
    /**
     * Gets end of week epoch millis.
     */
    public final long getEndOfWeek(long millis) {
        return 0L;
    }
    
    /**
     * Gets start of month epoch millis.
     */
    public final long getStartOfMonth(long millis) {
        return 0L;
    }
    
    /**
     * Gets end of month epoch millis.
     */
    public final long getEndOfMonth(long millis) {
        return 0L;
    }
}