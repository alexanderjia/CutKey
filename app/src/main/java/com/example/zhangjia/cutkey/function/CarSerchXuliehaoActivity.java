package com.example.zhangjia.cutkey.function;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.AxisData;
import com.example.zhangjia.cutkey.background.bean.KeyShapeData;
import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;
import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.ToothCodesDatas;
import com.example.zhangjia.cutkey.background.bean.ToothCutLengthData;
import com.example.zhangjia.cutkey.background.bean.ToothSpaceData;
import com.example.zhangjia.cutkey.background.model.ModelMachiningSerial;
import com.example.zhangjia.cutkey.background.model.ModelMachiningUnlockToolCode;
import com.example.zhangjia.cutkey.base.BaseActivity;
import com.example.zhangjia.cutkey.view.ProcessView;

import java.util.ArrayList;
import java.util.List;

public class CarSerchXuliehaoActivity extends BaseActivity {
    private String title;
    private int factoryindex;
    private int serialid;
    private String serial;
    private EditText input;
    private LinearLayout process1;
    private LinearLayout process2;
    private LinearLayout process3;
    private LinearLayout process4;
    private LinearLayout process5;
    private LinearLayout process6;
    private LinearLayout process7;
    private LinearLayout process8;
    private LinearLayout process9;
    private LinearLayout process10;
    private LinearLayout process11;
    private LinearLayout process12;
    private LinearLayout process13;
    private LinearLayout process14;
    private LinearLayout process15;
    private LinearLayout process16;
    private LinearLayout process17;
    private LinearLayout process18;
    private LinearLayout process19;
    private LinearLayout process20;
    private List<LinearLayout> processlist = new ArrayList<>();
    private TextView tvprocess1;
    private TextView tvprocess2;
    private TextView tvprocess3;
    private TextView tvprocess4;
    private TextView tvprocess5;
    private TextView tvprocess6;
    private TextView tvprocess7;
    private TextView tvprocess8;
    private TextView tvprocess9;
    private TextView tvprocess10;
    private TextView tvprocess11;
    private TextView tvprocess12;
    private TextView tvprocess13;
    private TextView tvprocess14;
    private TextView tvprocess15;
    private TextView tvprocess16;
    private TextView tvprocess17;
    private TextView tvprocess18;
    private TextView tvprocess19;
    private TextView tvprocess20;
    private List<TextView> textViews = new ArrayList<>();
    private ProcessView myview;
    private List<Point> points1 = new ArrayList<>();
    private List<Point> points2 = new ArrayList<>();
    private MachiningData machiningData;
    private ModelMachiningSerial modelMachiningSerial;
    private TextView diameter;
    private TextView divth;
    private ToothSpaceData toothSpaceData;
    private List<AxisData> axisDatas = new ArrayList<>();
    private List<ToothCutLengthData> cutLengthDatas = new ArrayList<>();
    private TextView type1;
    private TextView type2;
    private TextView type3;
    private TextView type4;
    private TextView type5;
    private TextView type6;
    private TextView type7;
    private TextView type8;
    private TextView type9;
    private TextView type10;
    private TextView type11;
    private TextView type12;
    private TextView type13;
    private TextView type14;
    private TextView type15;
    private TextView type16;
    private TextView type17;
    private TextView type18;
    private TextView type19;
    private TextView type20;
    private List<TextView> type = new ArrayList<>();
    private KeyShapeDatas keyShapeData;
    private List<KeyShapeData> shapeDatas = new ArrayList<>();
    private Button draw;

    @Override
    protected View initView() {
        View view = View.inflate(this, R.layout.activity_car_serch_xuliehao, null);
        myview = (ProcessView) view.findViewById(R.id.myview);
        process1 = (LinearLayout) view.findViewById(R.id.ll_process_1);
        process2 = (LinearLayout) view.findViewById(R.id.ll_process_2);
        process3 = (LinearLayout) view.findViewById(R.id.ll_process_3);
        process4 = (LinearLayout) view.findViewById(R.id.ll_process_4);
        process5 = (LinearLayout) view.findViewById(R.id.ll_process_5);
        process6 = (LinearLayout) view.findViewById(R.id.ll_process_6);
        process7 = (LinearLayout) view.findViewById(R.id.ll_process_7);
        process8 = (LinearLayout) view.findViewById(R.id.ll_process_8);
        process9 = (LinearLayout) view.findViewById(R.id.ll_process_9);
        process10 = (LinearLayout) view.findViewById(R.id.ll_process_10);
        process11 = (LinearLayout) view.findViewById(R.id.ll_process_11);
        process12 = (LinearLayout) view.findViewById(R.id.ll_process_12);
        process13 = (LinearLayout) view.findViewById(R.id.ll_process_13);
        process14 = (LinearLayout) view.findViewById(R.id.ll_process_14);
        process15 = (LinearLayout) view.findViewById(R.id.ll_process_15);
        process16 = (LinearLayout) view.findViewById(R.id.ll_process_16);
        process17 = (LinearLayout) view.findViewById(R.id.ll_process_17);
        process18 = (LinearLayout) view.findViewById(R.id.ll_process_18);
        process19 = (LinearLayout) view.findViewById(R.id.ll_process_19);
        process20 = (LinearLayout) view.findViewById(R.id.ll_process_20);
        diameter = (TextView) view.findViewById(R.id.tv_tool_num);
        divth = (TextView) view.findViewById(R.id.tv_deep_num);
        draw = (Button)view.findViewById(R.id.btn_draw);
        return view;
    }

    @Override
    protected void initDate() {
        title = getIntent().getStringExtra("carfactotyname");
        setTitle(title);
        showbackVisible(View.VISIBLE);
        showhomeVisible(View.VISIBLE);
        modelMachiningSerial = new ModelMachiningSerial();
        factoryindex = getIntent().getIntExtra("factoryindex", 0);
        serialid = getIntent().getIntExtra("serialid", 0);
        serial = getIntent().getStringExtra("serial");
        processViewAdd();
        adddata();
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemselect();
                myview.process(points1,points2);
            }
        });
    }

    private void processViewAdd() {
        processlist.add(process1);
        processlist.add(process2);
        processlist.add(process3);
        processlist.add(process4);
        processlist.add(process5);
        processlist.add(process6);
        processlist.add(process7);
        processlist.add(process8);
        processlist.add(process9);
        processlist.add(process10);
        processlist.add(process11);
        processlist.add(process12);
        processlist.add(process13);
        processlist.add(process14);
        processlist.add(process15);
        processlist.add(process16);
        processlist.add(process17);
        processlist.add(process18);
        processlist.add(process19);
        processlist.add(process20);
    }

    private void adddata() {
        textViews.add(tvprocess1);
        textViews.add(tvprocess2);
        textViews.add(tvprocess3);
        textViews.add(tvprocess4);
        textViews.add(tvprocess5);
        textViews.add(tvprocess6);
        textViews.add(tvprocess7);
        textViews.add(tvprocess8);
        textViews.add(tvprocess9);
        textViews.add(tvprocess10);
        textViews.add(tvprocess11);
        textViews.add(tvprocess12);
        textViews.add(tvprocess13);
        textViews.add(tvprocess14);
        textViews.add(tvprocess15);
        textViews.add(tvprocess16);
        textViews.add(tvprocess17);
        textViews.add(tvprocess18);
        textViews.add(tvprocess19);
        textViews.add(tvprocess20);
        type.add(type1);
        type.add(type2);
        type.add(type3);
        type.add(type4);
        type.add(type5);
        type.add(type6);
        type.add(type7);
        type.add(type8);
        type.add(type9);
        type.add(type10);
        type.add(type11);
        type.add(type12);
        type.add(type13);
        type.add(type14);
        type.add(type15);
        type.add(type16);
        type.add(type17);
        type.add(type18);
        type.add(type19);
        type.add(type20);
    }

    private void itemselect() {
        points1.clear();
        points2.clear();
        myview.process(points1, points2);


        for (int i = 0; i < processlist.size(); i++) {
            processlist.get(i).setVisibility(View.GONE);
            textViews.get(i).setText("?");
        }
        machiningData = new MachiningData();
        keyShapeData = new KeyShapeDatas();
        keyShapeData = modelMachiningSerial.getKeyShapePointsData(serialid, serial);
        shapeDatas = keyShapeData.getData();
        points1 = shapeDatas.get(0).getShape();
        points2 = shapeDatas.get(1).getShape();
        machiningData = modelMachiningSerial.getMachiningData(serialid);
        String dia = machiningData.getCutterDiameter() + "";
        String deep = machiningData.getCuttingDepth() + "";
        diameter.setText(dia);
        divth.setText(deep);
        toothSpaceData = new ToothSpaceData();
        toothSpaceData = machiningData.getToothSpaceData();
        axisDatas = toothSpaceData.getData();

        for (int i = 0; i < axisDatas.size(); i++) {
            cutLengthDatas = axisDatas.get(i).getAxisDatas();
        }
        for (int i = 0; i < cutLengthDatas.size(); i++) {
            processlist.get(i).setVisibility(View.VISIBLE);
            type.get(i).setText(cutLengthDatas.get(i).getLength() + "");
        }

    }
}
