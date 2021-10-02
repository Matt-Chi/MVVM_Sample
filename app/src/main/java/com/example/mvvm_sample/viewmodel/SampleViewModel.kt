package com.example.mvvm_sample.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_sample.MyApplication
import com.example.mvvm_sample.model.SampleModel
import com.example.mvvm_sample.response.PostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(application: MyApplication, sampleModel: SampleModel) :
    BaseViewModel<SampleModel>(application, sampleModel) {
    var postResponse = MutableLiveData<PostResponse>()

    fun getData() {
        model.getValue(object : Callback<PostResponse> {
            override fun onResponse(
                call: Call<PostResponse>,
                response: Response<PostResponse>
            ) {
                postResponse.value = response.body()
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun setNewId(id: Int) {
        postResponse.value?.get(0)?.id = id
        postResponse.postValue(postResponse.value)
    }
}