package com.example.submission2jetpackhanvey.viewui.movie

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
 MovieViewModelTest
1. mengubah data ketika pemanggilan data movie di kelas repository.
2. mengecek apakah metode di kelas repository terpanggil.
3. mengecek apakah data movie tidak null.
4. mengecek apakah jumlah data movie sesuai dengan yang diharapkan.
 */
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private val dummyMovie = DummyData.generateDummyMovies()
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<List<ModelDataEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getListMovie() {
        val movie = MutableLiveData<List<ModelDataEntity>>()
        movie.value = dummyMovie

        Mockito.`when`(movieRepository.getTopMovies()).thenReturn(movie)

        val dataListMovie = viewModel.getListTopRatedMovies().value

        verify(movieRepository).getTopMovies()
        Assert.assertNotNull(dataListMovie)
        Assert.assertEquals(10, dataListMovie?.size)

        viewModel.getListTopRatedMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}