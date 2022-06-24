package com.mobile2you.moviedbmobile2you.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mobile2you.moviedbmobile2you.MainViewModel
import com.mobile2you.moviedbmobile2you.R
import com.mobile2you.moviedbmobile2you.model.MovieDetails
import com.mobile2you.moviedbmobile2you.model.MoviesList

class MoviesListAdapter(
    private val taskItemClickListener: TaskItemClickListener,
    private val mainViewModel: MainViewModel,
    private val context: Context
    ): RecyclerView.Adapter<MoviesListAdapter.MovieListHolder>() {

    private var listMovies = listOf<MovieDetails>()



    class MovieListHolder(view: View): RecyclerView.ViewHolder(view) {
        val imagePoster = view.findViewById<ImageView>(R.id.item_movie_poster)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieListHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.poster_movies, parent, false)

        return MovieListHolder(layout)

    }

    override fun onBindViewHolder(holder: MovieListHolder, position: Int) {
        //val listaDeFilme = listMovies[position]

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w342${listMovies[position].poster_path}")
                .transform(CenterCrop())
                .into(holder.imagePoster)

        holder.itemView.setOnClickListener{
            taskItemClickListener.onTaskClicked(listMovies[position])

        }




    }

    override fun getItemCount(): Int {
        return listMovies.size

    }

    fun setList(movie: MoviesList){
        listMovies = movie.results!!

        notifyItemInserted(listMovies.size + 1)
    }

    /*
    fun setListTop(top: MovieListTopRated){
        listMoviesTop = top.results!!

        notifyItemInserted(listMoviesTop.size + 1)
    }
     */

    /*
    fun setListNow(now: MovieListPlayingNow){
        listMoviesNow = now.results!!

        notifyItemInserted(listMoviesNow.size + 1)
    }
     */


}