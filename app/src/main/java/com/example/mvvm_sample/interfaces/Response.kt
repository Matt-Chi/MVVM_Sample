package com.example.mvvm_sample.interfaces

import java.lang.Exception

interface Response<T> {
    fun onSuccess(response: T)
    fun onError(exception: Exception)
}