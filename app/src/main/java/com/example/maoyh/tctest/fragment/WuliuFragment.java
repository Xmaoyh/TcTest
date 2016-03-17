package com.example.maoyh.tctest.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.until.AppUtils;
import com.example.maoyh.tctest.view.MyPopview;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class WuliuFragment extends Fragment {
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    // 有被点击过的marker
    boolean checked;
    // 已点过的marker
    Marker previousMarker = null;

    /**
     * 需要传递参数时有利于解耦
     */
    public static WuliuFragment newInstance() {
        Bundle args = new Bundle();
        WuliuFragment fragment = new WuliuFragment();
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

        View v = inflater.inflate(R.layout.fragment_wuliu, null);
        init(v);
        return v;
    }

    private void init(final View v) {
        mMapView = (MapView) v.findViewById(R.id.mbaidmap);
        MapStatus ms = new MapStatus.Builder()
                .target(new LatLng(30.2817240000, 119.9980410000)).zoom(8)
                .build();

        mBaiduMap = mMapView.getMap();
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
        for (int i = 0; i < 3; i++) {
            addCar(new LatLng(30.2817240000 + Math.random(), 119.9980410000 + Math.random()), "notfull");
            addCar(new LatLng(30.2817240000 + Math.random(), 119.9980410000 + Math.random()), "full");
        }

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (checked) {
                    switch ( previousMarker.getTitle()) {
                        case "t_full":
                            previousMarker.setIcon(BitmapDescriptorFactory
                                    .fromResource(R.mipmap.car_full));


                            break;
                        case "t_notfull":
                            previousMarker.setIcon(BitmapDescriptorFactory
                                    .fromResource(R.mipmap.car_notfull));

                            break;
                    }

                    checked = false;
                }
                marker.setIcon(BitmapDescriptorFactory
                        .fromResource(R.mipmap.car_set));
                // 此marker已经点过，作为上一次点击的marker
                checked = true;
                previousMarker = marker;
                showPopwindow(v);
                return false;
            }
        });
    }

    private void showPopwindow(View parent) {

        MyPopview myPopview = new MyPopview(getActivity());
        myPopview.showAtLocation(parent, Gravity.BOTTOM, 0, 0);

    }

    private void addCar(LatLng location, String state) {

        // TODO Auto-generated method stub
        switch (state) {

            case "full":
                OverlayOptions carfull = new MarkerOptions()
                        .title("t_full")
                        .position(location)
                        .icon(BitmapDescriptorFactory
                                .fromResource(R.mipmap.car_full));
                mBaiduMap.addOverlay(carfull);
                break;
            case "notfull":
                OverlayOptions carnotfull = new MarkerOptions()
                        .title("t_notfull")
                        .position(location)
                        .icon(BitmapDescriptorFactory
                                .fromResource(R.mipmap.car_notfull));
                mBaiduMap.addOverlay(carnotfull);
                break;
        }


    }

}


