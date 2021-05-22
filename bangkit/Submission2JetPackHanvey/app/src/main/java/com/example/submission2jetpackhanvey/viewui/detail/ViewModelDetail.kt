package com.example.submission2jetpackhanvey.viewui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.source.CatalogRepository

class ViewModelDetail(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getMovieDetail(movieId: Int): LiveData<ModelDataEntity> =
        catalogRepository.getDetailMovie(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<ModelDataEntity> =
        catalogRepository.getDetailTvShow(tvShowId)
}