package com.example.submission3jetpackhanvey.viewui.movie

import androidx.lifecycle.ViewModel
import com.example.submission3jetpackhanvey.source.RemoteRepository

class MovieViewModel(private val movieCatalogueRepository: RemoteRepository) : ViewModel() {
    fun getMovies(sort: String) = movieCatalogueRepository.getMoviesList(sort)
}