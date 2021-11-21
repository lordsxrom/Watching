package com.electrics.watching.data.remote.api

import com.electrics.watching.data.remote.response.ScheduleResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface ScheduleApi {

    /*
    The full schedule is a list of all future episodes known to TVmaze, regardless of their
    country. Be advised that this endpoint's response is at least several MB large. As opposed
    to the other endpoints, results are cached for 24 hours.

    URL: /schedule/full
    Example: https://api.tvmaze.com/schedule/full
     */
    @GET("/schedule/full")
    suspend fun getSchedule(): Response<ScheduleResponseDto>

}