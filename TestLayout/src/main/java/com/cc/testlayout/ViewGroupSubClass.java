package com.cc.testlayout;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ViewGroupSubClass extends ViewGroup{
    public ViewGroupSubClass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount=getChildCount();
        if(childCount>0){
            View child=getChildAt(0);
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount=getChildCount();
        if(childCount>0){
            View child=getChildAt(0);
            int measuredWidth=child.getMeasuredWidth();
            int measuredHeight=child.getMeasuredHeight();
            child.layout(0,0,measuredWidth,measuredHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
