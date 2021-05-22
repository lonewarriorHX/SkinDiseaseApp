package com.example.submission3jetpackhanvey.source.remote.apiresponse

import com.example.submission3jetpackhanvey.source.remote.StatusResponse


class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> error(msg: String, body: T): ApiResponse<T> =
                ApiResponse(
                        StatusResponse.ERROR,
                        body,
                        msg
                )
        fun <T> success(body: T): ApiResponse<T> =
            ApiResponse(
                StatusResponse.SUCCESS,
                body,
                null
            )
        fun <T> empty(msg: String, body: T): ApiResponse<T> =
            ApiResponse(
                StatusResponse.EMPTY,
                body,
                msg
            )

    }
}