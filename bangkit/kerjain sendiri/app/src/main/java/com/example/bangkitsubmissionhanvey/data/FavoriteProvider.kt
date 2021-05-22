package com.example.bangkitsubmissionhanvey.data

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.bangkitsubmissionhanvey.database.DatabaseContract.AUTHORITY
import com.example.bangkitsubmissionhanvey.database.FavoriteHelper
import com.example.bangkitsubmissionhanvey.database.DatabaseContract.FavoriteColumns.Companion.CONTENT_URI
import com.example.bangkitsubmissionhanvey.database.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME

class FavoriteProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val deleted: Int = when (FAVORITE_ID) {
            uriMatcher.match(uri) -> favoriteHelper.deleteByUsername(uri.lastPathSegment.toString())
            else -> 0
        }

        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return deleted
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val inserted: Long = when (FAVORITE) {
            uriMatcher.match(uri) -> favoriteHelper.insertData(values)
            else -> 0
        }

        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return Uri.parse("$CONTENT_URI/$inserted")
    }

    override fun onCreate(): Boolean {
        favoriteHelper = FavoriteHelper.getInstance(context as Context)
        favoriteHelper.open()
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            FAVORITE -> favoriteHelper.queryData() // get all data
            FAVORITE_ID -> favoriteHelper.queryByUsername(uri.lastPathSegment.toString()) // get data by id
            else -> null
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val updated: Int = when (FAVORITE_ID) {
            uriMatcher.match(uri) -> favoriteHelper.updateData(
                uri.lastPathSegment.toString(),
                values
            )
            else -> 0
        }

        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return updated
    }

    companion object {
        private const val FAVORITE = 1
        private const val FAVORITE_ID = 2
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        private lateinit var favoriteHelper: FavoriteHelper

        init {
            uriMatcher.addURI(AUTHORITY, TABLE_NAME, FAVORITE)
            uriMatcher.addURI(
                AUTHORITY,
                "$TABLE_NAME/#",
                FAVORITE_ID
            )
        }
    }
}