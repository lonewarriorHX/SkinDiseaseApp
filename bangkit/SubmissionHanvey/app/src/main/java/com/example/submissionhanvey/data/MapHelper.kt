package com.example.submissionhanvey.data

import android.database.Cursor
import com.example.submissionhanvey.DataUsers

object MapHelper {

    fun mapCursor(favoriteCursor: Cursor?): ArrayList<DataUsers> {
        val favoriteList = ArrayList<DataUsers>()

        favoriteCursor?.apply {
            while (moveToNext()) {
                val repository =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.REPOSITORY))
                val company =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.COMPANY))
                val location =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.LOCATION))
                val id =
                    getInt(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.ID))
                val avatar =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.AVATAR))
                val name = getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.NAME))
                val username =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.USERNAME))
                favoriteList.add(
                    DataUsers(
                        id,
                        avatar,
                        name,
                        username,
                        repository,
                        company,
                        location
                    )
                )
            }
        }
        return favoriteList
    }
}