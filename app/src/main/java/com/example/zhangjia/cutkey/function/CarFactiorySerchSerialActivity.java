package com.example.zhangjia.cutkey.function;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.KeySerial;
import com.example.zhangjia.cutkey.background.model.ModelAutoSearchSerial;
import com.example.zhangjia.cutkey.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CarFactiorySerchSerialActivity extends BaseActivity {
    private ModelAutoSearchSerial modelAutoSearchSerial;
    private GridView serial;
    private List<KeySerial> keySerialList = new ArrayList<>();
    private SerialAdapter adapter;
    private int selecte = -1;
    private String selelctserial;
    private int selectserialid;
    private Button btntrue;
    @Override
    protected View initView() {
        View view = View.inflate(this,R.layout.activity_car_factiory_serch_serial,null);
        serial = (GridView)view.findViewById(R.id.gv_serial);
        btntrue = (Button)view.findViewById(R.id.btn_true);
        return view;
    }

    @Override
    protected void initDate() {
        showbackVisible(View.VISIBLE);
        showhomeVisible(View.VISIBLE);
        final String title = getIntent().getStringExtra("carfactoryname");
        setTitle(title);
        final int factoryindex = getIntent().getIntExtra("index",0);
        modelAutoSearchSerial = new ModelAutoSearchSerial();
        keySerialList = modelAutoSearchSerial.getSeriesbyManufacturer(factoryindex);
        Log.d("aaa",keySerialList.size() + "");
        adapter = new SerialAdapter();
        serial.setAdapter(adapter);
        serial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selecte = position;
                adapter.notifyDataSetChanged();
            }
        });
        serial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selelctserial = keySerialList.get(position).getSerial();
                selectserialid = keySerialList.get(position).getSerialIndex();
            }
        });
        btntrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selecte != -1){
                Intent intent = new Intent(getApplicationContext(),CarSerchXuliehaoActivity.class);
                intent.putExtra("factoryindex",factoryindex);
                intent.putExtra("serial",selelctserial);
                intent.putExtra("serialid",selectserialid);
                intent.putExtra("carfactotyname",title);
                startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"请选择子项",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private class SerialAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return keySerialList.size();
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
            if (convertView == null){
                convertView = View.inflate(getApplicationContext(),R.layout.carfactoryserchserial_item,null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_keyno);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.textView.setText(keySerialList.get(position).getSerial());
            if ( selecte == position){
                convertView.setBackgroundColor(Color.parseColor("#6495ed"));
                viewHolder.textView.setTextColor(Color.parseColor("#ffffff"));
            }else {
                convertView.setBackgroundColor(Color.parseColor("#ffffff"));
                viewHolder.textView.setTextColor(Color.parseColor("#333333"));
            }
            return convertView;
        }
    }
    private static class ViewHolder{
        TextView textView;
    }
}
