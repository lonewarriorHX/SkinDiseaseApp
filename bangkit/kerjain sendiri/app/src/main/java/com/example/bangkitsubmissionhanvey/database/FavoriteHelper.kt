package com.example.bangkitsubmissionhanvey.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.bangkitsubmissionhanvey.database.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME
import com.example.bangkitsubmissionhanvey.database.DatabaseContract.FavoriteColumns.Companion.USERNAME
import java.sql.SQLException

class FavoriteHelper(context: Context) {

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
        private lateinit var dbHelper: DatabaseHelper
        private lateinit var db: SQLiteDatabase
        private var INSTANCE: FavoriteHelper? = null

        fun getInstance(context: Context): FavoriteHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: FavoriteHelper(context)
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

    fun updateData(username: String?, values: ContentValues?): Int {
        return db.update(DATABASE_TABLE, values, "$USERNAME = ?", arrayOf(username))
    }

    fun deleteByUsername(username: String?): Int{
        return db.delete(DATABASE_TABLE, "$USERNAME = '$username'", null)
    }

}