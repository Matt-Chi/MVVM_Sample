package com.example.mvvm_sample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_sample.model.ISampleModel;

import java.lang.reflect.InvocationTargetException;

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
        try {
//            if (modelClass.isAssignableFrom(ISampleViewModel.class)) {
                return (T) modelClass.getConstructor(Application.class, ISampleModel.class).newInstance(application, sampleModel);
//            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}