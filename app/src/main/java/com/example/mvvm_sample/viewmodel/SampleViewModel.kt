package com.example.mvvm_sample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_sample.interfaces.Response
import com.example.mvvm_sample.model.SampleModel
import java.lang.Exception

class SampleViewModel(application: Application, sampleModel: SampleModel) :
    BaseViewModel<SampleModel>(application, sampleModel) {
    var mutableLiveDataValue = MutableLiveData<Int>()

    val value: Unit
        get() {
            model.getValue(object: Response<Int> {
                override fun onSuccess(response: Int) {
                    mutableLiveDataValue.postValue(response)
                }

                override fun onError(exception: Exception) {
                    TODO("Not yet implemented")
                }
            })
        }
}