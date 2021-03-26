package com.example.mvvm_sample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_sample.model.ISampleModel;

public class SampleAndroidViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private ISampleModel sampleModel;

    public SampleAndroidViewModelFactory() {
    }

    public SampleAndroidViewModelFactory(Application application, ISampleModel sampleModel) {
        this.application = application;
        this.sampleModel = sampleModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SampleViewModel.class)) {
            return (T) new SampleViewModel(application, sampleModel);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
