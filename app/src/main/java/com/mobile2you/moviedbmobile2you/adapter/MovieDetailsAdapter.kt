package com.mobile2you.moviedbmobile2you.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mobile2you.moviedbmobile2you.MainViewModel
import com.mobile2you.moviedbmobile2you.R
import com.mobile2you.moviedbmobile2you.model.Genres
import com.mobile2you.moviedbmobile2you.model.MovieDetails

class MovieDetailsAdapter(
    private val mainViewModel: MainViewModel,
    private val context: Context
): RecyclerView.Adapter<MovieDetailsAdapter.DetailsViewHolder>() {

    private var movieDetailsList = emptyList<MovieDetails>()

    class DetailsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textTitle = view.findViewById<TextView>(R.id.movie_title)
        val textRuntime = view.findViewById<TextView>(R.id.movie_runtime)
        val textOverview = view.findViewById<TextView>(R.id.movie_overview)
        val imagePoster = view.findViewById<ImageView>(R.id.movie_poster)
        val imageBack = view.findViewById<ImageView>(R.id.movie_backdrop)
        val textRate = view.findViewById<TextView>(R.id.movie_rate)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): MovieDetailsAdapter.DetailsViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_movie_details, parent, false)

        return DetailsViewHolder(layout)

    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val details = movieDetailsList[position]

        holder.textTitle.text = details.title
        holder.textOverview.text = details.overview
        holder.textRuntime.text = details.runtime.toString()
        holder.textRate.text = details.vote_average.toString()

        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w342${movieDetailsList[position].poster_path}")
            .transform(CenterCrop())
            .into(holder.imagePoster)

        Glide.with(context)
            .load("https://image.tmdb.org/t/p/original${movieDetailsList[position].backdrop_path}")
            .transform(CenterCrop())
            .into(holder.imageBack)

    }

    override fun getItemCount(): Int {
        return movieDetailsList.size
    }

    fun setDetais(lista: List<MovieDetails>){
        movieDetailsList = lista
        notifyDataSetChanged()
    }

}