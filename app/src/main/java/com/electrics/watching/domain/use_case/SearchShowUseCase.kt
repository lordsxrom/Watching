package com.electrics.watching.domain.use_case

import com.electrics.watching.data.repository.SearchRepository
import com.electrics.watching.data.utils.Result2
import com.electrics.watching.domain.models.SearchResponse
import javax.inject.Inject

class SearchShowUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {

    suspend operator fun invoke(q: String): Result2<SearchResponse> {
        return searchRepository.searchShows(q)
    }

}