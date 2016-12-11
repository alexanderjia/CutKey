package com.example.zhangjia.cutkey.function;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhangjia.cutkey.R;
import com.example.zhangjia.cutkey.fragment.CarFactorySerchFragment;
import com.example.zhangjia.cutkey.fragment.FuzzySerchiFragment;
import com.example.zhangjia.cutkey.fragment.KeySerchFragment;

import java.util.ArrayList;
import java.util.List;

public class SerchActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewPager;//滑动切换页面
    private RelativeLayout rl_back;//后退键
    private TextView title;//标题

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);
        rl_back = (RelativeLayout) findViewById(R.id.rl_back);
        rl_back.setVisibility(View.VISIBLE);
        rl_back.setOnClickListener(this);
        title = (TextView)findViewById(R.id.tv_title);
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);
        title.setText("搜索");
    }

    private void setupViewPager(ViewPager viewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CarFactorySerchFragment(), "车厂搜索");
        adapter.addFragment(new KeySerchFragment(), "开锁工具搜索");
        adapter.addFragment(new FuzzySerchiFragment(), "模糊搜索");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }

    /**
     * 页面切换时fragment适配器
     */
    class MyPagerAdapter extends FragmentPagerAdapter {
        //List放置Fragment
        private final List<android.support.v4.app.Fragment> mFragments = new ArrayList<>();
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
