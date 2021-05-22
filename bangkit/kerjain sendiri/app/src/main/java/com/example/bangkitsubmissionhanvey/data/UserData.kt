package com.example.bangkitsubmissionhanvey.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    var id: Int? = null,
    var avatar: String? = null,
    var name: String? = null,
    var username: String? = null,
    var repository: String? = null,
    var company: String? = null,
    var location: String? = null,
    var followers: String? = null,
    var following: String? = null
) : Parcelable