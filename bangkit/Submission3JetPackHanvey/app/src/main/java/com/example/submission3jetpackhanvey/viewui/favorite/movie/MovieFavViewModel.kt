package com.example.submission3jetpackhanvey.viewui.favorite.movie

import androidx.lifecycle.ViewModel
import com.example.submission3jetpackhanvey.source.RemoteRepository
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt

class MovieFavViewModel(private val repository: RemoteRepository) : ViewModel() {
    fun getFavMovies() = repository.getFavoriteMovies()

    fun setFavMovie(movieDataEnt: MovieDataEnt) {
        val newState = !movieDataEnt.isFavorite
        repository.setFavoriteMovie(movieDataEnt, newState)
    }
}