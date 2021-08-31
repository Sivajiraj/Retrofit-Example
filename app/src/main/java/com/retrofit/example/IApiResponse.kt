package com.retrofit.example

interface IApiResponse {
    fun onSuccess(response: Any)
    fun onFailure()
}