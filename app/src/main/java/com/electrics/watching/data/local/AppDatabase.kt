package com.electrics.watching.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.electrics.watching.data.local.dao.ScheduleDao
import com.electrics.watching.data.local.entity.ScheduleItemEntity

@Database(entities = [ScheduleItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

}