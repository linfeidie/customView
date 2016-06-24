package com.stay4it.testtouch4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
/**
 * 原创作者
 * 谷哥的小弟
 *
 * 博客地址
 * http://blog.csdn.net/lfdfhl
 */
public class HorizontalScrollViewSubclass extends HorizontalScrollView{
    private float LastX;
    private float LastY;
    private float distanceX;
    private float distanceY;
    public HorizontalScrollViewSubclass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                distanceX = 0f;
                distanceY = 0f;
                LastX = ev.getX();
                LastY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                final float currentX = ev.getX();
                final float currentY = ev.getY();

                distanceX += Math.abs(currentX - LastX);
                distanceY += Math.abs(currentY - LastY);
                
                LastX = currentX;
                LastY = currentY;

                if(distanceX > distanceY){
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
