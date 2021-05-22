package com.example.watchmojo.viewmodel

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before

class MovieViewModelTest : TestCase() {

    private lateinit var viewModel: MovieViewModel

    @Before
    override fun setUp() {
        viewModel = MovieViewModel()
    }

    fun testGetListMovies() {
        val movies = viewModel.getListMovie()
        assertNotNull(movies)
        assertNotNull(movies)
        Assert.assertEquals(10, movies.size)
    }

    fun testGetListTvShows() {
        val tvShows = viewModel.getListTvShow()
        assertNotNull(tvShows)
        Assert.assertEquals(10, tvShows.size)
    }
}