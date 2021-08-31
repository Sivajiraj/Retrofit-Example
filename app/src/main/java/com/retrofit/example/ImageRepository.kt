package com.retrofit.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageRepository (val baseApiInterface: BaseApiInterface) : IImageRepository{
    override fun getImage(filePart: MultipartBody.Part, apiResponse: IApiResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = baseApiInterface.ImageUplode("","","",filePart,filePart)
            call.enqueue(object : Callback<ImageUploadResponse?> {
                override fun onResponse(
                    call: Call<ImageUploadResponse?>,
                    response: Response<ImageUploadResponse?>
                ) {
                    if (response.body() != null) {
                        (response.body() as ImageUploadResponse?).let { apiResponse.onSuccess(response) }
                    } else {
                        apiResponse.onFailure()
                    }
                }

                override fun onFailure(call: Call<ImageUploadResponse?>, t: Throwable) {
                    apiResponse.onFailure()
                }
            })
        }
    }


}