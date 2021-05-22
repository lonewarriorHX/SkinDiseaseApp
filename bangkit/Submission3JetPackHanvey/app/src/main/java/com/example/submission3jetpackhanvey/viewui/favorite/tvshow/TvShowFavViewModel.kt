package com.example.submission3jetpackhanvey.viewui.favorite.tvshow

import androidx.lifecycle.ViewModel
import com.example.submission3jetpackhanvey.source.RemoteRepository
import com.example.submission3jetpackhanvey.source.localdata.entitydata.TvShowDataEnt

class TvShowFavViewModel(private val repository: RemoteRepository) : ViewModel() {
    fun getFavTvShows() = repository.getFavoriteTvShows()

    fun setFavTvShow(tvShowDataEnt: TvShowDataEnt) {
        val newState = !tvShowDataEnt.isFavorite
        repository.setFavoriteTvShow(tvShowDataEnt, newState)
    }
}