package com.example.mvvm_sample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvm_sample.MyApplication

abstract class BaseViewModel<T>(application: Application, val model: T): AndroidViewModel(application)