package com.example.zhangjia.cutkey.function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class QueueJobsActivity extends BaseActivity {
    private LinearLayout codeprocess;
    private LinearLayout toothprocess;

    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_queue_jobs,null);
        codeprocess = (LinearLayout)view.findViewById(R.id.ll_code_prcess);
        toothprocess = (LinearLayout)view.findViewById(R.id.ll_tooth_process);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        setTitle("钥匙加工");
        codeprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CodePrcessActivity.class);
                startActivity(intent);
            }
        });
        toothprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ToothProcessActivity.class);
                startActivity(intent);
            }
        });
    }
}
