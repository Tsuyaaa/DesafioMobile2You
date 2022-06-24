package com.mobile2you.moviedbmobile2you.api

import com.mobile2you.moviedbmobile2you.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface ApiService {

    @GET("3/movie/popular?api_key=19a64f81a4370769f5177f4bffb7ae9b&page=")
    suspend fun getPopularMovies(): Response<MoviesList>

    @GET("3/movie/top_rated?api_key=19a64f81a4370769f5177f4bffb7ae9b&page=1")
    suspend fun getTopRatedMovies(): Response<MoviesList>

    @GET("3/movie/now_playing?api_key=19a64f81a4370769f5177f4bffb7ae9b&page=1")
    suspend fun getPlayingNow(): Response<MoviesList>

    @GET("3/movie/{movie_id}?api_key=19a64f81a4370769f5177f4bffb7ae9b")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): Response<MovieDetails>

    @GET("3/movie/{movie_id}/similar?api_key=19a64f81a4370769f5177f4bffb7ae9b&page=1")
    suspend fun getSimilar(@Path("movie_id")movieId: Int): Response<MoviesList>


    /*
    @GET("3/movie/550?api_key=19a64f81a4370769f5177f4bffb7ae9b")
    suspend fun getMovieDetail(): Response<MovieDetails>

     */



}