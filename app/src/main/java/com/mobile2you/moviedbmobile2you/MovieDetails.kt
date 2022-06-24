package com.mobile2you.moviedbmobile2you

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mobile2you.moviedbmobile2you.adapter.TaskItemClickListener
import com.mobile2you.moviedbmobile2you.adapter.SimilarAdapter
import com.mobile2you.moviedbmobile2you.databinding.FragmentMovieDetailsBinding
import com.mobile2you.moviedbmobile2you.model.MovieDetails


class MovieDetails : Fragment(), TaskItemClickListener{

    private lateinit var binding: FragmentMovieDetailsBinding
    private val mainViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mainViewModel.getSimilar(mainViewModel.posterClicked?.id!!)
        mainViewModel.getDetails(mainViewModel.posterClicked?.id!!)

        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)

        val adapterUp = SimilarAdapter(this,mainViewModel,requireContext())

        binding.moviesSimiliar.layoutManager = LinearLayoutManager(context,
        LinearLayoutManager.HORIZONTAL,false)
        binding.moviesSimiliar.adapter = adapterUp

        mainViewModel.myDetailsResponse.observe(viewLifecycleOwner){
            response -> if(response != null){
                Log.d("Details", response.body()!!.toString())
            buildPoster(response.body()!!)
            }
        }
        mainViewModel.mySimilarResponse.observe(viewLifecycleOwner){
            response -> if (response != null){
                adapterUp.setListSimilar(response.body()!!)
                Log.d("Similar", response.body()!!.toString())
        }
        }

        /*
        binding.backArrow.setOnClickListener(){
            mainViewModel.arrowClicked = null
            findNavController().navigate(R.id.action_movieDetails_to_listMovies)
        }

         */



        return binding.root
    }

    private fun buildPoster(movieDetails: MovieDetails){
        binding.movieTitle.text = movieDetails.title
        binding.movieOverview.text = movieDetails.overview
        binding.movieRuntime.text = movieDetails.runtime.toString()
        binding.movieRate.text = movieDetails.vote_average.toString()
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w342${movieDetails.poster_path}")
            .transform(CenterCrop())
            .into(binding.moviePoster)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w780${movieDetails.backdrop_path}")
            .transform(CenterCrop())
            .into(binding.movieBackdrop)

    }

    override fun onTaskClicked(poster: MovieDetails) {
        mainViewModel.posterClicked = poster
        findNavController().navigate(R.id.action_movieDetails_self)
    }

}