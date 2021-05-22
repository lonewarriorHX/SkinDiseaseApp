package com.example.submission2jetpackhanvey.viewui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.source.CatalogRepository

class MovieViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getListTopRatedMovies(): LiveData<List<ModelDataEntity>> = catalogRepository.getTopMovies()
}