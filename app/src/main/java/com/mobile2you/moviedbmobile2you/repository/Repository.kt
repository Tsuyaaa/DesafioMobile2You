package com.mobile2you.moviedbmobile2you.repository

import com.mobile2you.moviedbmobile2you.api.RetrofitInstance
import com.mobile2you.moviedbmobile2you.model.MovieDetails
import com.mobile2you.moviedbmobile2you.model.MoviesList
import retrofit2.Response

class Repository {

    suspend fun listPopularMovies(): Response<MoviesList>{
        return RetrofitInstance.api.getPopularMovies()
    }

    suspend fun listTopRatedMovies(): Response<MoviesList>{
        return RetrofitInstance.api.getTopRatedMovies()
    }

    suspend fun listPlayingNow(): Response<MoviesList>{
        return RetrofitInstance.api.getPlayingNow()
    }


    suspend fun getMovieDetails(movieId: Int): Response<MovieDetails>{
        return RetrofitInstance.api.getMovieDetail(movieId)
    }

    suspend fun getSimilar(movieId: Int):Response<MoviesList>{
        return RetrofitInstance.api.getSimilar(movieId)
    }


/*
    fun getPopularMovies(page: Int = 1) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<MoviesList> {
                override fun onResponse(
                    call: Call<MoviesList>,
                    response: Response<MoviesList>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("Repository", "Movies: ${responseBody.movies}")
                        } else {
                            Log.d("Repository", "Falha na conexão")
                        }
                    }
                }

                override fun onFailure(call: Call<MoviesList>, t: Throwable) {
                    Log.e("Repository", "onFailure", t)
                }

            })
    }
     */
}