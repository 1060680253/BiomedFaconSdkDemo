package com.biomed.facon.ftc.demo;

import androidx.multidex.MultiDexApplication;

import com.biomed.facon.ftc.sdk.DetectionManager;

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DetectionManager.init(this,"dev_z9a5wF6G","Tn9QFHABA2ieFptt");
    }
}
