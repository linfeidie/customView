package com.stay4it.testtouch2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 原创作者
 * 谷哥的小弟
 *
 * 博客地址
 * http://blog.csdn.net/lfdfhl
 */
public class LinearLayoutSubclass extends LinearLayout {
    public LinearLayoutSubclass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> LinearLayoutSubclass 中调用  dispatchTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> LinearLayoutSubclass 中调用  dispatchTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> LinearLayoutSubclass 中调用  dispatchTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> LinearLayoutSubclass中调用onInterceptTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> LinearLayoutSubclass中调用onInterceptTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> LinearLayoutSubclass中调用onInterceptTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("---> LinearLayoutSubclass中调用onTouchEvent()--->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("---> LinearLayoutSubclass中调用onTouchEvent()--->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("---> LinearLayoutSubclass中调用onTouchEvent()--->ACTION_UP");
            default:
                break;
        }
        return false;
    }
}
