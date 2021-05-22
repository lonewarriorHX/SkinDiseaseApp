package com.example.bangkitsubmissionhanvey.database

import android.database.Cursor
import com.example.bangkitsubmissionhanvey.data.UserData

object MappingHelper {

    fun mapCursor(favoriteCursor: Cursor?): ArrayList<UserData> {
        val favoriteList = ArrayList<UserData>()

        favoriteCursor?.apply {
            while (moveToNext()) {
                val id =
                    getInt(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.ID))
                val avatar =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.AVATAR))
                val name = getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.NAME))
                val username =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.USERNAME))
                val repository =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.REPOSITORY))
                val company =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.COMPANY))
                val location =
                    getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.LOCATION))
                favoriteList.add(
                    UserData(
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