package com.yunusbedir.appcentnewsapp.data.remote

import retrofit2.HttpException


/**
 * Created by YUNUS BEDİR on 30.07.2021.
 */
sealed class ApiResponse<T> {

    companion object {
        fun <T> create(exception: Exception?): ApiResponse<T> {
            if (exception is HttpException) {
                return ApiErrorResponse(exception.message())
            }
            return ApiErrorResponse(exception?.message ?: "unknow error")
        }

        fun <T> create(data: T?): ApiResponse<T> {
            return if (data != null){
                ApiSuccessResponse(data)
            }else{
                ApiErrorResponse("null data response")
            }
        }

        private fun getErrorMessage(error: HttpException): String {
            return error.message.toString()
        }
    }

}

data class ApiErrorResponse<T>(val errorMessage: String) : ApiResponse<T>()
data class ApiSuccessResponse<T>(val response: T) : ApiResponse<T>()