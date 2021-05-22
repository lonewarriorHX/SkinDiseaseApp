package com.example.bangkitsubmissionhanvey.database

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {

    const val AUTHORITY = "com.example.bangkitsubmissionhanvey"
    const val SCHEME = "content"

    class FavoriteColumns : BaseColumns {
        companion object {

            const val ID = "id"
            const val TABLE_NAME = "favorite"
            const val AVATAR = "avatar"
            const val USERNAME = "username"
            const val NAME = "name"
            const val REPOSITORY = "repository"
            const val COMPANY = "company"
            const val LOCATION = "location"

            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }

}