package com.mobile2you.moviedbmobile2you.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("overview")val overview: String?,
    @SerializedName("genres_ids")val genres: List<Int>,
    @SerializedName("title")val title: String?,
    @SerializedName("backdrop_path")val backdrop_path: String?,
    @SerializedName("vote_average")val vote_average: Float?,
    @SerializedName("runtime")val runtime: Int?,
    @SerializedName("id") val id: Int?
)