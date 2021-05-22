package com.example.bangkitsubmissionhanvey.model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 6a989c182c40e1b51e3a9fd290845ba81c45bd40")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>
}