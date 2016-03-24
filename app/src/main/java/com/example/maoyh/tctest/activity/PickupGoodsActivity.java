package com.example.maoyh.tctest.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.apiservice.StowageService;
import com.example.maoyh.tctest.jsonBean.JsonDriver;
import com.example.maoyh.tctest.until.AppUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class PickupGoodsActivity extends AppCompatActivity {
    @Bind(R.id.message)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pickupgoods);
        ButterKnife.bind(this);
//        OkHttpUtils.get()
//                .url("http://192.168.199.110:8080/mockjs/1/getLoadingSheetList?")
//                .build()
//                .execute(new JsonDriver().new DriverCallback() {
//                    @Override
//                    public void onError(Call call, Exception e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(JsonDriver response) {
//                        mTextView.setText(String.valueOf(response.getCount()));
//                    }
//                });

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://192.168.199.110:8080/mockjs/1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
        Retrofit retrofit = AppUtils.getRetrofit("http://192.168.199.110:8080/mockjs/1/");
        StowageService stowageService  = retrofit.create(StowageService.class);
        Observable<JsonDriver> observable = stowageService.getLoadingSheetList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JsonDriver>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JsonDriver jsonDriver) {
                        String msg =jsonDriver.getDataList().get(0).getFinishDate();
                        mTextView.setText(msg);
                        Log.e("信息",jsonDriver.toString()+jsonDriver.getDataList().get(0).toString());
                    }
                });







//        OkHttpClient mClient = new OkHttpClient();
//        Request mRequest = new Request.Builder()
//                .url("http://192.168.199.110:8080/mockjs/1/getLoadingSheetList?")
//                .build();
//        mClient.newCall(mRequest).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//
//                Gson gson = new Gson();
//                String result = response.body().string();
//                Log.e("message", result);
//                mJsonDriver = new JsonDriver();
//                mJsonDriver = gson.fromJson(result, JsonDriver.class);
//                            final  int count = mJsonDriver.getCount();
//                            Log.e("message2", String.valueOf(count));
//
//                final String endStation = mJsonDriver.getDataList().get(0).getEndStation();
//                Log.e("message2", endStation);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mTextView.setText(endStation);
//                    }
//                });
//            }
//        });
    }


}
