package com.example.submissionhanvey.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.submissionhanvey.data.DatabaseContract.AUTHORITY
import com.example.submissionhanvey.data.DatabaseContract.FavoriteColumns.Companion.CONTENT_URI
import com.example.submissionhanvey.data.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME
import com.example.submissionhanvey.data.FavHelper

class FavoriteProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val deleted: Int = when (FAVORITE_ID) {
            uriMatcher.match(uri) -> favHelper.deleteById(uri.lastPathSegment?.toInt())
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
            uriMatcher.match(uri) -> favHelper.insertData(values)
            else -> 0
        }

        context?.contentResolver?.notifyChange(CONTENT_URI, null)
        return Uri.parse("$CONTENT_URI/$inserted")
    }

    override fun onCreate(): Boolean {
        favHelper = FavHelper.getInstance(context as Context)
        favHelper.open()
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            FAVORITE -> favHelper.queryData() // get all data
            FAVORITE_ID -> favHelper.queryByUsername(uri.lastPathSegment.toString()) // get data by id
            else -> null
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val updated: Int = when (FAVORITE_ID) {
            uriMatcher.match(uri) -> favHelper.updateData(
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
        private lateinit var favHelper: FavHelper

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