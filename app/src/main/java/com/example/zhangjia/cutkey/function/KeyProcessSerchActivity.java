package com.example.zhangjia.cutkey.function;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class KeyProcessSerchActivity extends BaseActivity {


    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_key_process_serch,null);
        return view;
    }

    @Override
    protected void initDate() {
        showhomeVisible(View.VISIBLE);
        showbackVisible(View.VISIBLE);
    }
}
