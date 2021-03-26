package com.example.mvvm_sample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_sample.model.ISampleModel;
import com.example.mvvm_sample.model.SampleModel;

public class SampleViewModel extends AndroidViewModel {

    private ISampleModel sampleModel;

    public SampleViewModel(@NonNull Application application, ISampleModel sampleModel) {
        super(application);
        this.sampleModel = sampleModel;
    }

    public MutableLiveData<Integer> value = new MutableLiveData<>();

    public void getValue() {
        sampleModel.getValue(new SampleModel.ICallback() {
            @Override
            public void onFinish(int value) {
                SampleViewModel.this.value.postValue(value);
            }
        });

        // lambda寫法
        // sampleModel.getValue(value -> SampleViewModel.this.value.postValue(value));
    }
}
