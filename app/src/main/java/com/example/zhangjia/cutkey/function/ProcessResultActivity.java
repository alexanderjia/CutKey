package com.example.zhangjia.cutkey.function;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class ProcessResultActivity extends BaseActivity {
    private String title;
    private String jaw;
    private int serialid;

    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_process_result,null);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        showbackVisible(View.VISIBLE);
        String a = "dlkajeoia";
        title = getIntent().getStringExtra("carfactory");
        setTitle(title);
        jaw = getIntent().getStringExtra("jaw");
        serialid = getIntent().getIntExtra("serialid",0);
        showDialognow();

    }

    private void showDialognow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = this.getLayoutInflater().inflate(R.layout.resultdialog,null);
        TextView conten = (TextView)view.findViewById(R.id.tv_notice);
        TextView cancel = (TextView)view.findViewById(R.id.tv_cancel);
        TextView ok = (TextView)view.findViewById(R.id.tv_ok);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

}
