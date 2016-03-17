package com.example.maoyh.tctest.activity;


import android.support.v4.app.Fragment;

import com.example.maoyh.tctest.fragment.PickupGoodsFragment;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class PickupGoodsActivity extends SingleFragmentActivity {


    protected Fragment createFragment() {
        return PickupGoodsFragment.newInstance();
    }
}
