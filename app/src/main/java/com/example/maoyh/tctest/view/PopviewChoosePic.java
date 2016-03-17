package com.example.maoyh.tctest.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.maoyh.tctest.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by MAOYH on 2016/3/9.
 */
public class PopviewChoosePic extends PopupWindow implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_take_photo:
                mPopviewclickListener.OnTopClick();
                break;
            case R.id.btn_pick_photo:
                mPopviewclickListener.OnMiddleClick();
                break;
            case R.id.btn_cancel:
                mPopviewclickListener.OnBottomClick();
                break;
        }
        mPopviewclickListener.OnBottomClick();
    }

    public interface PopviewclickListener{
        void OnTopClick();
        void OnMiddleClick();
        void OnBottomClick();
    }
    private PopviewclickListener mPopviewclickListener;
    @Bind(R.id.btn_take_photo)
    Button mBtnTakePhoto;
    @Bind(R.id.btn_pick_photo)
    Button mBtnPickPhoto;
    @Bind(R.id.btn_cancel)
    Button mBtnCancel;
    private LayoutInflater layoutInflater;

    public PopviewChoosePic(Activity context) {
        super(context);
        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.popupwindow_choosepic, null);
        ButterKnife.bind(this,v);
        this.setContentView(v);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow弹出窗体动画效果
        //this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x000000);
        //设置PopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(R.style.popwin_anim_style);
        mBtnTakePhoto.setOnClickListener(this);
        mBtnPickPhoto.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    public void setPopviewclickListener(PopviewclickListener listener){
       this.mPopviewclickListener = listener;
    }
}
