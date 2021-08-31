package com.retrofit.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.MultipartBody

class ImageUploadViewModel :ViewModel() {


    //now you can call the viewModel in any where

    private  val repository = ImageRepository(ApiRetrofitClient.baseApiInterface)


    private val _handleSuccess = MutableLiveData<ImageUploadResponse>()
    val handleSuccess: LiveData<ImageUploadResponse> = _handleSuccess


    private val _handleFailure = MutableLiveData<Boolean>()
    val handleFailure: LiveData<Boolean> = _handleFailure

    fun setHandleSuccess(value: ImageUploadResponse ) {
        _handleSuccess.value = value
    }

    fun setHandleFailure(value: Boolean) {
        _handleFailure.value = value
    }

    fun getMoviesList(filePart : MultipartBody.Part) {
        repository.getImage(filePart , object : IApiResponse {
            override fun onSuccess(response: Any) {
                if (response is ImageUploadResponse) {
                    setHandleSuccess(response)
                } else {
                    setHandleFailure(true)
                }
            }

            override fun onFailure() {
                setHandleFailure(true)
            }

        })
    }
}