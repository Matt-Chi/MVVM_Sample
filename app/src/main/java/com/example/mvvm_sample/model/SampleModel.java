package com.example.mvvm_sample.model;

import java.util.concurrent.Executors;

public class SampleModel implements ISampleModel {

    public void getValue(ISampleModel.ICallback callback) {
        Executors.newSingleThreadExecutor().submit(() -> {
            // Assume this value is provided by a web api response.
            int value = 6;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callback.onFinish(value);
        });
    }


}

