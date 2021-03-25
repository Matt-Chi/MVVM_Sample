package com.example.mvvm_sample.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_sample.model.SampleModel;

public class SampleViewModel extends ViewModel {

    public MutableLiveData<Integer> value = new MutableLiveData<>();
    private SampleModel sampleModel = new SampleModel();

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
