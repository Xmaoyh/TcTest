package com.example.maoyh.tctest.until;

/**
 * Created by MAOYH on 2016/3/9.
 */

import android.app.Activity;
import android.content.Context;

import com.example.maoyh.tctest.apiservice.StowageService;
import com.example.maoyh.tctest.jsonBean.JsonDriver;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * 添加activity
 * @author ad
 *
 */
public class AppUtils {

    private static Activity activity;

    private static Context sContext;

    /**
     * 获得当前的activity
     * @return
     */
    public static Activity getActivity(){
        return activity;
    }

    /**
     * 添加activity
     * @param act
     */
    public static void setActivity(Activity act){
        activity=act;
    }

    /**
     * 获得当前的Context
     * @return
     */
    public static Context getContext(){
        return sContext;
    }

    /**
     * 添加Context
     * @param act
     */
    public static void setContext(Context context){
        sContext = context;
    }

    public static Retrofit getRetrofit (String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return  retrofit;

    }
}
