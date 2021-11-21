package com.electrics.watching.data.mapper

import com.electrics.watching.data.remote.response.ScheduleResponseDto
import com.electrics.watching.domain.models.ScheduleResponse
import com.electrics.watching.domain.models.ScheduleResponseItem
import javax.inject.Inject

class ScheduleResponseMapper @Inject constructor() {

    fun map(dto: ScheduleResponseDto?): ScheduleResponse {
        return ScheduleResponse(
            items = dto?.mapNotNull { itemDto ->
                ScheduleResponseItem(
                    id = itemDto.id,
                    name = itemDto.name ?: ""
                )
            } ?: emptyList()
        )
    }

}