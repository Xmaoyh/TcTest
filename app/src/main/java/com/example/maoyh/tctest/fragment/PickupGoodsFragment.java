package com.example.maoyh.tctest.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.until.AppUtils;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class PickupGoodsFragment extends Fragment {
    /**
     * 需要传递参数时有利于解耦
     */
    public static PickupGoodsFragment newInstance() {
        Bundle args = new Bundle();
        PickupGoodsFragment fragment = new PickupGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Activity getMyActivity() {
        Activity act = getActivity();
        if (act == null) {
            act = AppUtils.getActivity();
        }
        return act;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pickupgoods,null);
        return v;

    }
}
