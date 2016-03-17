package com.example.maoyh.tctest.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.activity.MyInfoActivity;
import com.example.maoyh.tctest.until.AppUtils;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class MyHomeFragment extends Fragment {
    /**
     * 需要传递参数时有利于解耦
     */
    public static MyHomeFragment newInstance() {
        Bundle args = new Bundle();
        MyHomeFragment fragment = new MyHomeFragment();
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
        View v = inflater.inflate(R.layout.fragment_my, null);

        init(v);
        return v;
    }

    private void init( View v) {
        LinearLayout myLinearLayout = (LinearLayout) v.findViewById(R.id.linearlayout_myinfo);
        myLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MyInfoActivity.class));
            }
        });
    }
}
