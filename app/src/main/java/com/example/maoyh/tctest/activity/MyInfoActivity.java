package com.example.maoyh.tctest.activity;

import android.support.v4.app.Fragment;

import com.example.maoyh.tctest.fragment.MyInfoFragment;

/**
 * Created by MAOYH on 2016/3/14.
 */
public class MyInfoActivity extends SingleFragmentActivity {
    protected Fragment createFragment() {
        return MyInfoFragment.newInstance();
    }
}
