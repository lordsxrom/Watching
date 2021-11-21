package com.electrics.watching.data.mapper

import com.electrics.watching.data.remote.response.SearchResponseDto
import com.electrics.watching.domain.models.SearchResponse
import com.electrics.watching.domain.models.SearchResponseItem
import com.electrics.watching.domain.models.Show
import javax.inject.Inject

class SearchResponseMapper @Inject constructor() {

    fun map(dto: SearchResponseDto?): SearchResponse {
        return SearchResponse(
            items = dto?.mapNotNull { itemDto ->
                SearchResponseItem(
                    score = itemDto.score ?: 0.0,
                    show = Show(
                        id = itemDto.show.id,
                        summary = itemDto.show.summary ?: ""
                    )
                )
            } ?: emptyList()
        )
    }

}