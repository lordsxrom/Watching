package com.electrics.watching.data.mapper

import com.electrics.watching.data.local.entity.ScheduleItemEntity
import com.electrics.watching.domain.models.ScheduleItem
import javax.inject.Inject

class ScheduleEntityMapper @Inject constructor() {

    fun map(entity: ScheduleItemEntity): ScheduleItem {
        return ScheduleItem(
            id = entity.id,
            name = entity.name
        )
    }

    fun map(entity: ScheduleItem): ScheduleItemEntity {
        return ScheduleItemEntity(
            id = entity.id,
            name = entity.name
        )
    }

}