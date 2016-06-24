package com.stay4it.testflowlayout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Context mContext;
    private ImageView mImageView;
    private MyFlowLayout mFlowLayout;
    private ClickListenerImpl mClickListenerImpl;
    String[] tags = new String[]{"女朋友", "贤良淑德", "赞", "年轻美貌", "清纯", "温柔贤惠", "靓丽", "女神"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        mContext=this;
        mImageView= (ImageView) findViewById(R.id.imageView);
        mClickListenerImpl=new ClickListenerImpl();
        mImageView.setOnClickListener(mClickListenerImpl);
        mFlowLayout= (MyFlowLayout) findViewById(R.id.flowlayout);
    }

    private class ClickListenerImpl implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int textViewHeight = 80;
            ViewGroup.MarginLayoutParams marginLayoutParams =
                    new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, textViewHeight);
            marginLayoutParams.setMargins(30, 0, 30, 0);
            TextView textView = new TextView(mContext);
            textView.setLines(1);
            textView.setTextSize(20);
            textView.setPadding(25, 0, 25, 0);
            textView.setTextColor(Color.parseColor("#f58f98"));
            textView.setGravity(Gravity.CENTER);
            int index = (int)(Math.random() * tags.length);
            textView.setText(tags[index]);
            textView.setBackgroundResource(R.drawable.textview_backgroundresource);
            mFlowLayout.addView(textView, marginLayoutParams);
        }
    }


}
