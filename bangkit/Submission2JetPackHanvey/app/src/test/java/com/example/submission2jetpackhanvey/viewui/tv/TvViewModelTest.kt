package com.example.submission2jetpackhanvey.viewui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission2jetpackhanvey.source.CatalogRepository
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.watchmojo.utility.DummyData
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
/**
tvViewModelTest
1. mengubah data ketika pemanggilan data movie di kelas repository.
2. mengecek apakah metode di kelas repository terpanggil.
3. mengecek apakah data tvShow tidak null.
4. mengecek apakah jumlah data tvShow sesuai dengan yang diharapkan.
 */

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    private lateinit var viewModel: TvViewModel
    private val dummyTvShow = DummyData.generateDummyTv()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<List<ModelDataEntity>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieRepository)
    }

    @Test
    fun getListTvShows() {
        val tvShow = MutableLiveData<List<ModelDataEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(movieRepository.getTopTvShow()).thenReturn(tvShow)

        val dataListTvShow = viewModel.getListTopRatedTvShow().value

        verify(movieRepository).getTopTvShow()
        Assert.assertNotNull(dataListTvShow)
        Assert.assertEquals(10, dataListTvShow?.size)

        viewModel.getListTopRatedTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}