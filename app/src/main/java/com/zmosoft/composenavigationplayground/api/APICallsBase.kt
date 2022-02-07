package com.zmosoft.openweather.api

import retrofit2.Response

data class APIError(val error: String = "", val httpCode: Int? = null)

data class APIResponse<T>(val data: T?, val error: APIError = APIError())

open class APICallsBase {
    protected fun <T> getResponse(response: Response<T>): APIResponse<T> {
        return if (response.isSuccessful) {
            APIResponse(response.body())
        } else {
            APIResponse<T>(
                null,
                APIError(
                    response.errorBody().toString(),
                    response.code()
                )
            )
        }
    }

    protected fun <T> getError(error: String): APIResponse<T> {
        return APIResponse(
            null,
            APIError(
                error,
                400
            )
        )
    }
}