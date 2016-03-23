package com.example.maoyh.tctest.apiservice;

import com.example.maoyh.tctest.jsonBean.JsonDriver;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by MAOYH on 2016/3/23.
 */
public interface StowageService {
    @GET("getLoadingSheetList?")
    Observable<JsonDriver> getLoadingSheetList();
}
