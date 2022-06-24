package com.mobile2you.moviedbmobile2you.adapter

import com.mobile2you.moviedbmobile2you.model.ItemDaListaDeFilme
import com.mobile2you.moviedbmobile2you.model.MovieDetails
import com.mobile2you.moviedbmobile2you.model.MoviesList

interface TaskItemClickListener {
    fun onTaskClicked(poster: MovieDetails)
}