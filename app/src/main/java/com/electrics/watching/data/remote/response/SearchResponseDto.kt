package com.electrics.watching.data.remote.response


import com.google.gson.annotations.SerializedName

class SearchResponseDto : ArrayList<SearchResponseItemDto>()

data class SearchResponseItemDto(
    @SerializedName("score")
    val score: Double?,
    @SerializedName("show")
    val show: ShowDto
)