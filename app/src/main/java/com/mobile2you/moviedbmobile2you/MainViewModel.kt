package com.mobile2you.moviedbmobile2you

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile2you.moviedbmobile2you.model.*
import com.mobile2you.moviedbmobile2you.model.MovieDetails
import com.mobile2you.moviedbmobile2you.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository

): ViewModel() {
    var posterClicked: MovieDetails? = null
    var arrowClicked: MoviesList? = null

    private val _myPopularMoviesResponse = MutableLiveData<Response<MoviesList>>()
    val myPopularMoviesResponse: LiveData<Response<MoviesList>> = _myPopularMoviesResponse

    private val _myTopRatedResponse = MutableLiveData<Response<MoviesList>>()
    val myTopRatedResponse: LiveData<Response<MoviesList>> = _myTopRatedResponse

    private val _myPlayingNowResponse = MutableLiveData<Response<MoviesList>>()
    val myPlayingNowResponse: LiveData<Response<MoviesList>> = _myPlayingNowResponse

    private val _myDetailsResponse = MutableLiveData<Response<MovieDetails>>()
    val myDetailsResponse: LiveData<Response<MovieDetails>> = _myDetailsResponse

    private val _mySimilarResponse = MutableLiveData<Response<MoviesList>>()
    val mySimilarResponse: LiveData<Response<MoviesList>> = _mySimilarResponse



    fun getlistPopular(){
        viewModelScope.launch { try {
            val response = repository.listPopularMovies()
            _myPopularMoviesResponse.value = response
        }catch (e:Exception){
            Log.d("Error", e.message.toString())
        }
        }
    }

    fun getlistTopRated(){
        viewModelScope.launch { try{
            val responseTop = repository.listTopRatedMovies()
            _myTopRatedResponse.value = responseTop
        }catch (e:Exception){
            Log.d("Error", e.message.toString())
        }
        }
    }

    fun getPlayingNow(){
        viewModelScope.launch { try{
            val responseNow = repository.listPlayingNow()
            _myPlayingNowResponse.value = responseNow
        }catch (e: Exception){
            Log.d("Error", e.message.toString())
        }
        }
    }

    fun getDetails(movie_id: Int){
        viewModelScope.launch { try{
            val response = repository.getMovieDetails(movie_id)
            _myDetailsResponse.value = response
        }catch (e: Exception){
            Log.d("Error", e.message.toString())
        }
        }
    }

    fun getSimilar(movie_id: Int){
        viewModelScope.launch { try{
            val responseUp = repository.getSimilar(movie_id)
            _myPlayingNowResponse.value = responseUp
        }catch (e: Exception){
            Log.d("Error", e.message.toString())
        }
        }
    }


    }



