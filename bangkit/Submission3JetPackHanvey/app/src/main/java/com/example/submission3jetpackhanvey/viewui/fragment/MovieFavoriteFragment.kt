package com.example.submission3jetpackhanvey.viewui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.FragMovieFavoriteBinding
import com.example.submission3jetpackhanvey.utility.DecorationItem
import com.example.submission3jetpackhanvey.viewui.detail.ActivityDetail
import com.example.submission3jetpackhanvey.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import com.example.submission3jetpackhanvey.viewui.detail.ModelDetailView.Companion.MOVIE
import com.example.submission3jetpackhanvey.viewui.favorite.movie.MovieFavAdapter
import com.example.submission3jetpackhanvey.viewui.favorite.movie.MovieFavViewModel

class MovieFavoriteFragment : Fragment(),
    MovieFavAdapter.OnItemClickCallback {

    private var _fragmentMovieFavoriteBinding: FragMovieFavoriteBinding? = null
    private val binding get() = _fragmentMovieFavoriteBinding

    private lateinit var favViewModel: MovieFavViewModel
    private lateinit var favAdapter: MovieFavAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentMovieFavoriteBinding =
            FragMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        favViewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
            if (favMovies != null) {
                favAdapter.submitList(favMovies)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(binding?.rvFavMovies)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            favViewModel = ViewModelProvider(this, factory)[MovieFavViewModel::class.java]

            favAdapter =
                MovieFavAdapter()
            favAdapter.setOnItemClickCallback(this)

            favViewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
                if (favMovies != null) {
                    favAdapter.submitList(favMovies)
                }
            })

            val marginVertical = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                resources.displayMetrics
            )

            with(binding?.rvFavMovies) {
                this?.addItemDecoration(DecorationItem(marginVertical.toInt()))
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = favAdapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = favAdapter.getSwipedData(swipedPosition)
                movieEntity?.let { favViewModel.setFavMovie(it) }

                val snackBar = Snackbar.make(requireView(), R.string.undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.ok) { _ ->
                    movieEntity?.let { favViewModel.setFavMovie(it) }
                }
                snackBar.show()
            }
        }
    })

    override fun onDestroy() {
        super.onDestroy()
        _fragmentMovieFavoriteBinding = null
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, ActivityDetail::class.java)
        intent.putExtra(ActivityDetail.EXTRA_FILM, id)
        intent.putExtra(ActivityDetail.EXTRA_CATEGORY, MOVIE)

        context?.startActivity(intent)
    }
}