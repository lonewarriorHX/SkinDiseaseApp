package com.example.bangkitsubmissionhanvey.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("items")
    val items : ArrayList<User2>
)