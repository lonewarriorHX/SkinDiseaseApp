package com.example.submissionhanvey.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.submissionhanvey.data.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "submissionhanvey"
        private const val DATABASE_VERSION = 1

        private const val CREATE_TABLE_GITHUB_USERS = "CREATE TABLE $TABLE_NAME" +
                "(${DatabaseContract.FavoriteColumns.ID} INTEGER NOT NULL," +
                "${DatabaseContract.FavoriteColumns.USERNAME} TEXT NOT NULL," +
                "${DatabaseContract.FavoriteColumns.AVATAR} TEXT NOT NULL," +
                "${DatabaseContract.FavoriteColumns.NAME} TEXT NOT NULL," +
                "${DatabaseContract.FavoriteColumns.REPOSITORY} TEXT NOT NULL," +
                "${DatabaseContract.FavoriteColumns.COMPANY} TEXT NOT NULL," +
                "${DatabaseContract.FavoriteColumns.LOCATION} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GITHUB_USERS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}