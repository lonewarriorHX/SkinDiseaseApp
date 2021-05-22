package com.example.submissionhanvey.provider

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favourite_user")
data class FavouriteUser (
    val login: String,
    @PrimaryKey
    val id: Int
): Serializable