package com.nannydays.data.dao;

/**
 * Data Access Object for Child entity operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fH\'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/nannydays/data/dao/ChildDao;", "", "deleteChild", "", "child", "Lcom/nannydays/data/model/Child;", "(Lcom/nannydays/data/model/Child;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChildById", "childId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllChildren", "Lkotlinx/coroutines/flow/Flow;", "", "getChildById", "getChildByIdSync", "getChildCount", "", "insertChild", "updateChild", "app_debug"})
@androidx.room.Dao()
public abstract interface ChildDao {
    
    @androidx.room.Query(value = "SELECT * FROM children ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nannydays.data.model.Child>> getAllChildren();
    
    @androidx.room.Query(value = "SELECT * FROM children WHERE id = :childId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nannydays.data.model.Child> getChildById(@org.jetbrains.annotations.NotNull()
    java.lang.String childId);
    
    @androidx.room.Query(value = "SELECT * FROM children WHERE id = :childId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getChildByIdSync(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nannydays.data.model.Child> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertChild(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateChild(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteChild(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM children WHERE id = :childId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteChildById(@org.jetbrains.annotations.NotNull()
    java.lang.String childId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM children")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getChildCount();
}