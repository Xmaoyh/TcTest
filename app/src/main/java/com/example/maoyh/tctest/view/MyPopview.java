package com.example.maoyh.tctest.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.maoyh.tctest.R;


/**
 * Created by MAOYH on 2016/3/9.
 */
public class MyPopview extends PopupWindow{
    private Button btn_peizai;
    private LayoutInflater layoutInflater ;

    public MyPopview(Activity context ) {
        super(context);
       layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.popupwindow_map,null);
        btn_peizai = (Button) v.findViewById(R.id.btn_peizai);
        btn_peizai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

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
    }
}
