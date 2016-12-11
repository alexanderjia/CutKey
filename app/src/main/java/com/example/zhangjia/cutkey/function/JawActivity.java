package com.example.zhangjia.cutkey.function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class JawActivity extends BaseActivity {
    private String title;
    private String jaw;
    private TextView jawname;
    private Button process;
    private int serialid;

    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_jaw,null);
        jawname = (TextView)view.findViewById(R.id.tv_jaw);
        process = (Button)view.findViewById(R.id.btn_true);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        showhomeVisible(View.VISIBLE);
        title = getIntent().getStringExtra("carfactory");
        serialid = getIntent().getIntExtra("serialid",0);
        setTitle(title);
        jaw = getIntent().getStringExtra("jaw");
        jawname.setText(jaw);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KeyJawActivity.class);
                intent.putExtra("carfactory",title);
                intent.putExtra("jaw",jaw);
                intent.putExtra("serialid",serialid);
                startActivity(intent);
            }
        });
    }
}
