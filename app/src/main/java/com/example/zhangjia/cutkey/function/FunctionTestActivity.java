package com.example.zhangjia.cutkey.function;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class FunctionTestActivity extends BaseActivity {


    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_function_test,null);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        showhomeVisible(View.VISIBLE);
        setTitle("功能测试");
    }
}
