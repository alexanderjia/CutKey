package com.example.zhangjia.cutkey.function;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.UnlockToolCodeSerial;
import com.example.zhangjia.cutkey.background.model.ModelUnlockToolCodeSearchSerial;
import com.example.zhangjia.cutkey.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class KeySerchResultActivity extends BaseActivity {
    private ModelUnlockToolCodeSearchSerial modelUnlockToolCodeSearchSerial;
    private List<UnlockToolCodeSerial> unlockToolCodeSerialList = new ArrayList<>();
    private GridView unserial;
    private UntoolAdapter adapter;
    private int select = -1;
    private Button btnsure;
    private String factoryname;
    private String serial;

    @Override
    protected View initView() {
        View view = View.inflate(this, R.layout.activity_key_serch_result, null);
        unserial = (GridView)view.findViewById(R.id.gv_unserial);
        btnsure = (Button)view.findViewById(R.id.btn_sure);
        return view;
    }

    @Override
    protected void initDate() {
        final int index = getIntent().getIntExtra("toolindex",0);
        final String title = getIntent().getStringExtra("toolname");
        showhomeVisible(View.VISIBLE);
        showbackVisible(View.VISIBLE);
        setTitle(title);
        modelUnlockToolCodeSearchSerial = new ModelUnlockToolCodeSearchSerial();
        unlockToolCodeSerialList = modelUnlockToolCodeSearchSerial.getUnlockToolCodeSerial(index);
        adapter = new UntoolAdapter();
        unserial.setAdapter(adapter);
        unserial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select = position;
                adapter.notifyDataSetChanged();
                serial = unlockToolCodeSerialList.get(position).getSerial();
                factoryname = unlockToolCodeSerialList.get(position).getManufacturesName();
            }
        });
        btnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KeySerch_XunlieActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("serialid",index);
                intent.putExtra("factory",factoryname);
                intent.putExtra("serial",serial);
                startActivity(intent);
            }
        });
    }
    private class UntoolAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return unlockToolCodeSerialList.size();
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
                convertView = View.inflate(getApplicationContext(),R.layout.toolcodeserarserial_item,null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_serial_no);
                viewHolder.carfactoryname = (TextView)convertView.findViewById(R.id.tv_carfactoryname);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.textView.setText(unlockToolCodeSerialList.get(position).getSerial());
            viewHolder.carfactoryname.setText(unlockToolCodeSerialList.get(position).getManufacturesName());
            if (select == position){
                convertView.setBackgroundColor(Color.parseColor("#6495ed"));
                viewHolder.textView.setTextColor(Color.parseColor("#ffffff"));
                viewHolder.carfactoryname.setTextColor(Color.parseColor("#ffffff"));
            }else {
                convertView.setBackgroundColor(Color.parseColor("#ffffff"));
                viewHolder.textView.setTextColor(Color.parseColor("#333333"));
                viewHolder.carfactoryname.setTextColor(Color.parseColor("#b9b8b8"));
            }
            return convertView;
        }
    }
    private static class ViewHolder{
        TextView textView;
        TextView carfactoryname;
    }
}
