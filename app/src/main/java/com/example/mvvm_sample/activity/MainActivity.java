package com.example.mvvm_sample.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_sample.R;
import com.example.mvvm_sample.databinding.ActivityMainBinding;
import com.example.mvvm_sample.model.SampleModel;
import com.example.mvvm_sample.viewmodel.SampleAndroidViewModelFactory;
import com.example.mvvm_sample.viewmodel.SampleViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        SampleModel sampleModel = new SampleModel();
        SampleAndroidViewModelFactory sampleAndroidViewModelFactory = new SampleAndroidViewModelFactory(getApplication(), sampleModel);
        SampleViewModel viewModel = new ViewModelProvider(this, sampleAndroidViewModelFactory).get(SampleViewModel.class);

        binding.setSampleViewModel(viewModel);

    }
}