package com.nannydays.data.model;

/**
 * Data class for report generation with detailed session information.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/nannydays/data/model/ChildReport;", "", "child", "Lcom/nannydays/data/model/Child;", "sessions", "", "Lcom/nannydays/data/model/CareSession;", "totalHours", "", "startDate", "", "endDate", "(Lcom/nannydays/data/model/Child;Ljava/util/List;FJJ)V", "getChild", "()Lcom/nannydays/data/model/Child;", "getEndDate", "()J", "getSessions", "()Ljava/util/List;", "getStartDate", "getTotalHours", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class ChildReport {
    @org.jetbrains.annotations.NotNull()
    private final com.nannydays.data.model.Child child = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.nannydays.data.model.CareSession> sessions = null;
    private final float totalHours = 0.0F;
    private final long startDate = 0L;
    private final long endDate = 0L;
    
    public ChildReport(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child, @org.jetbrains.annotations.NotNull()
    java.util.List<com.nannydays.data.model.CareSession> sessions, float totalHours, long startDate, long endDate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nannydays.data.model.Child getChild() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.nannydays.data.model.CareSession> getSessions() {
        return null;
    }
    
    public final float getTotalHours() {
        return 0.0F;
    }
    
    public final long getStartDate() {
        return 0L;
    }
    
    public final long getEndDate() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nannydays.data.model.Child component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.nannydays.data.model.CareSession> component2() {
        return null;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nannydays.data.model.ChildReport copy(@org.jetbrains.annotations.NotNull()
    com.nannydays.data.model.Child child, @org.jetbrains.annotations.NotNull()
    java.util.List<com.nannydays.data.model.CareSession> sessions, float totalHours, long startDate, long endDate) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}