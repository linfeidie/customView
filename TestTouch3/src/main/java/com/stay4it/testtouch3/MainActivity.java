package com.stay4it.testtouch3;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * 原创作者
 * 谷哥的小弟
 *
 * 博客地址
 * http://blog.csdn.net/lfdfhl
 */
public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPagerAdapter=new ViewPagerAdapter(this);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mViewPager.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }
}
