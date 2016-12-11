package com.example.zhangjia.cutkey.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.Toast;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.background.bean.Manufacturers;
import com.example.zhangjia.cutkey.background.model.ModelAutoSearch;
import com.example.zhangjia.cutkey.background.view.IViewAutoSearch;
import com.example.zhangjia.cutkey.bean.Factory;
import com.example.zhangjia.cutkey.function.CarFactiorySerchSerialActivity;
import com.example.zhangjia.cutkey.function.SerchActivity;
import com.example.zhangjia.cutkey.utile.PinyinComparator;
import com.example.zhangjia.cutkey.utile.PinyinUtils;
import com.example.zhangjia.cutkey.view.EditTextWithDel;
import com.example.zhangjia.cutkey.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class CarFactorySerchFragment extends Fragment {

    private ListView sortListview;
    private SideBar sideBar;
    private TextView dialog;
    private EditTextWithDel mEtSeachName;
    private SortAdapter adapter;
    private List<String> factories = new ArrayList<>();
    private int selection = -1;
    private Button serch;
    private ImageView dropserch;//下来列表；
    private ModelAutoSearch modelAutoSearch;
    private ListView chooselist;
    private ChooseAdapter chooseAdapter;
    private List<Manufacturers> manufacturersList = new ArrayList<>();
    private TextView num;
    private ProgressDialog notice;
    private Context context;
    private PopupWindow pw;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    notice.dismiss();
                    num.setText(manufacturersList.size() + "");
                    for (int i = 0; i < manufacturersList.size();i++){
                        factories.add(manufacturersList.get(i).getManufacture());
                    }
                    Log.d("zishu",factories.size()+ "");
                    initEvents();
                    setAdapter();
                    break;
                case 2:
                    int size = (Integer)msg.obj;
                    num.setText(size + "");
                    break;
            }
        }
    };


    public CarFactorySerchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_factory_serch, null);
        context = view.getContext();
        dropserch = (ImageView)view.findViewById(R.id.img_pw);
        mEtSeachName = (EditTextWithDel) view.findViewById(R.id.et_search);
        serch = (Button) view.findViewById(R.id.btn_serch);
        sideBar = (SideBar) view.findViewById(R.id.sidrbar);
        dialog = (TextView) view.findViewById(R.id.dialog);
        sortListview = (ListView) view.findViewById(R.id.lv_contact);
        num = (TextView) view.findViewById(R.id.tv_result_num);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        notice = new ProgressDialog(context);
        notice.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        notice.setMessage("正在加载数据......");
        notice.show();
        sideBar.setTextView(dialog);
        //   modelAutoSearch = new ModelAutoSearch();
        // manufacturersList = modelAutoSearch.getManufacturers();
        new Thread(){
            @Override
            public void run() {
                modelAutoSearch = new ModelAutoSearch();
                manufacturersList = modelAutoSearch.getManufacturers();
                Message msg = handler.obtainMessage();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        }.start();
       // Adddata adddata = new Adddata();
      //  adddata.execute();
        serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String carfactoryname = manufacturersList.get(selection).getManufacture();
                int factoryindex = manufacturersList.get(selection).getManufactureIndex();
                Intent intent = new Intent(getContext(), CarFactiorySerchSerialActivity.class);
                intent.putExtra("carfactoryname", carfactoryname);
                intent.putExtra("index", factoryindex);
                startActivity(intent);
            }
        });
        chooselist = new ListView(getActivity().getApplication());
        chooselist.setBackgroundColor(Color.parseColor("#ffffff"));
        chooselist.setDivider(null);

        chooseAdapter = new ChooseAdapter();
        chooselist.setAdapter(chooseAdapter);
        dropserch.setOnClickListener(new View.OnClickListener() {
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
                mEtSeachName.setText(factories.get(position));
                pw.dismiss();
            }
        });
    }
    /**

    private class Adddata extends AsyncTask<Objects, Integer, List<Manufacturers>> {

        @Override
        protected List<Manufacturers> doInBackground(Objects... params) {
            modelAutoSearch = new ModelAutoSearch();
            manufacturersList = modelAutoSearch.getManufacturers();
            return manufacturersList;
        }

        @Override
        protected void onPostExecute(List<Manufacturers> manufacturerses) {
            super.onPostExecute(manufacturerses);
            notice.dismiss();
            num.setText(manufacturersList.size() + "");
            initEvents();
            setAdapter();
        }
    }
**/
    private void setAdapter() {
        ArrayList<String> indexString = new ArrayList<>();
        for (int i = 0; i < manufacturersList.size(); i++) {
            String pinyin = PinyinUtils.getPingYin(manufacturersList.get(i).getManufacture());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                manufacturersList.get(i).setFistletter(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        Collections.sort(manufacturersList, new PinyinComparator());
        adapter = new SortAdapter(getContext(), manufacturersList);
        sortListview.setAdapter(adapter);

    }

    private void initEvents() {
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListview.setSelection(position);
                }
            }
        });
        //ListView点击事件
        sortListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), ((Manufacturers) adapter.getItem(position)).getManufacture(), Toast.LENGTH_SHORT).show();
                selection = position;
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
        List<Manufacturers> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(s)) {
            mSortList = manufacturersList;
        } else {
            mSortList.clear();
            for (Manufacturers manufacturers : manufacturersList) {
                String name = manufacturers.getManufacture();
                if (name.toUpperCase().indexOf(s.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(s.toString().toUpperCase())) {
                    mSortList.add(manufacturers);
                }
            }
        }
        int size = mSortList.size();
        Message msg = handler.obtainMessage();
        msg.what = 2;
        msg.obj = size;
        handler.sendMessage(msg);
        //根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparator());
        adapter.updateListView(mSortList);
    }




    private class SortAdapter extends BaseAdapter implements SectionIndexer {
        private List<Manufacturers> list = null;
        private Context mContext;

        public SortAdapter(Context mContext, List<Manufacturers> list) {
            this.mContext = mContext;
            this.list = list;
        }

        /**
         * 当ListView数据发生变化时,调用此方法来更新ListView
         *
         * @param list
         */
        public void updateListView(List<Manufacturers> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.list.size();
        }

        public Object getItem(int position) {
            return list.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup arg2) {
            ViewHolder viewHolder = null;
            final Manufacturers mContent = list.get(position);
            if (view == null) {
                viewHolder = new ViewHolder();
                view = LayoutInflater.from(mContext).inflate(R.layout.factroy_serch_item, null);
                viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_factory_name);
                viewHolder.tv_xulie = (TextView) view.findViewById(R.id.tv_xulie_num);
                viewHolder.tv_index = (TextView) view.findViewById(R.id.tv_index_num);
                viewHolder.img_trademark = (ImageView) view.findViewById(R.id.img_mark);
                view.setTag(viewHolder);
                viewHolder.tvLetter = (TextView) view.findViewById(R.id.tv_catagory);
                viewHolder.fengge = (ImageView) view.findViewById(R.id.fenge);
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
            if (selection == position) {
                view.setBackgroundColor(Color.parseColor("#6495ed"));
            } else {
                view.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            viewHolder.tvTitle.setText(this.list.get(position).getManufacture());
            viewHolder.tv_index.setText(this.list.get(position).getNo() + "");
            viewHolder.tv_xulie.setText(this.list.get(position).getSerial());
            return view;

        }


        final class ViewHolder {
            ImageView fengge;
            TextView tvLetter;
            TextView tvTitle;
            TextView tv_xulie;
            TextView tv_index;
            ImageView img_trademark;

        }

        public int getSectionForPosition(int position) {
            return list.get(position).getFistletter().charAt(0);
        }

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
        public Object[] getSections() {
            return null;
        }
    }
    private class ChooseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return factories.size();
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
            viewHolder.choose.setText(factories.get(position));
            return convertView;
        }

        private class ViewHolder {
            TextView choose;
        }
    }
}
