package com.example.mvvm_sample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_sample.model.SampleModel
import com.example.mvvm_sample.response.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SampleViewModel(application: Application, sampleModel: SampleModel) :
    BaseViewModel<SampleModel>(application, sampleModel) {
    var mutableLiveDataValue = MutableLiveData<String>()

    val value: Unit
        get() {
            model.getValue(object : Callback<PostResponse> {
                override fun onResponse(
                    call: Call<PostResponse>,
                    response: Response<PostResponse>
                ) {
                    mutableLiveDataValue.postValue(response.body()?.get(0)?.body)
                }

                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
}