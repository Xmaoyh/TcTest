package com.example.maoyh.tctest.until;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;


/**
 * Created by MAOYH on 2016/3/9.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        //OkHttpUtils.getInstance().debug("testDebug");

    }
}
