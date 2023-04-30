package com.example.mvvm_sample.viewmodel

import androidx.lifecycle.ViewModelProvider
import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.mvvm_sample.MyApplication
import com.example.mvvm_sample.model.BaseModel
import java.lang.IllegalArgumentException
import java.lang.reflect.InvocationTargetException

class SampleAndroidViewModelFactory<R: BaseModel>(private val application: MyApplication, private val model: R) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
//            if (modelClass.isAssignableFrom(ISampleViewModel.class)) {
            return modelClass.getConstructor(application::class.java, model::class.java)
                .newInstance(application, model) as T
            //            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}