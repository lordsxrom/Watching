package com.electrics.watching.data.local.dao

import androidx.room.*
import com.electrics.watching.data.local.entity.ScheduleItemEntity

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM scheduleitementity")
    suspend fun select(): List<ScheduleItemEntity>

    @Query("SELECT * FROM scheduleitementity WHERE id = :id")
    suspend fun select(id: Int): ScheduleItemEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<ScheduleItemEntity>)

    @Query("DELETE FROM scheduleitementity")
    suspend fun deleteAll()

}