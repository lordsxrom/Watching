package com.electrics.watching.data.remote.api

import com.electrics.watching.data.remote.response.SearchResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    /*
    Search through all the shows in our database by the show's name. A fuzzy algorithm is used
    (with a fuzziness value of 2), meaning that shows will be found even if your query contains
    small typos. Results are returned in order of relevancy (best matches on top) and contain each
    show's full information.

    The most common usecase for this endpoint is when you're building a local mapping of show
    names to TVmaze ID's and want to make sure that you're mapping to exactly the right show,
    and not to a different show that happens to have the same name. By presenting each show's basic
    information in a UI, you can have the end-user pick a specific entry from that list, and have
    your application store the chosen show's ID or URL. Any subsequent requests for information on
    that show can then be directly made to that show's URL.

    URL: /search/shows?q=:query
    Example: https://api.tvmaze.com/search/shows?q=girls
     */
    @GET("/search/shows")
    suspend fun searchShows(@Query("q") q: String): Response<SearchResponseDto>

}