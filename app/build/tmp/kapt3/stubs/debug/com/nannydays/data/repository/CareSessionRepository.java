package com.nannydays.data.repository;

/**
 * Repository for managing CareSession data operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u0012\u001a\u00020\rJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\f\u001a\u00020\rJ*\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J,\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u0010\'J\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u00062\u0006\u0010\f\u001a\u00020\rJ&\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u0016\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010-\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0018R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/nannydays/data/repository/CareSessionRepository;", "", "careSessionDao", "Lcom/nannydays/data/dao/CareSessionDao;", "(Lcom/nannydays/data/dao/CareSessionDao;)V", "allSessions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nannydays/data/model/CareSession;", "getAllSessions", "()Lkotlinx/coroutines/flow/Flow;", "checkIn", "childId", "", "notes", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOut", "", "sessionId", "checkOutByChildId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSession", "", "session", "(Lcom/nannydays/data/model/CareSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSessionById", "getActiveSessionForChild", "getActiveSessionForChildSync", "getAllActiveSessions", "getSessionById", "getSessionByIdSync", "getSessionCountForChild", "", "getSessionsByChildId", "getSessionsByChildIdAndDateRange", "startTime", "", "endTime", "getSessionsByChildIdAndDateRangeSync", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsByDateRange", "getTotalHoursForChild", "", "getTotalHoursForChildInRange", "insertSession", "updateSession", "app_debug"})
public final class CareSessionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nannydays.data.dao.CareSessionDao careSessionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> allSessions = null;
    
    public CareSessionRepository(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.dao.CareSessionDao careSessionDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getAllSessions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsByChildId(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.nannydays.data.model.CareSession> getSessionById(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionByIdSync(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nannydays.data.model.CareSession> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.nannydays.data.model.CareSession> getActiveSessionForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getActiveSessionForChildSync(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nannydays.data.model.CareSession> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getAllActiveSessions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsByDateRange(long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsByChildIdAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionsByChildIdAndDateRangeSync(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, long startTime, long endTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.nannydays.data.model.CareSession>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getTotalHoursForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getTotalHoursForChildInRange(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getSessionCountForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId) {
        return null;
    }
    
    /**
     * Check in a child - start a new care session.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkIn(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    java.lang.String notes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nannydays.data.model.CareSession> $completion) {
        return null;
    }
    
    /**
     * Check out a child - end an active care session.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkOut(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.Nullable()
    java.lang.String notes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Check out a child by child ID - end active session if exists.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkOutByChildId(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteSessionById(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}