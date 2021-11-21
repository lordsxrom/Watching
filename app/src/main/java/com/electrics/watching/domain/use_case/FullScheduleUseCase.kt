package com.electrics.watching.domain.use_case

import com.electrics.watching.data.repository.ScheduleRepository
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.domain.models.ScheduleResponse
import javax.inject.Inject

class FullScheduleUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    suspend operator fun invoke(): Result2<ScheduleResponse> {
        return scheduleRepository.getSchedule()
    }

}