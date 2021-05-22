package com.example.submission3jetpackhanvey.source.localdata.roomdata

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt
import com.example.submission3jetpackhanvey.source.localdata.entitydata.TvShowDataEnt

@Dao
interface ContentDaoConf {
    @RawQuery(observedEntities = [MovieDataEnt::class])
    fun getMovies(query: SimpleSQLiteQuery): DataSource.Factory<Int, MovieDataEnt>

    @Query("SELECT * FROM movie_entities WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieDataEnt>

    @Query("SELECT * FROM movie_entities WHERE isFav = 1")
    fun getFavMovies(): DataSource.Factory<Int, MovieDataEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieDataEnt>)

    @Update
    fun updateMovie(movie: MovieDataEnt)

    @RawQuery(observedEntities = [TvShowDataEnt::class])
    fun getTvShows(query: SimpleSQLiteQuery): DataSource.Factory<Int, TvShowDataEnt>

    @Query("SELECT * FROM tv_show_entities WHERE id = :id")
    fun getTvShowById(id: Int): LiveData<TvShowDataEnt>

    @Query("SELECT * FROM tv_show_entities WHERE isFav = 1")
    fun getFavTvShows(): DataSource.Factory<Int, TvShowDataEnt>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowDataEnt>)

    @Update
    fun updateTvShow(tvShow: TvShowDataEnt)
}