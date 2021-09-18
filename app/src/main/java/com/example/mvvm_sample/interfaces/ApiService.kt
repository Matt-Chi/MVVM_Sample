package com.example.mvvm_sample.interfaces

import com.example.mvvm_sample.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts() : Call<PostResponse>
}