package com.example.zhangjia.cutkey.function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class OptionActivity extends BaseActivity {
    private RelativeLayout functontest;

    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_option,null);
        functontest = (RelativeLayout)view.findViewById(R.id.rl_function_test);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        setTitle("选项");
        functontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FunctionTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
