package com.electrics.watching.data.remote.api

import com.electrics.watching.data.remote.response.SearchResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/search/shows")
    suspend fun searchShows(@Query("q") q: String): Response<SearchResponseDto>

}