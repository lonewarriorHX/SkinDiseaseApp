package com.example.submission3jetpackhanvey.source.localdata.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt
import com.example.submission3jetpackhanvey.source.localdata.entitydata.TvShowDataEnt

@Database(
        entities = [MovieDataEnt::class, TvShowDataEnt::class],
        version = 1,
        exportSchema = false
)
abstract class ContentDataConf : RoomDatabase() {
    abstract fun contentDao(): ContentDaoConf

    companion object {
        @Volatile
        private var INSTANCE: ContentDataConf? = null

        fun getInstance(context: Context): ContentDataConf =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: Room.databaseBuilder(context.applicationContext, ContentDataConf::class.java, "Film.db").build()
                }
    }
}