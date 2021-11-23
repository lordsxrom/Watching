package com.electrics.watching.domain.use_case

import com.electrics.watching.data.repository.ScheduleRepository
import com.electrics.watching.domain.models.ScheduleItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FullScheduleUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {

    suspend operator fun invoke(): Flow<List<ScheduleItem>> {
        return scheduleRepository.getSchedule()
    }

}