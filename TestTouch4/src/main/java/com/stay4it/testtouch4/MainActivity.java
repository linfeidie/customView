package com.stay4it.testtouch4;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
    }

}
