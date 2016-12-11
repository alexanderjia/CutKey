package com.example.zhangjia.cutkey.function;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.KeyShapeData;
import com.example.zhangjia.cutkey.background.bean.KeyShapeDatas;
import com.example.zhangjia.cutkey.background.bean.MachiningData;
import com.example.zhangjia.cutkey.background.bean.MachiningHistory;
import com.example.zhangjia.cutkey.background.model.ModelMachiningSerial;
import com.example.zhangjia.cutkey.background.model.ModelMachiningUnlockToolCode;
import com.example.zhangjia.cutkey.base.BaseActivity;
import com.example.zhangjia.cutkey.view.ProcessView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CodePrcessActivity extends BaseActivity {
    private List<MachiningHistory> keylist = new ArrayList<>();
    private ListView keys;
    private KeyAdapter adapter;
    private ModelMachiningUnlockToolCode modelMachiningUnlockToolCode;
    private ModelMachiningSerial machiningSerial;
    private KeyShapeDatas keyShapeDatas;
    private int serialid;
    private List<KeyShapeData> shapeDatas = new ArrayList<>();
    private List<Point> points = new ArrayList<>();
    private List<Point> points2 = new ArrayList<>();
    private ProcessView myview;
    private String serial;
    private EditText input;
    private RelativeLayout serch;
    private TextView num;
    private int selection = -1;
    private TextView diameter;
    private TextView divth;
    private MachiningData machiningData;
    private ProgressDialog dialog;
    private RelativeLayout process;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    dialog.dismiss();
                    num.setText(keylist.size() + "");
                    adapter = new KeyAdapter();
                    keys.setAdapter(adapter);
                    break;
            }
        }
    };


    @Override
    protected View initView() {
        View view = View.inflate(this, R.layout.activity_code_process, null);
        keys = (ListView) view.findViewById(R.id.lv_key);
        myview = (ProcessView) view.findViewById(R.id.myview);
        input = (EditText) view.findViewById(R.id.et_inputed);
        serch = (RelativeLayout) view.findViewById(R.id.rl_serch);
        num = (TextView) view.findViewById(R.id.tv_result_num);
        diameter = (TextView) view.findViewById(R.id.tv_tool_num);
        divth = (TextView) view.findViewById(R.id.tv_deep_num);
        process = (RelativeLayout)view.findViewById(R.id.rl_title);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        showhomeVisible(View.VISIBLE);
        setTitle("编码加工");
        serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddMachiningActivity.class);
                intent.putExtra("type", 1);
                startActivity(intent);
            }
        });
        dialog = new ProgressDialog(CodePrcessActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在加载数据......");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        //LoaddataTask loaddataTask = new LoaddataTask();
        //loaddataTask.execute();
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
        keyShapeDatas = new KeyShapeDatas();
        machiningData = new MachiningData();
        keys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selection = position;
                adapter.notifyDataSetChanged();
                points.clear();
                myview.process(points, points2);
                serial = keylist.get(position).getSerial();
                input.setText(serial);
                serialid = keylist.get(position).getSerialId();
                machiningSerial = new ModelMachiningSerial();
                keyShapeDatas = machiningSerial.getKeyShapePointsData(serialid, serial);
                machiningData = machiningSerial.getMachiningData(serialid);
                String dia = machiningData.getCutterDiameter() + "";
                String deep = machiningData.getCuttingDepth() + "";
                diameter.setText(dia);
                divth.setText(deep);
                shapeDatas = keyShapeDatas.getData();
                points = shapeDatas.get(0).getShape();
                points2 = shapeDatas.get(1).getShape();
                myview.process(points, points2);
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
    }

    private class LoaddataTask extends AsyncTask<Objects, Integer, List<MachiningHistory>> {
        @Override
        protected List<MachiningHistory> doInBackground(Objects... params) {
            modelMachiningUnlockToolCode = new ModelMachiningUnlockToolCode();
            keylist = modelMachiningUnlockToolCode.getMachiningHistoryData();
            return keylist;
        }

        @Override
        protected void onPostExecute(List<MachiningHistory> machiningHistories) {
            super.onPostExecute(machiningHistories);
            dialog.dismiss();
            num.setText(keylist.size() + "");
            adapter = new KeyAdapter();
            keys.setAdapter(adapter);
        }
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
                convertView = View.inflate(CodePrcessActivity.this, R.layout.keyprocess_item, null);
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
            ;
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
        TextView keysembryowidth;
        TextView teeth;
        TextView fixtrue;
    }
}
