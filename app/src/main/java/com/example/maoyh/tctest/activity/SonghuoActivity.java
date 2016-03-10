package com.example.maoyh.tctest.activity;

import android.app.Fragment;

import com.example.maoyh.tctest.fragment.SonghuoFragment;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class SonghuoActivity  extends SingleFragmentActivity {


    protected Fragment createFragment() {
        return SonghuoFragment.newInstance();
    }
}
