package com.example.mvvm_sample.model

import com.example.mvvm_sample.interfaces.Response
import java.util.concurrent.Executors

class SampleModel : BaseModel() {
    fun getValue(response: Response<Int>) {
        Executors.newSingleThreadExecutor().submit {

            // Assume this value is provided by a web api response.
            val value = 6
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            response.onSuccess(value)
        }
    }
}