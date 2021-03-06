package com.example.maoyh.tctest.activity;

/**
 * Created by MAOYH on 2016/3/9.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.until.AppUtils;



/**
 * 含有单个Fragement的Activity
 *
 * @author Weiping Liu
 * @version 1.0.0
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    private final static String TAG = SingleFragmentActivity.class.getSimpleName();

    /**
     * TODO 注释
     * @return
     */
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlefragent);
        AppUtils.setActivity(this);// 保存当前的activity
        AppUtils.setContext(getApplicationContext()); // 保存context
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container); // 主要所有Fragment的id都必须是这个
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    protected void onResume(){
        super.onResume();
        AppUtils.setActivity(this);
        AppUtils.setContext(getApplicationContext()); // 保存context
    }

//    public void finish(){
//        Util.homeActivityList.remove(this);
//        Util.activityLoginList.remove(this);
////		Util.activityList.remove(this);
//        Util.activityRecommonedList.remove(this);
//        Util.actList.remove(this);
//        super.finish();
//    }
}

