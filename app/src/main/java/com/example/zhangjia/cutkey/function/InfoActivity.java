package com.example.zhangjia.cutkey.function;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class InfoActivity extends BaseActivity {


    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_info,null);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        setTitle("信息");
    }
}
