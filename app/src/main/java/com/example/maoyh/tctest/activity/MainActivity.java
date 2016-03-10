package com.example.maoyh.tctest.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.entity.TabEntity;
import com.example.maoyh.tctest.fragment.MissonFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private CommonTabLayout mTabLayout;
    private String[] mTitles = {"任务", "档案", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_more_select};
    //tab的标题、选中图标、未选中图标
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initData();
        initView();
        //给tab设置数据和关联的fragment
        mTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
        //设置红点
        mTabLayout.showDot(1);
        mTabLayout.showMsg(0,88);

    }

    private void initView() {
        mTabLayout = (CommonTabLayout) findViewById(R.id.tl);
    }

    private void initData() {

        mFragments.add(new MissonFragment());
        mFragments.add(new MissonFragment());
        mFragments.add(new MissonFragment());


        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }
}
