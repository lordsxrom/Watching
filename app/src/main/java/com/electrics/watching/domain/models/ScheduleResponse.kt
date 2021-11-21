package com.electrics.watching.domain.models

data class ScheduleResponse(
    val items: List<ScheduleResponseItem>
)

data class ScheduleResponseItem(
    val id: Int,
    val name: String
)