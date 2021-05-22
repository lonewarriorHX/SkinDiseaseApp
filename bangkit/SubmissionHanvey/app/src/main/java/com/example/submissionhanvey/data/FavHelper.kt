package com.example.submissionhanvey.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.submissionhanvey.data.DatabaseContract.FavoriteColumns.Companion.ID
import com.example.submissionhanvey.data.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME
import com.example.submissionhanvey.data.DatabaseContract.FavoriteColumns.Companion.USERNAME
import java.sql.SQLException

class FavHelper(context: Context) {

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
        private lateinit var dbHelper: DatabaseHelper
        private lateinit var db: SQLiteDatabase
        private var INSTANCE: FavHelper? = null

        fun getInstance(context: Context): FavHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: FavHelper(context)
            }
    }

    init {
        dbHelper = DatabaseHelper(context)
    }

    @Throws(SQLException::class)
    fun open() {
        db = dbHelper.writableDatabase
    }

    fun close() {
        dbHelper.close()

        if (db.isOpen)
            db.close()
    }

    fun queryData(): Cursor {
        return db.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$USERNAME ASC"
        )
    }

    fun queryByUsername(username: String?): Cursor {
        return db.query(
            DATABASE_TABLE,
            null,
            "$USERNAME = ?",
            arrayOf(username),
            null,
            null,
            null,
            null
        )
    }

    fun insertData(values: ContentValues?): Long {
        return db.insert(DATABASE_TABLE, null, values)
    }

    fun updateData(id: String?, values: ContentValues?): Int {
        return db.update(DATABASE_TABLE, values, "$USERNAME = ?", arrayOf(id))
    }

    fun deleteById(id: Int?): Int{
        return db.delete(DATABASE_TABLE, "$ID = '$id'", null)

    }

}