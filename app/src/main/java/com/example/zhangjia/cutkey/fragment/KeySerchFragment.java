package com.example.zhangjia.cutkey.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.UnlockToolCodes;
import com.example.zhangjia.cutkey.background.model.ModelUnlockToolCodeSearch;
import com.example.zhangjia.cutkey.bean.UnlockTool;
import com.example.zhangjia.cutkey.function.KeySerchResultActivity;
import com.example.zhangjia.cutkey.utile.PinyinComparatorkey;
import com.example.zhangjia.cutkey.utile.PinyinUtils;
import com.example.zhangjia.cutkey.view.EditTextWithDel;
import com.example.zhangjia.cutkey.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeySerchFragment extends Fragment  {
    private ListView sortview;
    private SideBar sideBar;
    private TextView dialog;
    private EditTextWithDel mEtSeachName;
    private KeySortAdapter adapter;
    private boolean isRunning = false;
    private List<String> unlockToolList = new ArrayList<>();
    private int click = 1;
    private int selcton = -1;
    private int tiao = 0;
    private Button serch;
    private ImageView drop;
    private PopupWindow pw;
    private ListView chooselist;
    private ChooseAdapter chooseAdapter;
    private ModelUnlockToolCodeSearch modelUnlockToolCodeSearch;
    private List<UnlockToolCodes> unlockToolCodesList = new ArrayList<>();
    private TextView num;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    num.setText(unlockToolCodesList.size() + "");
                    for (int i = 0; i < unlockToolCodesList.size();i++){
                        unlockToolList.add(unlockToolCodesList.get(i).getUnlockToolCodeName());
                    }
                    initEvents();
                    setAdapter();
                    break;
                case 2:
                    int size = (Integer)msg.obj;
                    num.setText(size +"");
                    break;
            }
        }
    };



    public KeySerchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_key_serch, null);
        mEtSeachName = (EditTextWithDel) view.findViewById(R.id.et_search);
        sideBar = (SideBar) view.findViewById(R.id.sidrbar);
        drop = (ImageView)view.findViewById(R.id.img_pw);
        dialog = (TextView) view.findViewById(R.id.dialog);
        sortview = (ListView) view.findViewById(R.id.lv_contact);
        serch = (Button)view.findViewById(R.id.btn_serch);
        num = (TextView)view.findViewById(R.id.tv_result_num);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sideBar.setTextView(dialog);
//        Adddata adddata = new Adddata();
//        adddata.execute();
        new Thread(){
            @Override
            public void run() {
                modelUnlockToolCodeSearch = new ModelUnlockToolCodeSearch();
                unlockToolCodesList = modelUnlockToolCodeSearch.getUnlockToolCodes();
                Message msg = handler.obtainMessage();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }.start();

        serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), KeySerchResultActivity.class);
                int toolindex = unlockToolCodesList.get(selcton).getUnlockToolCodeIndex();
                String toolname = unlockToolCodesList.get(selcton).getUnlockToolCodeName();
                intent.putExtra("toolindex",toolindex);
                intent.putExtra("toolname",toolname);
                startActivity(intent);
            }
        });
        chooselist = new ListView(getActivity().getApplication());
        chooselist.setBackgroundColor(Color.parseColor("#ffffff"));
        chooselist.setDivider(null);

        chooseAdapter = new ChooseAdapter();
        chooselist.setAdapter(chooseAdapter);
        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pw == null){
                    pw = new PopupWindow(getActivity().getApplicationContext());
                    pw.setWidth(mEtSeachName.getWidth());
                    pw.setHeight(200);
                    pw.setFocusable(true);
                    pw.setContentView(chooselist);
                }
                if (pw.isShowing()){
                    pw.dismiss();
                }else {
                    pw.showAsDropDown(mEtSeachName,0,0);
                }
            }
        });
        chooselist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mEtSeachName.setText(unlockToolList.get(position));
                pw.dismiss();
            }
        });
    }

    private class Adddata extends AsyncTask<Objects,Integer,List<UnlockToolCodes>>{

        @Override
        protected List<UnlockToolCodes> doInBackground(Objects... params) {
            modelUnlockToolCodeSearch = new ModelUnlockToolCodeSearch();
            unlockToolCodesList = modelUnlockToolCodeSearch.getUnlockToolCodes();
            return unlockToolCodesList;
        }

        @Override
        protected void onPostExecute(List<UnlockToolCodes> unlockToolCodes) {
            super.onPostExecute(unlockToolCodes);
            num.setText(unlockToolCodesList.size() + "");
            initEvents();
            setAdapter();
        }
    }

    private void setAdapter() {

        ArrayList<String> indexString = new ArrayList<>();
        for (int i = 0; i < unlockToolCodesList.size(); i++) {
            String pinyin = PinyinUtils.getPingYin(unlockToolCodesList.get(i).getUnlockToolCodeName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                unlockToolCodesList.get(i).setFistletter(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        Collections.sort(unlockToolCodesList, new PinyinComparatorkey());
        adapter = new KeySortAdapter(getContext(), unlockToolCodesList);
        sortview.setAdapter(adapter);
    }



    private void initEvents() {
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortview.setSelection(position);
                }
            }
        });
        //ListView点击事件
        sortview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                // Toast.makeText(getContext(), ((UnlockTool) adapter.getItem(position)).getUnlockToolCodeName(), Toast.LENGTH_SHORT).show();
                selcton = position;
                adapter.notifyDataSetChanged();
            }
        });
        //根据输入框输入值的改变来过滤搜索
        mEtSeachName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新原来的列表，否则为过滤数据
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void filterData(String s) {
        List<UnlockToolCodes> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(s)) {
            mSortList = unlockToolCodesList;
        } else {
            mSortList.clear();
            for (UnlockToolCodes unlockTool : unlockToolCodesList) {
                String name = unlockTool.getUnlockToolCodeName();
                if (name.toUpperCase().indexOf(s.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(s.toString().toUpperCase())) {
                    mSortList.add(unlockTool);
                }
            }
        }
        int size = mSortList.size();
        Message msg = handler.obtainMessage();
        msg.what = 2;
        msg.obj = size;
        handler.sendMessage(msg);
        //根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparatorkey());
        adapter.updateListView(mSortList);
    }


    private class KeySortAdapter extends BaseAdapter implements SectionIndexer {
        private List<UnlockToolCodes> list = null;
        private Context mContext;

        public KeySortAdapter(Context mContext, List<UnlockToolCodes> list) {
            this.list = list;
            this.mContext = mContext;
        }

        /**
         * 当GridView数据发生变化时,调用此方法来更新GridView
         *
         * @param list
         */
        public void updateListView(List<UnlockToolCodes> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return this.list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder viewHolder;
            final UnlockToolCodes mContent = list.get(position);
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.keyserch_item, null);
                viewHolder = new ViewHolder();
                viewHolder.img_tu = (ImageView) view.findViewById(R.id.img_tu);
                viewHolder.tv_AU = (TextView) view.findViewById(R.id.tv_au);
                viewHolder.tv_num = (TextView) view.findViewById(R.id.tv_num);
                viewHolder.tv_factory_name = (TextView) view.findViewById(R.id.tv_factory_name);
                viewHolder.tv_xulienum = (TextView) view.findViewById(R.id.tv_xulie);
                viewHolder.tv_chishu = (TextView) view.findViewById(R.id.tv_chinum);
                view.setTag(viewHolder);
                viewHolder.tvLetter = (TextView) view.findViewById(R.id.tv_catagory);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int section = getSectionForPosition(position);

            if (position == getPositionForSection(section)) {
                viewHolder.tvLetter.setVisibility(View.VISIBLE);
                viewHolder.tvLetter.setText(mContent.getFistletter());
            } else {
                viewHolder.tvLetter.setVisibility(View.GONE);

            }
            viewHolder.tv_AU.setText(list.get(position).getUnlockToolCodeName());
            viewHolder.tv_num.setText(list.get(position).getNo() + "");
            viewHolder.tv_factory_name.setText(list.get(position).getManufacturesName());
            viewHolder.tv_xulienum.setText(list.get(position).getSerial());
            viewHolder.tv_chishu.setText(list.get(position).getCuts());
            if (selcton == position) {
                view.setBackgroundColor(Color.parseColor("#6495ed"));
            } else {
                view.setBackgroundColor(Color.parseColor("#ffffff"));
            }


            return view;
        }

        class ViewHolder {
            ImageView img_tu;
            TextView tv_AU;
            TextView tv_num;
            TextView tv_factory_name;
            TextView tv_xulienum;
            TextView tv_chishu;
            TextView tvLetter;
        }

        @Override
        public Object[] getSections() {
            return null;
        }

        @Override
        public int getPositionForSection(int section) {
            for (int i = 0; i < getCount(); i++) {
                String sortStr = list.get(i).getFistletter();
                char firstChar = sortStr.toUpperCase().charAt(0);
                if (firstChar == section) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int getSectionForPosition(int position) {
            return list.get(position).getFistletter().charAt(0);
        }
    }

    private class ChooseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return unlockToolList.size();
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
                convertView = View.inflate(getActivity().getApplication(), R.layout.serchpop_item, null);
                viewHolder = new ViewHolder();
                viewHolder.choose = (TextView) convertView.findViewById(R.id.tv_choose);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.choose.setText(unlockToolList.get(position));
            return convertView;
        }

        private class ViewHolder {
            TextView choose;
        }
    }
}
