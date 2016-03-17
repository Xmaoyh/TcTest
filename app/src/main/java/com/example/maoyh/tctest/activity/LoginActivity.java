package com.example.maoyh.tctest.activity;

import android.os.Bundle;

import com.example.maoyh.tctest.R;

import butterknife.ButterKnife;

/**
 * Created by MAOYH on 2016/3/15.
 */
public class LoginActivity extends android.app.Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
