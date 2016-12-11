package com.example.zhangjia.cutkey.function;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangjia.cutkey.MainActivity;
import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.AxisData;
import com.example.zhangjia.cutkey.background.bean.KeyShapeData;
import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;
import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.MachiningHistory;
import com.example.zhangjia.cutkey.background.bean.ToothCodeData;
import com.example.zhangjia.cutkey.background.bean.ToothCodesData;
import com.example.zhangjia.cutkey.background.bean.ToothCodesDatas;
import com.example.zhangjia.cutkey.background.bean.ToothCutLengthData;
import com.example.zhangjia.cutkey.background.bean.ToothSpaceData;
import com.example.zhangjia.cutkey.background.data.MachiningDatas;
import com.example.zhangjia.cutkey.background.model.ModelMachiningUnlockToolCode;
import com.example.zhangjia.cutkey.background.presenter.PresenterMachiningUnlockToolCode;
import com.example.zhangjia.cutkey.base.BaseActivity;
import com.example.zhangjia.cutkey.bean.Key;
import com.example.zhangjia.cutkey.view.ProcessView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ToothProcessActivity extends BaseActivity {
    private List<MachiningHistory> keylist = new ArrayList<>();
    private ListView keys;
    private View listhead;
    private KeyAdapter adapter;
    //钥匙参数输入
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
    private int whichSelect = -1;//输入框选择
    //参数选择
    private LinearLayout key1;
    private LinearLayout key2;
    private LinearLayout key3;
    private LinearLayout key4;
    private LinearLayout key5;
    private LinearLayout key6;
    private LinearLayout key7;
    private LinearLayout key8;
    private LinearLayout key9;
    private LinearLayout key10;
    private RelativeLayout keyunkown;
    //参数文本
    private TextView tvkey1;
    private TextView tvkey2;
    private TextView tvkey3;
    private TextView tvkey4;
    private TextView tvkey5;
    private TextView tvkey6;
    private TextView tvkey7;
    private TextView tvkey8;
    private TextView tvkey9;
    private TextView tvkey10;
    private List<TextView> textViews = new ArrayList<>();
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
    private TextView detp1;
    private TextView detp2;
    private TextView detp3;
    private TextView detp4;
    private TextView detp5;
    private TextView detp6;
    private TextView detp7;
    private TextView detp8;
    private TextView detp9;
    private TextView detp10;
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
    private ProcessView myview;
    private ModelMachiningUnlockToolCode modelMachiningUnlockToolCode;
    private int selection = 0;
    private MachiningData machiningData;
    private ToothCodesDatas toothCodesData;//编码输入控件个数
    private List<ToothCodesData> toothCodesDataList = new ArrayList<>();
    private List<ToothCodeData> datas = new ArrayList<>();
    private List<ToothCutLengthData> cutLengthDatas = new ArrayList<>();
    private ToothSpaceData toothSpaceData;
    private List<AxisData> axisDatas = new ArrayList<>();
    private List<LinearLayout> inputlist = new ArrayList<>();
    private List<TextView> inputtext = new ArrayList<>();
    private List<TextView> detp = new ArrayList<>();
    private List<TextView> type = new ArrayList<>();
    private StringBuffer sb;
    private KeyShapeDatas keyShapeDatas;
    private int serialid;
    private List<KeyShapeData> shapeDatas = new ArrayList<>();
    private List<Point> points1 = new ArrayList<>();
    private List<Point> points2 = new ArrayList<>();
    private RelativeLayout serch;
    private TextView diameter;
    private TextView divth;
    private TextView num;
    private RelativeLayout process;
    private ProgressDialog dialog;
    private RelativeLayout serchkey;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    dialog.dismiss();
                    num.setText(keylist.size() + "");
                    Log.d("jiagong", keylist.size() + "");
                    adddata();
                    adapter = new KeyAdapter();
                    keys.setAdapter(adapter);
                    itemselect(0);
                    process1.setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect = 0;
                    break;
            }
        }
    };


    @Override
    protected View initView() {
        View view = View.inflate(this, R.layout.activity_tooth_process, null);
        keys = (ListView) view.findViewById(R.id.lv_key);
        serchkey = (RelativeLayout)view.findViewById(R.id.rl_serch_key);
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
        key1 = (LinearLayout) view.findViewById(R.id.ll_key_1);
        key2 = (LinearLayout) view.findViewById(R.id.ll_key_2);
        key3 = (LinearLayout) view.findViewById(R.id.ll_key_3);
        key4 = (LinearLayout) view.findViewById(R.id.ll_key_4);
        key5 = (LinearLayout) view.findViewById(R.id.ll_key_5);
        key6 = (LinearLayout) view.findViewById(R.id.ll_key_6);
        key7 = (LinearLayout) view.findViewById(R.id.ll_key_7);
        key8 = (LinearLayout) view.findViewById(R.id.ll_key_8);
        key9 = (LinearLayout) view.findViewById(R.id.ll_key_9);
        key10 = (LinearLayout) view.findViewById(R.id.ll_key_10);
        keyunkown = (RelativeLayout) view.findViewById(R.id.rl_unkown);
        tvkey1 = (TextView) view.findViewById(R.id.tv_key_1);
        tvkey2 = (TextView) view.findViewById(R.id.tv_key_2);
        tvkey3 = (TextView) view.findViewById(R.id.tv_key_3);
        tvkey4 = (TextView) view.findViewById(R.id.tv_key_4);
        tvkey5 = (TextView) view.findViewById(R.id.tv_key_5);
        tvkey6 = (TextView) view.findViewById(R.id.tv_key_6);
        tvkey7 = (TextView) view.findViewById(R.id.tv_key_7);
        tvkey8 = (TextView) view.findViewById(R.id.tv_key_8);
        tvkey9 = (TextView) view.findViewById(R.id.tv_key_9);
        tvkey10 = (TextView) view.findViewById(R.id.tv_key_10);
        tvprocess1 = (TextView) view.findViewById(R.id.tv_process1);
        tvprocess2 = (TextView) view.findViewById(R.id.tv_process2);
        tvprocess3 = (TextView) view.findViewById(R.id.tv_process3);
        tvprocess4 = (TextView) view.findViewById(R.id.tv_process4);
        tvprocess5 = (TextView) view.findViewById(R.id.tv_process5);
        tvprocess6 = (TextView) view.findViewById(R.id.tv_process6);
        tvprocess7 = (TextView) view.findViewById(R.id.tv_process7);
        tvprocess8 = (TextView) view.findViewById(R.id.tv_process8);
        tvprocess9 = (TextView) view.findViewById(R.id.tv_process9);
        tvprocess10 = (TextView) view.findViewById(R.id.tv_process10);
        tvprocess11 = (TextView) view.findViewById(R.id.tv_process11);
        tvprocess12 = (TextView) view.findViewById(R.id.tv_process12);
        tvprocess13 = (TextView) view.findViewById(R.id.tv_process13);
        tvprocess14 = (TextView) view.findViewById(R.id.tv_process14);
        tvprocess15 = (TextView) view.findViewById(R.id.tv_process15);
        tvprocess16 = (TextView) view.findViewById(R.id.tv_process16);
        tvprocess17 = (TextView) view.findViewById(R.id.tv_process17);
        tvprocess18 = (TextView) view.findViewById(R.id.tv_process18);
        tvprocess19 = (TextView) view.findViewById(R.id.tv_process19);
        tvprocess20 = (TextView) view.findViewById(R.id.tv_process20);
        detp1 = (TextView) view.findViewById(R.id.tv_detp1);
        detp2 = (TextView) view.findViewById(R.id.tv_detp2);
        detp3 = (TextView) view.findViewById(R.id.tv_detp3);
        detp4 = (TextView) view.findViewById(R.id.tv_detp4);
        detp5 = (TextView) view.findViewById(R.id.tv_detp5);
        detp6 = (TextView) view.findViewById(R.id.tv_detp6);
        detp7 = (TextView) view.findViewById(R.id.tv_detp7);
        detp8 = (TextView) view.findViewById(R.id.tv_detp8);
        detp9 = (TextView) view.findViewById(R.id.tv_detp9);
        detp10 = (TextView) view.findViewById(R.id.tv_detp10);
        type1 = (TextView) view.findViewById(R.id.tv_type1);
        type2 = (TextView) view.findViewById(R.id.tv_type2);
        type3 = (TextView) view.findViewById(R.id.tv_type3);
        type4 = (TextView) view.findViewById(R.id.tv_type4);
        type5 = (TextView) view.findViewById(R.id.tv_type5);
        type6 = (TextView) view.findViewById(R.id.tv_type6);
        type7 = (TextView) view.findViewById(R.id.tv_type7);
        type8 = (TextView) view.findViewById(R.id.tv_type8);
        type9 = (TextView) view.findViewById(R.id.tv_type9);
        type10 = (TextView) view.findViewById(R.id.tv_type10);
        type11 = (TextView) view.findViewById(R.id.tv_type11);
        type12 = (TextView) view.findViewById(R.id.tv_type12);
        type13 = (TextView) view.findViewById(R.id.tv_type13);
        type14 = (TextView) view.findViewById(R.id.tv_type14);
        type15 = (TextView) view.findViewById(R.id.tv_type15);
        type16 = (TextView) view.findViewById(R.id.tv_type16);
        type17 = (TextView) view.findViewById(R.id.tv_type17);
        type18 = (TextView) view.findViewById(R.id.tv_type18);
        type19 = (TextView) view.findViewById(R.id.tv_type19);
        type20 = (TextView) view.findViewById(R.id.tv_type20);
        serch = (RelativeLayout) view.findViewById(R.id.rl_process_serch);
        diameter = (TextView) view.findViewById(R.id.tv_tool_num);
        divth = (TextView) view.findViewById(R.id.tv_deep_num);
        num = (TextView) view.findViewById(R.id.tv_result_num);
        process = (RelativeLayout) view.findViewById(R.id.rl_title);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        showhomeVisible(View.VISIBLE);
        setTitle("齿形码加工");
        sb = new StringBuffer();
        keyShapeDatas = new KeyShapeDatas();
        dialog = new ProgressDialog(ToothProcessActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在加载数据......");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        //Loaddatatask loaddatatask = new Loaddatatask();
        //loaddatatask.execute();
        new Thread(){
            @Override
            public void run() {
                modelMachiningUnlockToolCode = new ModelMachiningUnlockToolCode();
                keylist = modelMachiningUnlockToolCode.getMachiningHistoryData();
                Message msg = handler.obtainMessage();
                msg.what = 1;
                handler.sendMessage(msg);

            }
        }.start();

        processViewAdd();
        processSetClick();


        keys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection = position;
                adapter.notifyDataSetChanged();
                itemselect(position);
            }
        });
        serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMachiningActivity.class);
                intent.putExtra("type", 2);
                startActivity(intent);
            }
        });
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selection != -1) {
                    Intent intent = new Intent(getApplicationContext(), JawActivity.class);
                    String carfactory = keylist.get(selection).getBrand();
                    String jaw = keylist.get(selection).getJaw();
                    intent.putExtra("carfactory", carfactory);
                    intent.putExtra("jaw", jaw);
                    intent.putExtra("serialid", serialid);
                    startActivity(intent);
                }else {
                    Toast.makeText(context,"请选择模具",Toast.LENGTH_SHORT).show();
                }
            }
        });
        serchkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KeyProcessSerchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void processSetClick() {
        keyunkown.setOnClickListener(this);
    }

    private class Loaddatatask extends AsyncTask<Objects, Integer, List<MachiningHistory>> {
        @Override
        protected List<MachiningHistory> doInBackground(Objects... params) {
            modelMachiningUnlockToolCode = new ModelMachiningUnlockToolCode();
            keylist = modelMachiningUnlockToolCode.getMachiningHistoryData();
            return keylist;
        }

        @Override
        protected void onPostExecute(List<MachiningHistory> machiningHistories) {
            super.onPostExecute(machiningHistories);

            num.setText(keylist.size() + "");
            Log.d("jiagong", keylist.size() + "");
            adddata();
            adapter = new KeyAdapter();
            keys.setAdapter(adapter);
        }
    }


    private void itemselect(int position){
        serialid = keylist.get(position).getSerialId();
        points1.clear();
        points2.clear();
        myview.process(points1, points2);

        for (int i = 0; i < processlist.size(); i++) {
            processlist.get(i).setVisibility(View.GONE);
            textViews.get(i).setText("?");
        }
        for (int i = 0; i < inputlist.size(); i++) {
            inputlist.get(i).setVisibility(View.GONE);
        }
        machiningData = new MachiningData();
        machiningData = modelMachiningUnlockToolCode.getMachiningData(keylist.get(position).getSerialId());
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
        toothCodesData = new ToothCodesDatas();
        toothCodesData = machiningData.getToothCodesData();
        toothCodesDataList = toothCodesData.getData();
        Log.d("size", toothCodesDataList.size() + "");
        for (int i = 0; i < toothCodesDataList.size(); i++) {
            datas = toothCodesDataList.get(i).getData();
        }
        for (int i = 0; i < cutLengthDatas.size(); i++) {
            processlist.get(i).setVisibility(View.VISIBLE);
            processlist.get(i).setOnClickListener(ToothProcessActivity.this);
            type.get(i).setText(cutLengthDatas.get(i).getLength() + "");
        }
        for (int i = 0; i < datas.size(); i++) {
            inputlist.get(i).setVisibility(View.VISIBLE);
            inputlist.get(i).setOnClickListener(ToothProcessActivity.this);
            inputtext.get(i).setText(String.valueOf(datas.get(i).getToothCode()));
            detp.get(i).setText(datas.get(i).getDepth() + "");
        }
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
        inputlist.add(key1);
        inputlist.add(key2);
        inputlist.add(key3);
        inputlist.add(key4);
        inputlist.add(key5);
        inputlist.add(key6);
        inputlist.add(key7);
        inputlist.add(key8);
        inputlist.add(key9);
        inputlist.add(key10);
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
        inputtext.add(tvkey1);
        inputtext.add(tvkey2);
        inputtext.add(tvkey3);
        inputtext.add(tvkey4);
        inputtext.add(tvkey5);
        inputtext.add(tvkey6);
        inputtext.add(tvkey7);
        inputtext.add(tvkey8);
        inputtext.add(tvkey9);
        inputtext.add(tvkey10);
        detp.add(detp1);
        detp.add(detp2);
        detp.add(detp3);
        detp.add(detp4);
        detp.add(detp5);
        detp.add(detp6);
        detp.add(detp7);
        detp.add(detp8);
        detp.add(detp9);
        detp.add(detp10);
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

    private class KeyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return keylist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(ToothProcessActivity.this, R.layout.keyprocess_item, null);
                viewHolder = new ViewHolder();
                viewHolder.no = (TextView) convertView.findViewById(R.id.tv_no);
                viewHolder.carfactory = (TextView) convertView.findViewById(R.id.tv_carfactory);
                viewHolder.toothcode = (TextView) convertView.findViewById(R.id.tv_toothcode);
                viewHolder.prcessdate = (TextView) convertView.findViewById(R.id.tv_processdate);
                viewHolder.beginsequence = (TextView) convertView.findViewById(R.id.tv_begindate);
                viewHolder.finishsequence = (TextView) convertView.findViewById(R.id.tv_finishdate);
                viewHolder.keysembryowidth = (TextView) convertView.findViewById(R.id.tv_keysembryowidth);
                viewHolder.teeth = (TextView) convertView.findViewById(R.id.tv_teeth);
                viewHolder.fixtrue = (TextView) convertView.findViewById(R.id.tv_fixtrue);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.no.setText(keylist.get(position).getNo() + "");
            viewHolder.carfactory.setText(keylist.get(position).getBrand());
            viewHolder.toothcode.setText(keylist.get(position).getUnlockToolCode());
            viewHolder.prcessdate.setText(keylist.get(position).getSearchDateTime());
            viewHolder.beginsequence.setText(keylist.get(position).getSerialStart());
            viewHolder.finishsequence.setText(keylist.get(position).getSerialIdEnd());
            viewHolder.keysembryowidth.setText(keylist.get(position).getKeyWidth() + "");
            viewHolder.teeth.setText(keylist.get(position).getCuts());
            viewHolder.fixtrue.setText(keylist.get(position).getJaw());
            if (selection == position) {
                convertView.setBackgroundColor(Color.parseColor("#6495ed"));
            } else {
                convertView.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            return convertView;
        }
    }

    private static class ViewHolder {
        TextView no;
        TextView carfactory;
        TextView toothcode;
        TextView prcessdate;
        TextView beginsequence;
        TextView finishsequence;
        TextView sequencenum;
        TextView keysembryowidth;
        TextView keysembryo;
        TextView teeth;
        TextView fixtrue;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_home:
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            case R.id.ll_process_1:
                Toast.makeText(this, "这是1", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 0;
                break;
            case R.id.ll_process_2:
                Toast.makeText(this, "这是2", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 1;
                break;
            case R.id.ll_process_3:
                Toast.makeText(this, "这是3", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 2;
                break;
            case R.id.ll_process_4:
                Toast.makeText(this, "这是4", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 3;
                break;
            case R.id.ll_process_5:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 4;
                break;
            case R.id.ll_process_6:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 5;
                break;
            case R.id.ll_process_7:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 6;
                break;
            case R.id.ll_process_8:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 7;
                break;
            case R.id.ll_process_9:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 8;
                break;
            case R.id.ll_process_10:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 9;
                break;
            case R.id.ll_process_11:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 10;
                break;
            case R.id.ll_process_12:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 11;
                break;
            case R.id.ll_process_13:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 12;
                break;
            case R.id.ll_process_14:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 13;
                break;
            case R.id.ll_process_15:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 14;
                break;
            case R.id.ll_process_16:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 15;
                break;
            case R.id.ll_process_17:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 16;
                break;
            case R.id.ll_process_18:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 17;
                break;
            case R.id.ll_process_19:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 18;
                break;
            case R.id.ll_process_20:
                Toast.makeText(this, "这是5", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < processlist.size(); i++) {
                    processlist.get(i).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                v.setBackgroundColor(Color.parseColor("#6495ed"));
                whichSelect = 19;
                break;
            case R.id.ll_key_1:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey1.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_2:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey2.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_3:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey3.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_4:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey4.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_5:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey5.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_6:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey6.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_7:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey7.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_8:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey8.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_9:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey9.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_key_10:
                if (whichSelect != -1 && whichSelect < cutLengthDatas.size()) {
                    String s = tvkey10.getText().toString();
                    textViews.get(whichSelect).setText(s);
                    sb.setLength(0);
                    for (int i = 0; i <= whichSelect; i++) {
                        sb.append(textViews.get(i).getText().toString());
                    }
                    String cutcode = sb.toString();
                    keyShapeDatas = modelMachiningUnlockToolCode.getKeyShapePointsData(serialid, cutcode);
                    shapeDatas = keyShapeDatas.getData();
                    points1.clear();
                    points2.clear();
                    points1 = shapeDatas.get(0).getShape();
                    points2 = shapeDatas.get(1).getShape();
                    myview.process(points1, points2);
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rl_unkown:
                if (whichSelect != -1) {
                    textViews.get(whichSelect).setText("?");
                    processlist.get(whichSelect).setBackgroundColor(Color.parseColor("#ffffff"));
                    processlist.get(whichSelect + 1).setBackgroundColor(Color.parseColor("#6495ed"));
                    whichSelect += 1;
                } else {
                    Toast.makeText(this, "请选择输入模块", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
