package com.electrics.watching.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ScheduleItemEntity(
    @PrimaryKey val id: Int,
    val name: String
)
