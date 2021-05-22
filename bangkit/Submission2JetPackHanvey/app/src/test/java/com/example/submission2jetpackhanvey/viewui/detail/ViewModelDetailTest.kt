package com.example.submission2jetpackhanvey.viewui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission2jetpackhanvey.source.CatalogRepository
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.watchmojo.utility.DummyData
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


/* ViewModelDetailTest:
1. mengecek agar data movie tidak null
2. mengecek agar data movie sesuai
3. mengecek agar data tvShow tidak null
4. mengecek agar data tvShow Sesuai
*/

@RunWith(MockitoJUnitRunner::class)
class ViewModelDetailTest {

    private val dummyMovie = DummyData.generateDummyMovies()[0]
    private val movieId = dummyMovie.id
    private val dummyTvShow = DummyData.generateDummyTv()[0]
    private val tvShowId = dummyTvShow.id

    private lateinit var viewModel: ViewModelDetail

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogRepository: CatalogRepository

    @Mock
    private lateinit var observer: Observer<ModelDataEntity>

    @Before
    fun setUp() {
        viewModel = ViewModelDetail(catalogRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<ModelDataEntity>()
        movieDummy.value = dummyMovie

        Mockito.`when`(catalogRepository.getDetailMovie(movieId)).thenReturn(movieDummy)

        val movieData = viewModel.getMovieDetail(movieId).value as ModelDataEntity

        Assert.assertNotNull(movieData)
        assertEquals(dummyMovie.id, movieData.id)
        assertEquals(dummyMovie.name, movieData.name)
        assertEquals(dummyMovie.descript, movieData.descript)
        assertEquals(dummyMovie.img_poster, movieData.img_poster)
        assertEquals(dummyMovie.preview_image, movieData.preview_image)
        assertEquals(dummyMovie.value_score, movieData.value_score)

        viewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<ModelDataEntity>()
        tvShowDummy.value = dummyTvShow

        Mockito.`when`(catalogRepository.getDetailTvShow(tvShowId)).thenReturn(tvShowDummy)

        val tvShowData = viewModel.getTvShowDetail(tvShowId).value as ModelDataEntity

        Assert.assertNotNull(tvShowData)
        assertEquals(dummyMovie.id, tvShowData.id)
        assertEquals(dummyMovie.name, tvShowData.name)
        assertEquals(dummyMovie.descript, tvShowData.descript)
        assertEquals(dummyMovie.img_poster, tvShowData.img_poster)
        assertEquals(dummyMovie.preview_image, tvShowData.preview_image)
        assertEquals(dummyMovie.value_score, tvShowData.value_score)

        viewModel.getTvShowDetail(tvShowId).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}