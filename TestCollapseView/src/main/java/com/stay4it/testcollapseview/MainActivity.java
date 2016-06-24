package com.stay4it.testcollapseview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CollapseView mCollapseView1;
    private CollapseView mCollapseView2;
    private CollapseView mCollapseView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mCollapseView1 = (CollapseView) findViewById(R.id.collapseView1);
        mCollapseView1.setNumber("1");
        mCollapseView1.setTitle("女友");
        mCollapseView1.setContent(R.layout.expand_1);

        mCollapseView2 =(CollapseView) findViewById(R.id.collapseView2);
        mCollapseView2.setNumber("2");
        mCollapseView2.setTitle("妹子");
        mCollapseView2.setContent(R.layout.expand_2);


        mCollapseView3 =(CollapseView) findViewById(R.id.collapseView3);
        mCollapseView3.setNumber("3");
        mCollapseView3.setTitle("美女");
        mCollapseView3.setContent(R.layout.expand_3);
    }
}
