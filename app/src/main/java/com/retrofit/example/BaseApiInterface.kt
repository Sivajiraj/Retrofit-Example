package com.retrofit.example

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part

interface BaseApiInterface {
    @Multipart
    @PUT("v1/updatecustomerkyc")
    fun ImageUplode(
        @Part("nationalIdentificationNumber") nationalidentificationNumber: String,
        @Part("drivingLicenceNumber") nationalidentificationValidity: String,
        @Part("drivingLicenceValidity") drivingLicenceNumber : String,
        @Part drivingLicenceImage: MultipartBody.Part?,
        @Part nationalIdentificationImage: MultipartBody.Part?
    ) : Call<ImageUploadResponse?>

}