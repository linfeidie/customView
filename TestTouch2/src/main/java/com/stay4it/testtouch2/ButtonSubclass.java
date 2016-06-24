package com.stay4it.testtouch2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
/**
 * 原创作者
 * 谷哥的小弟
 *
 * 博客地址
 * http://blog.csdn.net/lfdfhl
 */
public class ButtonSubclass extends Button{
    public ButtonSubclass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> ButtonSubclass中调用dispatchTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> ButtonSubclass中调用dispatchTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> ButtonSubclass中调用dispatchTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> ButtonSubclass中调用onTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> ButtonSubclass中调用onTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> ButtonSubclass中调用onTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return false;
    }
}
