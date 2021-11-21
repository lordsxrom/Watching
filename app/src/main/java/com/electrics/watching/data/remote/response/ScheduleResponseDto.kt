package com.electrics.watching.data.remote.response


import com.google.gson.annotations.SerializedName

class ScheduleResponseDto : ArrayList<ScheduleResponseItemDto>()

data class ScheduleResponseItemDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("airdate")
    val airdate: String?,
    @SerializedName("airstamp")
    val airstamp: String?,
    @SerializedName("airtime")
    val airtime: String?,
    @SerializedName("_embedded")
    val embedded: EmbeddedDto?,
    @SerializedName("image")
    val image: ImageDtoX?,
    @SerializedName("_links")
    val links: LinksDtoX?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("rating")
    val rating: RatingDtoX?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("season")
    val season: Int?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

data class EmbeddedDto(
    @SerializedName("show")
    val show: ShowDto?
)

data class ImageDtoX(
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("original")
    val original: String?
)

data class LinksDtoX(
    @SerializedName("self")
    val self: SelfDtoX?
)

data class SelfDtoX(
    @SerializedName("href")
    val href: String?
)

data class RatingDtoX(
    @SerializedName("average")
    val average: Any?
)