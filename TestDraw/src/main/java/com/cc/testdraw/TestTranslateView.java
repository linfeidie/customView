package com.cc.testdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TestTranslateView extends View {
    public TestTranslateView(Context context, AttributeSet attrs) {
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
        canvas.drawText("蓝色字体为Translate前所画", 20, 80, paint);

        canvas.translate(100,300);

        paint.setColor(Color.BLACK);
        canvas.drawText("黑色字体为Translate后所画", 20, 80, paint);
    }
}


