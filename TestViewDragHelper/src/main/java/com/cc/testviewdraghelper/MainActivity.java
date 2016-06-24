package com.cc.testviewdraghelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final Button button= (Button) findViewById(R.id.button);
        button.post(new Runnable() {
            @Override
            public void run() {
                System.out.println(""+button.getWidth()+"  "+button.getHeight());
            }
        });
}}
