package com.example.submission3jetpackhanvey.source.localdata.entitydata

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_entities")
data class TvShowDataEnt(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "overview")
        var descript: String,

        @ColumnInfo(name = "poster")
        var img_poster: String,

        @ColumnInfo(name = "img_preview")
        var img_preview: String,

        @ColumnInfo(name = "score")
        var value_score: Double,

        @ColumnInfo(name = "releaseDate")
        var dateYear: String,

        @ColumnInfo(name = "isFav")
        var isFavorite: Boolean = false
)