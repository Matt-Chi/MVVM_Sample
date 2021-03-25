package com.example.mvvm_sample.model;

import java.util.concurrent.Executors;

public class SampleModel {
    private int value;

    public void getValue(ICallback callback) {
        Executors.newSingleThreadExecutor().submit(()-> {
            value = 6;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callback.onFinish(value);
        });
    }

    public interface ICallback {
        void onFinish(int value);
    }
}

