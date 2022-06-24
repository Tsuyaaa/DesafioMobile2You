package com.mobile2you.moviedbmobile2you.model

import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("page") val page: Int?,
    @SerializedName("results") val results: List<MovieDetails>?

    )

