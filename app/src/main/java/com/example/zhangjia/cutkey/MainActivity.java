package com.example.zhangjia.cutkey;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zhangjia.cutkey.base.BaseActivity;
import com.example.zhangjia.cutkey.function.InfoActivity;
import com.example.zhangjia.cutkey.function.OptionActivity;
import com.example.zhangjia.cutkey.function.QueueJobsActivity;
import com.example.zhangjia.cutkey.function.SerchActivity;
import com.example.zhangjia.cutkey.function.SettingActivity;
import com.example.zhangjia.cutkey.function.WorkRecodActivity;


public class MainActivity extends BaseActivity {
    private LinearLayout serch;//钥匙查找
    private LinearLayout recod;//工作记录
    private LinearLayout qjobs;//钥匙加工
    private LinearLayout setting;//加工设置
    private LinearLayout option;//选项
    private LinearLayout info;//信息

    @Override
    protected View initView() {
        View view = View.inflate(this, R.layout.activity_main, null);
        serch = (LinearLayout) view.findViewById(R.id.ll_serch);
        recod = (LinearLayout) view.findViewById(R.id.ll_wrecod);
        qjobs = (LinearLayout) view.findViewById(R.id.ll_qjobs);
        setting = (LinearLayout) view.findViewById(R.id.ll_setting);
        option = (LinearLayout) view.findViewById(R.id.ll_option);
        info = (LinearLayout) view.findViewById(R.id.ll_info);
        return view;
    }

    @Override
    protected void initDate() {
        setTitle("CutKey");
        //搜索跳转
        serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SerchActivity.class);
                startActivity(intent);
            }
        });
        //工作记录跳转
        recod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkRecodActivity.class);
                startActivity(intent);
            }
        });
        //钥匙加工跳转
        qjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QueueJobsActivity.class);
                startActivity(intent);
            }
        });
        //加工设置跳转
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        //选项跳转
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptionActivity.class);
                startActivity(intent);
            }
        });
        //信息跳转
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }

}
