package com.example.submission2jetpackhanvey.source.remote.api

import com.example.submission2jetpackhanvey.BuildConfig
import com.example.submission2jetpackhanvey.source.remote.response.ResponseList
import com.example.submission2jetpackhanvey.source.remote.response.ResponseMovie
import com.example.submission2jetpackhanvey.source.remote.response.ResponseTvShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceConf {

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ResponseList<ResponseMovie>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ResponseMovie>

    @GET("tv/top_rated")
    fun getTopRatedTvShow(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ResponseList<ResponseTvShow>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvShowId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ResponseTvShow>

}