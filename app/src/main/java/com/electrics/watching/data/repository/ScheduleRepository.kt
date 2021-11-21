package com.electrics.watching.data.repository

import com.electrics.watching.data.mapper.ScheduleResponseMapper
import com.electrics.watching.data.remote.api.ScheduleApi
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.data.utils.execute
import com.electrics.watching.data.utils.map
import com.electrics.watching.data.utils.toResult
import com.electrics.watching.domain.models.ScheduleResponse
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val scheduleApi: ScheduleApi,
    private val scheduleResponseMapper: ScheduleResponseMapper
) {

    suspend fun getSchedule(): Result2<ScheduleResponse> {
        return execute {
            scheduleApi.getSchedule()
                .toResult()
                .map { dto ->
                    scheduleResponseMapper.map(dto)
                }
        }
    }

}