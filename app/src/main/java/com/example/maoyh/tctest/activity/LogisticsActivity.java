package com.example.maoyh.tctest.activity;


import android.support.v4.app.Fragment;

import com.example.maoyh.tctest.fragment.LogisticsMapFragment;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class LogisticsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return LogisticsMapFragment.newInstance();
    }
}
