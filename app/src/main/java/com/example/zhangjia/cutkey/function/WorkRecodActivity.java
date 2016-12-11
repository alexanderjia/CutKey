package com.example.zhangjia.cutkey.function;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.fragment.Process_recodFragment;
import com.example.zhangjia.cutkey.fragment.Serch_recodFragment;

import java.util.ArrayList;
import java.util.List;

public class WorkRecodActivity extends FragmentActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RelativeLayout rl_back;
    private TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_recod);
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.viewpage);
        title = (TextView)findViewById(R.id.tv_title);
        title.setText("工作记录");
        rl_back = (RelativeLayout)findViewById(R.id.rl_back);
        rl_back.setVisibility(View.VISIBLE);
        rl_back.setOnClickListener(this);
        if (viewPager != null){
            setupViewPager(viewPager);
        }
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }


    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Serch_recodFragment(), "搜索记录");
        adapter.addFragment(new Process_recodFragment(), "加工记录");
        viewPager.setAdapter(adapter);
    }
    /**
     * 页面切换时fragment适配器
     */
    class MyPagerAdapter extends FragmentPagerAdapter {
        //List放置Fragment
        private final List<Fragment> mFragments = new ArrayList<>();
        //List放置标题
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //添加碎片的方法
        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
