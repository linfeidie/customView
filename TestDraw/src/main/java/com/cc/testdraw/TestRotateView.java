package com.cc.testdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TestRotateView extends View {
    public TestRotateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
        Paint paint=new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.BLUE);
        canvas.drawText("绿色字体为Rotate前所绘", 20, 80, paint);

        canvas.rotate(15);

        paint.setColor(Color.BLACK);
        canvas.drawText("黑色字体为Rotate后所绘", 20, 80, paint);
    }
}


