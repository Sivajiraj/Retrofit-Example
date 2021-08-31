package com.retrofit.example

import okhttp3.MultipartBody
import retrofit2.http.Multipart


interface IImageRepository {
    fun getImage(filePart: MultipartBody.Part, apiResponse: IApiResponse)

}