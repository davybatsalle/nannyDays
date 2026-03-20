package com.nannydays.data;

/**
 * Room Database for the NannyDays application.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/nannydays/data/NannyDaysDatabase;", "Landroidx/room/RoomDatabase;", "()V", "careSessionDao", "Lcom/nannydays/data/dao/CareSessionDao;", "childDao", "Lcom/nannydays/data/dao/ChildDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.nannydays.data.model.Child.class, com.nannydays.data.model.CareSession.class}, version = 1, exportSchema = false)
public abstract class NannyDaysDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.nannydays.data.NannyDaysDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.nannydays.data.NannyDaysDatabase.Companion Companion = null;
    
    public NannyDaysDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nannydays.data.dao.ChildDao childDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nannydays.data.dao.CareSessionDao careSessionDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/nannydays/data/NannyDaysDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/nannydays/data/NannyDaysDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.nannydays.data.NannyDaysDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}