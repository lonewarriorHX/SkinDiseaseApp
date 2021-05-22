package com.example.submission2jetpackhanvey.viewui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2jetpackhanvey.databinding.MovieFragBinding
import com.example.submission2jetpackhanvey.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel

    private lateinit var fragmentMovieBinding: MovieFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = MovieFragBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            setupRecyclerView()
            val factory = ViewModelFactory.getInstance()
            activity?.let { viewModel = ViewModelProvider(it, factory)[MovieViewModel::class.java] }

            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getListTopRatedMovies().observe(viewLifecycleOwner, { listMovie ->
                fragmentMovieBinding.progressBar.visibility = View.GONE
                fragmentMovieBinding.movieRv.adapter.let { adapter ->
                    when (adapter) {
                        is MovieAdapter -> adapter.setMovie(listMovie)
                    }
                }
            })
        }
    }



    private fun setupRecyclerView() {
        fragmentMovieBinding.movieRv.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = MovieAdapter()
        }
    }
}
