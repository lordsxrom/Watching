package com.electrics.watching.data.mapper

import com.electrics.watching.data.remote.response.SearchResponseDto
import com.electrics.watching.domain.models.SearchItem
import com.electrics.watching.domain.models.Show
import javax.inject.Inject

class SearchResponseMapper @Inject constructor() {

    fun map(dto: SearchResponseDto?): List<SearchItem>? {
        return dto?.mapNotNull { itemDto ->
            SearchItem(
                score = itemDto.score ?: 0.0,
                show = Show(
                    id = itemDto.show.id,
                    name = itemDto.show.name ?: "",
                    summary = itemDto.show.summary ?: ""
                )
            )
        }
    }
}