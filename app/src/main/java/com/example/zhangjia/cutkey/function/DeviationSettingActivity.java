package com.example.zhangjia.cutkey.function;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.model.ModelAxisOffSet;
import com.example.zhangjia.cutkey.base.BaseActivity;

public class DeviationSettingActivity extends BaseActivity {
    private ModelAxisOffSet modelAxisOffSet;
    private EditText x_ed;
    private EditText y_ed;
    private EditText z__ed;
    private Button read;
    private Button save;
    private int[] axis = new int[3];


    @Override
    protected View initView() {
        View view = View.inflate(context,R.layout.activity_deviation_setting,null);
        x_ed = (EditText)view.findViewById(R.id.et_xde);
        y_ed = (EditText)view.findViewById(R.id.et_yde);
        z__ed = (EditText)view.findViewById(R.id.et_zde);
        read = (Button)view.findViewById(R.id.btn_read);
        save = (Button)view.findViewById(R.id.btn_save);
        return view;
    }

    @Override
    protected void initDate() {
        setTitle("偏差设置");
        showhomeVisible(View.VISIBLE);
        showbackVisible(View.VISIBLE);

        modelAxisOffSet = new ModelAxisOffSet();
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                axis = modelAxisOffSet.getOffsetData();
                x_ed.setText(axis[0] + "");
                y_ed.setText(axis[1] + "");
                z__ed.setText(axis[2] + "");
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.valueOf(x_ed.getText().toString());
                int y = Integer.valueOf(y_ed.getText().toString());
                int z = Integer.valueOf(z__ed.getText().toString());
                modelAxisOffSet.saveOffsetData(x,y,z);
            }
        });

    }
}
