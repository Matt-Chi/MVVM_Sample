package com.example.mvvm_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_sample.R
import com.example.mvvm_sample.viewmodel.SampleAndroidViewModelFactory
import com.example.mvvm_sample.viewmodel.SampleViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_sample.databinding.ActivityMainBinding
import com.example.mvvm_sample.model.SampleModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
    }
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            SampleAndroidViewModelFactory(application, SampleModel())
        ).get(SampleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.sampleViewModel = viewModel
        binding.lifecycleOwner = this
    }

}