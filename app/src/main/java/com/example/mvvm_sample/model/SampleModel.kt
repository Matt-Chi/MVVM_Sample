package com.example.mvvm_sample.model

import com.example.mvvm_sample.ApiManager
import com.example.mvvm_sample.response.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SampleModel : BaseModel() {
    fun getValue(callback: Callback<PostResponse>) {
        ApiManager.apiService.getPosts().enqueue(object : Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                callback.onResponse(call, response)
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                callback.onFailure(call, t)
            }
        })
    }
}