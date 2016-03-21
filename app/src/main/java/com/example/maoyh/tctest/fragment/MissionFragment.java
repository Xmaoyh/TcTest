package com.example.maoyh.tctest.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.activity.LogisticsActivity;
import com.example.maoyh.tctest.activity.PickupGoodsActivity;
import com.readystatesoftware.viewbadger.BadgeView;

public class MissionFragment extends Fragment implements View.OnClickListener {
	private  static View v = null;
	private ImageView iv_songhuo,iv_jiedan,iv_wuliu,iv_kucun;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = inflater.inflate(R.layout.fragment_mission, null);
		initView();
		return v;
	}

	private void initView() {
		iv_songhuo = (ImageView) v.findViewById(R.id.iv_songhuo);
		iv_jiedan = (ImageView) v.findViewById(R.id.iv_jiedan);
		iv_wuliu = (ImageView) v.findViewById(R.id.iv_wuliu);
		iv_kucun = (ImageView) v.findViewById(R.id.iv_kucun);
		BadgeView badge1 = new BadgeView(getActivity(),iv_songhuo);
		badge1.setText("99+");
		badge1.show();
		BadgeView badge2 = new BadgeView(getActivity(),iv_jiedan);
		badge2.setText("99+");
		badge2.show();
		BadgeView badge3 = new BadgeView(getActivity(),iv_kucun);
		badge3.setText("15");
		badge3.show();

		iv_songhuo.setOnClickListener(this);
		iv_jiedan.setOnClickListener(this);
		iv_wuliu.setOnClickListener(this);
		iv_kucun.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.iv_songhuo:
				startActivity(new Intent(getActivity(), PickupGoodsActivity.class));
				break;
			case R.id.iv_wuliu:
				startActivity(new Intent(getActivity(), LogisticsActivity.class));
				break;
		}
	}
}
