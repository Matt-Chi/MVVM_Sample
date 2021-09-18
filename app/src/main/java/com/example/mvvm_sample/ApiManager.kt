package com.example.mvvm_sample

import com.example.mvvm_sample.interfaces.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    private val okHttpClient = OkHttpClient()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}