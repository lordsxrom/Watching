package com.electrics.watching.data.repository

import com.electrics.watching.data.mapper.SearchResponseMapper
import com.electrics.watching.data.remote.api.SearchApi
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.data.utils.execute
import com.electrics.watching.data.utils.map
import com.electrics.watching.data.utils.toResult
import com.electrics.watching.domain.models.SearchItem
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val searchApi: SearchApi,
    private val searchResponseMapper: SearchResponseMapper
) {

    suspend fun searchShows(q: String): Result2<List<SearchItem>?> {
        return execute {
            searchApi.searchShows(q)
                .toResult()
                .map { dto -> searchResponseMapper.map(dto) }
        }
    }

}