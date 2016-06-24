package com.stay4it.testtouch2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
/**
 * 原创作者
 * 谷哥的小弟
 *
 * 博客地址
 * http://blog.csdn.net/lfdfhl
 */
public class MainActivity extends AppCompatActivity {
   private ButtonSubclass mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mButton= (ButtonSubclass) findViewById(R.id.button);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> MainActivity中调用dispatchTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> MainActivity中调用dispatchTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> MainActivity中调用dispatchTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> MainActivity中调用onTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> MainActivity中调用onTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> MainActivity中调用onTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }
}
