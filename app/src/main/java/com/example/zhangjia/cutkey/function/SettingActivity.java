package com.example.zhangjia.cutkey.function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class SettingActivity extends BaseActivity {
    private RelativeLayout deviation;
    private RelativeLayout jaw;
    private RelativeLayout change;
    private RelativeLayout point;
    private RelativeLayout biaoding;
    private RelativeLayout xiaozhun;

    @Override
    protected View initView() {
        View view = View.inflate(this, R.layout.activity_setting, null);
        deviation = (RelativeLayout)view.findViewById(R.id.rl_deviation);
        jaw = (RelativeLayout)view.findViewById(R.id.rl_jaw);
        change = (RelativeLayout)view.findViewById(R.id.rl_change);
        point = (RelativeLayout)view.findViewById(R.id.rl_point);
        biaoding = (RelativeLayout)view.findViewById(R.id.rl_biaoding);
        xiaozhun = (RelativeLayout)view.findViewById(R.id.rl_xiaozhun);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        setTitle("加工设置");
        deviation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DeviationSettingActivity.class);
                startActivity(intent);
            }
        });
        jaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        biaoding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        xiaozhun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
