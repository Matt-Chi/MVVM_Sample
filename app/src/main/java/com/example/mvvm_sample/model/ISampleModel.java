package com.example.mvvm_sample.model;

public interface ISampleModel {
    void getValue(ICallback callback);

    interface ICallback {
        void onFinish(int value);
    }
}
