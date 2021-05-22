package com.example.submission3jetpackhanvey.viewui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission3jetpackhanvey.source.RemoteRepository
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt
import com.example.submission3jetpackhanvey.source.localdata.entitydata.TvShowDataEnt
import com.example.submission3jetpackhanvey.vo.ResourceConf

class ModelDetailView(private val movieCatalogueRepository: RemoteRepository) : ViewModel() {
    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }

    private lateinit var detailTvShow: LiveData<ResourceConf<TvShowDataEnt>>
    private lateinit var detailMovie: LiveData<ResourceConf<MovieDataEnt>>

    fun setFilm(id: String, category: String) {
        when (category) {
            TV_SHOW -> {
                detailTvShow = movieCatalogueRepository.getDetailTvShow(id.toInt())
            }

            MOVIE -> {
                detailMovie = movieCatalogueRepository.getDetailMovie(id.toInt())
            }
        }
    }

    fun setFavoriteMovie() {
        val resource = detailMovie.value
        if (resource?.data != null) {
            val newState = !resource.data.isFavorite
            movieCatalogueRepository.setFavoriteMovie(resource.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val resource = detailTvShow.value
        if (resource?.data != null) {
            val newState = !resource.data.isFavorite
            movieCatalogueRepository.setFavoriteTvShow(resource.data, newState)
        }
    }

    fun getDetailTvShow() = detailTvShow
    fun getDetailMovie() = detailMovie

}