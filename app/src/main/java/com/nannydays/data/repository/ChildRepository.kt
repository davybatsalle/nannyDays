package com.nannydays.data.repository

import com.nannydays.data.dao.ChildDao
import com.nannydays.data.model.Child
import kotlinx.coroutines.flow.Flow

/**
 * Repository for managing Child data operations.
 */
class ChildRepository(private val childDao: ChildDao) {
    
    val allChildren: Flow<List<Child>> = childDao.getAllChildren()
    
    fun getChildById(childId: String): Flow<Child?> = childDao.getChildById(childId)
    
    suspend fun getChildByIdSync(childId: String): Child? = childDao.getChildByIdSync(childId)
    
    fun getChildCount(): Flow<Int> = childDao.getChildCount()
    
    suspend fun insertChild(child: Child) {
        childDao.insertChild(child)
    }
    
    suspend fun updateChild(child: Child) {
        childDao.updateChild(child.copy(updatedAt = System.currentTimeMillis()))
    }
    
    suspend fun deleteChild(child: Child) {
        childDao.deleteChild(child)
    }
    
    suspend fun deleteChildById(childId: String) {
        childDao.deleteChildById(childId)
    }
}
