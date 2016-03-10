package com.example.maoyh.tctest.activity;

import android.app.Fragment;

import com.example.maoyh.tctest.fragment.WuliuFragment;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class WuliuActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return WuliuFragment.newInstance();
    }
}
