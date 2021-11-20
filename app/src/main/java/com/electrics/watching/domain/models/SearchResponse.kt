package com.electrics.watching.domain.models

data class SearchResponse(
    val items: List<SearchResponseItem>
)

data class SearchResponseItem(
    val score: Double,
    val show: Show
)

data class Show(
    val id: Int,
    val summary: String
)