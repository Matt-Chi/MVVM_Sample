package com.example.mvvm_sample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_sample.MyApplication
import com.example.mvvm_sample.R
import com.example.mvvm_sample.adapter.ArticleAdapter
import com.example.mvvm_sample.databinding.ActivityMainBinding
import com.example.mvvm_sample.model.SampleModel
import com.example.mvvm_sample.viewmodel.SampleAndroidViewModelFactory
import com.example.mvvm_sample.viewmodel.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
    }
    private val viewModel by lazy {
        ViewModelProvider(
            this, SampleAndroidViewModelFactory(MyApplication(), SampleModel())
        )[SampleViewModel::class.java]
    }
    private val adapter by lazy {
        ArticleAdapter(this, viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.sampleViewModel = viewModel
        binding.lifecycleOwner = this
        binding.lvArticleList.adapter = adapter
        viewModel.postResponse.observe(this) {
            adapter.notifyDataSetChanged()
        }
    }

}