package com.example.watchmojo.viewmodel

import com.example.watchmojo.utility.DummyData
import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before

class DetailViewModelTest : TestCase() {


    private val movieDummy = DummyData.generateDataMovieDummy()[0]
    private val tvshowMovie = DummyData.generateDataTvShowDummy()[0]
    private lateinit var viewModel: DetailViewModel
    private val movieId = movieDummy.id
    private val tvShowId = tvshowMovie.id

    @Before
    override fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }
    public override fun tearDown() {}

    fun testGetDetailMovieWithId() {
        val movie = viewModel.getDetailMovieById()
        Assert.assertNotNull(movie)
        assertEquals(movieDummy.name, movie.name)
        assertEquals(movieDummy.desc, movie.desc)
        assertEquals(movieDummy.poster, movie.poster)
        assertEquals(movieDummy.img_preview, movie.img_preview)
    }

    fun testGetDetailTvShowWithId() {
        val tvShow = viewModel.getDetailTvShowById()
        Assert.assertNotNull(tvShow)
        assertEquals(tvshowMovie.name, tvShow.name)
        assertEquals(tvshowMovie.desc, tvShow.desc)
        assertEquals(tvshowMovie.poster, tvShow.poster)
        assertEquals(tvshowMovie.img_preview, tvShow.img_preview)
    }
}