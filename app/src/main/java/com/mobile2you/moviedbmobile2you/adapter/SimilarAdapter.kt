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

class SimilarAdapter(
    private val taskItemClickListener: com.mobile2you.moviedbmobile2you.MovieDetails,
    private val mainViewModel: MainViewModel,
    private val context: Context
): RecyclerView.Adapter<SimilarAdapter.SimilarHolder>() {

    private var listMovies = listOf<MovieDetails>()

    class SimilarHolder(view: View): RecyclerView.ViewHolder(view) {
        val imagePoster = view.findViewById<ImageView>(R.id.item_movie_poster)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimilarHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.poster_movies, parent, false)

        return SimilarHolder(layout)

    }

    override fun onBindViewHolder(holder: SimilarHolder, position: Int) {
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

    fun setListSimilar(movie: MoviesList){
        listMovies = movie.results!!

        notifyItemInserted(listMovies.size + 1)
    }



}