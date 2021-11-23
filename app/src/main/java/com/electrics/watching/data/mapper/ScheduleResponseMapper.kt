package com.electrics.watching.data.mapper

import com.electrics.watching.data.remote.response.ScheduleResponseItemDto
import com.electrics.watching.domain.models.ScheduleItem
import javax.inject.Inject

class ScheduleResponseMapper @Inject constructor() {

    fun map(dto: ScheduleResponseItemDto): ScheduleItem {
        return ScheduleItem(
            id = dto.id,
            name = dto.name ?: ""
        )
    }

}