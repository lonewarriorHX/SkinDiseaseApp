package com.example.submission2jetpackhanvey.viewui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.source.CatalogRepository

class TvViewModel(private val catalogRepository: CatalogRepository) : ViewModel() {

    fun getListTopRatedTvShow(): LiveData<List<ModelDataEntity>> = catalogRepository.getTopTvShow()
}