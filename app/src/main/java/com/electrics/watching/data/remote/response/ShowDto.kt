package com.electrics.watching.data.remote.response

import com.google.gson.annotations.SerializedName

data class ShowDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("averageRuntime")
    val averageRuntime: Int?,
    @SerializedName("dvdCountry")
    val dvdCountry: Any?,
    @SerializedName("ended")
    val ended: Any?,
    @SerializedName("externals")
    val externals: ExternalsDto?,
    @SerializedName("genres")
    val genres: List<String>?,
    @SerializedName("image")
    val image: ImageDto?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("_links")
    val links: LinksDto?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("network")
    val network: Any?,
    @SerializedName("officialSite")
    val officialSite: String?,
    @SerializedName("premiered")
    val premiered: String?,
    @SerializedName("rating")
    val rating: RatingDto?,
    @SerializedName("runtime")
    val runtime: Any?,
    @SerializedName("schedule")
    val schedule: ScheduleDto?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("updated")
    val updated: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("webChannel")
    val webChannel: WebChannelDto?,
    @SerializedName("weight")
    val weight: Int?
)

data class ExternalsDto(
    @SerializedName("imdb")
    val imdb: Any?,
    @SerializedName("thetvdb")
    val thetvdb: Any?,
    @SerializedName("tvrage")
    val tvrage: Any?
)

data class ImageDto(
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("original")
    val original: String?
)

data class LinksDto(
    @SerializedName("previousepisode")
    val previousepisode: PreviousepisodeDto?,
    @SerializedName("self")
    val self: SelfDto?
)

data class RatingDto(
    @SerializedName("average")
    val average: Any?
)

data class ScheduleDto(
    @SerializedName("days")
    val days: List<Any>?,
    @SerializedName("time")
    val time: String?
)

data class WebChannelDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("country")
    val country: Any?,
    @SerializedName("name")
    val name: String?
)

data class PreviousepisodeDto(
    @SerializedName("href")
    val href: String?
)

data class SelfDto(
    @SerializedName("href")
    val href: String?
)