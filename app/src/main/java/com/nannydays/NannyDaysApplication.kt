package com.nannydays

import android.app.Application
import com.nannydays.data.NannyDaysDatabase
import com.nannydays.data.repository.ChildRepository
import com.nannydays.data.repository.CareSessionRepository

/**
 * Application class for NannyDays app.
 * Provides singleton instances of database and repositories.
 */
class NannyDaysApplication : Application() {
    
    val database by lazy { NannyDaysDatabase.getDatabase(this) }
    val childRepository by lazy { ChildRepository(database.childDao()) }
    val careSessionRepository by lazy { CareSessionRepository(database.careSessionDao()) }
}
