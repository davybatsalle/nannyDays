package com.nannydays.data.dao;

/**
 * Data Access Object for CareSession entity operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\u0006\u0010\r\u001a\u00020\tH\'J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\fH\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\fH\'J\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\r\u001a\u00020\tH\'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\f2\u0006\u0010\r\u001a\u00020\tH\'J,\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\'J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u00a7@\u00a2\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\'J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\f2\u0006\u0010\r\u001a\u00020\tH\'J(\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\'J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006#"}, d2 = {"Lcom/nannydays/data/dao/CareSessionDao;", "", "deleteSession", "", "session", "Lcom/nannydays/data/model/CareSession;", "(Lcom/nannydays/data/model/CareSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSessionById", "sessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSessionForChild", "Lkotlinx/coroutines/flow/Flow;", "childId", "getActiveSessionForChildSync", "getAllActiveSessions", "", "getAllSessions", "getSessionById", "getSessionByIdSync", "getSessionCountForChild", "", "getSessionsByChildId", "getSessionsByChildIdAndDateRange", "startTime", "", "endTime", "getSessionsByChildIdAndDateRangeSync", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsByDateRange", "getTotalHoursForChild", "", "getTotalHoursForChildInRange", "insertSession", "updateSession", "app_debug"})
@androidx.room.Dao()
public abstract interface CareSessionDao {
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions ORDER BY checkInTime DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getAllSessions();
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions WHERE childId = :childId ORDER BY checkInTime DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsByChildId(@org.jetbrains.annotations.NotNull()
    java.lang.String childId);
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions WHERE id = :sessionId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nannydays.data.model.CareSession> getSessionById(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId);
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions WHERE id = :sessionId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessionByIdSync(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nannydays.data.model.CareSession> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions WHERE childId = :childId AND checkOutTime IS NULL LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nannydays.data.model.CareSession> getActiveSessionForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId);
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions WHERE childId = :childId AND checkOutTime IS NULL LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActiveSessionForChildSync(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nannydays.data.model.CareSession> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM care_sessions WHERE checkOutTime IS NULL")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getAllActiveSessions();
    
    @androidx.room.Query(value = "\n        SELECT * FROM care_sessions \n        WHERE childId = :childId \n        AND checkInTime >= :startTime \n        AND checkInTime <= :endTime \n        ORDER BY checkInTime ASC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsByChildIdAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, long startTime, long endTime);
    
    @androidx.room.Query(value = "\n        SELECT * FROM care_sessions \n        WHERE childId = :childId \n        AND checkInTime >= :startTime \n        AND checkInTime <= :endTime \n        ORDER BY checkInTime ASC\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessionsByChildIdAndDateRangeSync(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, long startTime, long endTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.nannydays.data.model.CareSession>> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM care_sessions \n        WHERE checkInTime >= :startTime \n        AND checkInTime <= :endTime \n        ORDER BY checkInTime DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.CareSession>> getSessionsByDateRange(long startTime, long endTime);
    
    @androidx.room.Query(value = "\n        SELECT SUM(\n            CASE \n                WHEN checkOutTime IS NOT NULL THEN (checkOutTime - checkInTime) \n                ELSE 0 \n            END\n        ) / 3600000.0 \n        FROM care_sessions \n        WHERE childId = :childId\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Float> getTotalHoursForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId);
    
    @androidx.room.Query(value = "\n        SELECT SUM(\n            CASE \n                WHEN checkOutTime IS NOT NULL THEN (checkOutTime - checkInTime) \n                ELSE 0 \n            END\n        ) / 3600000.0 \n        FROM care_sessions \n        WHERE childId = :childId \n        AND checkInTime >= :startTime \n        AND checkInTime <= :endTime\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Float> getTotalHoursForChildInRange(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, long startTime, long endTime);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM care_sessions WHERE childId = :childId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getSessionCountForChild(@org.jetbrains.annotations.NotNull()
    java.lang.String childId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSession(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.CareSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM care_sessions WHERE id = :sessionId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSessionById(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}