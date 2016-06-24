package com.cc.testviewdraghelper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureDetectorActivity extends AppCompatActivity {
    private GestureListenerImpl mGestureListenerImpl;
    private GestureDetector mGestureDetector;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);
        mContext = this;
        init();
    }

    private void init() {
        mGestureDetector = new GestureDetector(mContext, new GestureListenerImpl());
    }

    //实现监听
    private class GestureListenerImpl implements GestureDetector.OnGestureListener {
        //触摸屏幕时均会调用该方法
        @Override
        public boolean onDown(MotionEvent e) {
            System.out.println("---> 手势中的onDown方法");
            return false;
        }

        //手指在屏幕上拖动时会调用该方法
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            System.out.println("---> 手势中的onFling方法");
            return false;
        }

        //手指长按屏幕时均会调用该方法
        @Override
        public void onLongPress(MotionEvent e) {
            System.out.println("---> 手势中的onLongPress方法");
        }

        //手指在屏幕上滚动时会调用该方法
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            System.out.println("---> 手势中的onScroll方法");
            return false;
        }

        //手指在屏幕上按下,且未移动和松开时调用该方法
        @Override
        public void onShowPress(MotionEvent e) {
            System.out.println("---> 手势中的onShowPress方法");
        }

        //轻击屏幕时调用该方法
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            System.out.println("---> 手势中的onSingleTapUp方法");
            return false;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
}
