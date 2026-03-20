package com.nannydays.data.dao

import androidx.room.*
import com.nannydays.data.model.Child
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Child entity operations.
 */
@Dao
interface ChildDao {
    
    @Query("SELECT * FROM children ORDER BY name ASC")
    fun getAllChildren(): Flow<List<Child>>
    
    @Query("SELECT * FROM children WHERE id = :childId")
    fun getChildById(childId: String): Flow<Child?>
    
    @Query("SELECT * FROM children WHERE id = :childId")
    suspend fun getChildByIdSync(childId: String): Child?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChild(child: Child)
    
    @Update
    suspend fun updateChild(child: Child)
    
    @Delete
    suspend fun deleteChild(child: Child)
    
    @Query("DELETE FROM children WHERE id = :childId")
    suspend fun deleteChildById(childId: String)
    
    @Query("SELECT COUNT(*) FROM children")
    fun getChildCount(): Flow<Int>
}
