package com.example.fmx.webchat_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivitybefore extends AppCompatActivity implements View.OnClickListener {
    private TextView title, item_weixin, item_tongxunlu, item_faxian, item_me;
    private ViewPager vp;
    private OneActivity oneActivity;
    private TwoActivity twoActivity;
    private ThreeActivity threeActivity;
    private FourthActivity fourthActivity;

    String[] titles = new String[]{"微信", "通讯录", "发现", "我"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除工具栏
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViews();

        item_weixin.setTextColor(Color.parseColor("#66CDAA"));

        //ViewPager的监听事件
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*此方法在页面被选中时调用*/
                title.setText(titles[position]);
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0 ==1的时辰默示正在滑动，
                arg0==2的时辰默示滑动完毕了，
                arg0==0的时辰默示什么都没做。*/
            }
        });
    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        title = findViewById(R.id.title);
        item_weixin = findViewById(R.id.item_weixin);
        item_tongxunlu = findViewById(R.id.item_tongxunlu);
        item_faxian = findViewById(R.id.item_faxian);
        item_me = findViewById(R.id.item_me);

        item_weixin.setOnClickListener(this);
        item_tongxunlu.setOnClickListener(this);
        item_faxian.setOnClickListener(this);
        item_me.setOnClickListener(this);

       // vp = (ViewPager) findViewById(R.id.mainViewPager);
        oneActivity = new OneActivity();
        twoActivity = new TwoActivity();
        threeActivity = new ThreeActivity();
        fourthActivity = new FourthActivity();

        //给FragmentList添加数据
//        mFragmentList.add(oneFragment);
//        mFragmentList.add(twoFragment);
//        mFragmentList.add(threeFragment);
//        mFragmentList.add(fourthActivity);
    }

    /**
     * 点击底部Text 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_weixin:
                vp.setCurrentItem(0, true);
                break;
            case R.id.item_tongxunlu:
                vp.setCurrentItem(1, true);
                break;
            case R.id.item_faxian:
                vp.setCurrentItem(2, true);
                break;
            case R.id.item_me:
                vp.setCurrentItem(3, true);
                break;
        }
    }


//    public class FragmentAdapter extends FragmentPagerAdapter {
//
//        List<Fragment> fragmentList = new ArrayList<Fragment>();
//
//        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
//            super(fm);
//            this.fragmentList = fragmentList;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragmentList.size();
//        }
//
//    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            item_weixin.setTextColor(Color.parseColor("#66CDAA"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            item_tongxunlu.setTextColor(Color.parseColor("#66CDAA"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
        } else if (position == 2) {
            item_faxian.setTextColor(Color.parseColor("#66CDAA"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
        } else if (position == 3) {
            item_me.setTextColor(Color.parseColor("#66CDAA"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
        }
    }
}
