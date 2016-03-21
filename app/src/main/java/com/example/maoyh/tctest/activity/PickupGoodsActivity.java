package com.example.maoyh.tctest.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.jsonBean.JsonDriver;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class PickupGoodsActivity extends AppCompatActivity {
    private JsonDriver mJsonDriver;
    @Bind(R.id.message)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pickupgoods);
        ButterKnife.bind(this);
        OkHttpClient mClient = new OkHttpClient();
        Request mRequest = new Request.Builder()
                .url("http://192.168.199.110:8080/mockjs/1/getLoadingSheetList?")
                .build();
        mClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                Gson gson = new Gson();
                String result = response.body().string();
                Log.e("message", result);
                mJsonDriver = new JsonDriver();
                mJsonDriver = gson.fromJson(result, JsonDriver.class);
                            final  int count = mJsonDriver.getCount();
                            Log.e("message2", String.valueOf(count));

                final List<JsonDriver.DataListBean> loadingPointList = mJsonDriver.getDataList();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //mTextView.setText(String.valueOf(mJsonDriver.getDataList()));
                       
                    }
                }).start();
            }
        });
    }


}
