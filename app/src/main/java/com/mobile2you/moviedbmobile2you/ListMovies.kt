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
import com.mobile2you.moviedbmobile2you.adapter.MoviesListAdapter
import com.mobile2you.moviedbmobile2you.adapter.NowAdapter
import com.mobile2you.moviedbmobile2you.adapter.TaskItemClickListener
import com.mobile2you.moviedbmobile2you.adapter.TopAdapter
import com.mobile2you.moviedbmobile2you.databinding.FragmentListMoviesBinding
import com.mobile2you.moviedbmobile2you.model.ItemDaListaDeFilme
import com.mobile2you.moviedbmobile2you.model.MovieDetails
import com.mobile2you.moviedbmobile2you.model.MoviesList

class ListMovies : Fragment(), TaskItemClickListener {

    private lateinit var binding: FragmentListMoviesBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        mainViewModel.getlistPopular()
        mainViewModel.getlistTopRated()
        mainViewModel.getPlayingNow()

        binding = FragmentListMoviesBinding.inflate(layoutInflater,container,false)

        val adapter = MoviesListAdapter(this, mainViewModel, requireContext())
        val topAdapter = TopAdapter(this,mainViewModel,requireContext())
        val nowAdapter = NowAdapter(this,mainViewModel,requireContext())

        binding.popularMovies.layoutManager = LinearLayoutManager(context,
        LinearLayoutManager.HORIZONTAL, false)
        binding.popularMovies.adapter = adapter

        binding.topRatedMovies.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)
        binding.topRatedMovies.adapter = topAdapter

        binding.playingNowMovies.layoutManager = LinearLayoutManager(context,
        LinearLayoutManager.HORIZONTAL, false)
        binding.playingNowMovies.adapter = nowAdapter

        mainViewModel.myPopularMoviesResponse.observe(viewLifecycleOwner){
            response -> if (response !=null){
                adapter.setList(response.body()!!)
            Log.d("Popular", response!!.body().toString())
        }
        }

        mainViewModel.myTopRatedResponse.observe(viewLifecycleOwner){
            response -> if (response!=null){
                topAdapter.setListTop(response.body()!!)
            Log.d("Avaliados", response!!.body().toString())
        }
        }

        mainViewModel.myPlayingNowResponse.observe(viewLifecycleOwner){
                response -> if (response!=null){
                    nowAdapter.setListNow(response.body()!!)
            Log.d("EmCartaz", response!!.body().toString())
        }
        }

        return binding.root
    }

    override fun onTaskClicked(poster: MovieDetails) {
        mainViewModel.posterClicked = poster
        findNavController().navigate(R.id.action_listMovies_to_movieDetails)
    }
}