package com.example.submission3jetpackhanvey.viewui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.FragMovieBinding
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt
import com.example.submission3jetpackhanvey.utility.DecorationItem
import com.example.submission3jetpackhanvey.viewui.detail.ActivityDetail
import com.example.submission3jetpackhanvey.viewui.MainActivity
import com.example.submission3jetpackhanvey.viewmodel.ViewModelFactory
import com.example.submission3jetpackhanvey.viewui.detail.ModelDetailView.Companion.MOVIE
import com.example.submission3jetpackhanvey.utility.Helper.RANDOM_VOTE
import com.example.submission3jetpackhanvey.utility.Helper.BEST_VOTE
import com.example.submission3jetpackhanvey.utility.Helper.WORST_VOTE
import com.example.submission3jetpackhanvey.viewui.movie.MovieAdapter
import com.example.submission3jetpackhanvey.viewui.movie.MovieViewModel
import com.example.submission3jetpackhanvey.vo.ResourceConf
import com.example.submission3jetpackhanvey.vo.StatusConf

class MovieFragment : Fragment(),
    MovieAdapter.OnItemClickCallback {

    private lateinit var fragmentMovieBinding: FragMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragMovieBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            (activity as MainActivity).setActionBarTitle("Movies List")

            showProgressBar(true)
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            movieAdapter =
                MovieAdapter()
            viewModel.getMovies(BEST_VOTE).observe(viewLifecycleOwner, movieObserver)

            val marginVertical = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                resources.displayMetrics
            )

            with(fragmentMovieBinding.rvMovies) {
                addItemDecoration(DecorationItem(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

    private val movieObserver = Observer<ResourceConf<PagedList<MovieDataEnt>>> { movies ->
        if (movies != null) {
            when (movies.statusConf) {
                StatusConf.LOADING -> showProgressBar(true)
                StatusConf.SUCCESS -> {
                    showProgressBar(false)
                    movieAdapter.submitList(movies.data)
                    movieAdapter.setOnItemClickCallback(this)
                    movieAdapter.notifyDataSetChanged()
                }
                StatusConf.ERROR -> {
                    showProgressBar(false)
                    Toast.makeText(context, "Error Happened", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, ActivityDetail::class.java)
        intent.putExtra(ActivityDetail.EXTRA_FILM, id)
        intent.putExtra(ActivityDetail.EXTRA_CATEGORY, MOVIE)

        context?.startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        activity?.menuInflater?.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.best_vote -> sort = BEST_VOTE
            R.id.worst_vote -> sort = WORST_VOTE
            R.id.random -> sort = RANDOM_VOTE
        }

        viewModel.getMovies(sort).observe(viewLifecycleOwner, movieObserver)
        item.isChecked = true

        return super.onOptionsItemSelected(item)
    }

    private fun showProgressBar(state: Boolean) {
        fragmentMovieBinding.progressMovie.isVisible = state
        fragmentMovieBinding.rvMovies.isInvisible = state
    }

}