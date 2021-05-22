package com.example.submission2jetpackhanvey.utility

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {

    const val IMG_POSTER_SIZE = "w185"
    const val IMG_BACKGROUND_SIZE = "w780"
    const val TYPE_MOVIE = "TYPE_MOVIE"
    const val TYPE_TVSHOW = "TYPE_TVSHOW"
    const val IMG_API_ENDPOINT = "https://image.tmdb.org/t/p/"


    fun setGlideImage(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }

}