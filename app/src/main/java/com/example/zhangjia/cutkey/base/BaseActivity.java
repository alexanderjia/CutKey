package com.example.zhangjia.cutkey.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhangjia.cutkey.MainActivity;
import com.example.zhangjia.cutkey.R;



public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected TextView tv_title;
    protected RelativeLayout rl_content;
    protected RelativeLayout rl_back;
    protected RelativeLayout rl_home;
    protected Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        tv_title = (TextView)findViewById(R.id.tv_title);
        rl_content = (RelativeLayout)findViewById(R.id.rl_content);
        rl_home = (RelativeLayout)findViewById(R.id.rl_home);
        rl_back = (RelativeLayout)findViewById(R.id.rl_back);
        View view = initView();
        rl_content.addView(view);
        initDate();
        rl_back.setOnClickListener(this);
        rl_home.setOnClickListener(this);
    }

    /**
     * view
     *
     * @return
     */
    protected abstract View initView();

    /**
     * 填充数据
     */
    protected abstract void initDate();

    /**
     * 设置toolbar标题
     *
     * @param title
     */
    protected void setTitle(String title) {
        tv_title.setText(title);
    }

    /**
     * 设置返回按钮可见
     */
    protected void showbackVisible(int visiblity){
        rl_back.setVisibility(visiblity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_home:
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
        }
    }
    /**
     * 设置home键可见
     */
    protected void showhomeVisible(int visblity){
        rl_home.setVisibility(visblity);
    }
}
