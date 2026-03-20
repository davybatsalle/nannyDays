package com.nannydays.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nannydays.data.dao.ChildDao
import com.nannydays.data.dao.CareSessionDao
import com.nannydays.data.model.Child
import com.nannydays.data.model.CareSession

/**
 * Room Database for the NannyDays application.
 */
@Database(
    entities = [Child::class, CareSession::class],
    version = 1,
    exportSchema = false
)
abstract class NannyDaysDatabase : RoomDatabase() {
    
    abstract fun childDao(): ChildDao
    abstract fun careSessionDao(): CareSessionDao
    
    companion object {
        @Volatile
        private var INSTANCE: NannyDaysDatabase? = null
        
        fun getDatabase(context: Context): NannyDaysDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NannyDaysDatabase::class.java,
                    "nannydays_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
