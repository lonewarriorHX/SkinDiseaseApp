package com.example.submission2jetpackhanvey.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.submission2jetpackhanvey.source.remote.CatalogDataSource
import com.example.submission2jetpackhanvey.utility.LiveDataTestUtil
import com.example.watchmojo.utility.DummyData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogRepositoryTest {

    private val listMovieResponse = DummyData.generateDataMovieDummy()
    private val movieId = listMovieResponse[0].id
    private val listTvShowResponse = DummyData.generateDataTvShowDummy()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DummyData.generateDataMovieDummy()[0]
    private val tvShowResponse = DummyData.generateDataTvShowDummy()[0]
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(CatalogDataSource::class.java)
    private val movieRepository = FakeCatalogueRepository(remote)



    @Test
    fun getTopRatedMovies(){
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as CatalogDataSource.LoadTopRatedMoviesCallback).onAllMoviesReceived(listMovieResponse)
                null
            }.`when`(remote).getTopRatedMovies(any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getTopMovies())

        runBlocking {
            verify(remote).getTopRatedMovies(any())
        }

        Assert.assertNotNull(data)
        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getMovieDetail(){
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as CatalogDataSource.LoadMovieDetailCallback).onMovieDetailReceived(movieResponse)
                null
            }.`when`(remote).getMovieDetail(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId), any())
        }

        Assert.assertNotNull(data)
        assertEquals(movieResponse.id, data.id)
    }

    @Test
    fun getTopRatedTvShow(){
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as CatalogDataSource.LoadTopRatedTvShowCallback).onAllTvShowsReceived(listTvShowResponse)
                null
            }.`when`(remote).getTopRatedTvShow(any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getTopTvShow())

        runBlocking {
            verify(remote).getTopRatedTvShow(any())
        }

        Assert.assertNotNull(data)
        assertEquals(listTvShowResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getTvShowDetail(){
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as CatalogDataSource.LoadTvShowDetailCallback).onTvShowDetailReceived(tvShowResponse)
                null
            }.`when`(remote).getTvShowDetail(eq(tvShowId), any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getDetailTvShow(tvShowId))

        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId), any())
        }

        Assert.assertNotNull(data)
        assertEquals(tvShowResponse.id, data.id)
    }
}