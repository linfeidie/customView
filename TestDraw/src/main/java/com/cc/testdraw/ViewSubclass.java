package com.cc.testdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ViewSubclass extends View {
    private Paint mPaint;
    public ViewSubclass(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
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
        //-------->绘制白色矩形
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, 800, 800, mPaint);
        mPaint.reset();

        //-------->绘制直线
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        canvas.drawLine(450, 30, 570, 170, mPaint);
        mPaint.reset();

        //-------->绘制带边框的矩形
        mPaint.setStrokeWidth(10);
        mPaint.setARGB(150, 90, 255, 0);
        mPaint.setStyle(Paint.Style.STROKE);
        RectF rectF1=new RectF(30, 60, 350, 350);
        canvas.drawRect(rectF1, mPaint);
        mPaint.reset();

        //-------->绘制实心圆
        mPaint.setStrokeWidth(14);
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(670, 300, 70, mPaint);
        mPaint.reset();

        //-------->绘制椭圆
        mPaint.setColor(Color.YELLOW);
        RectF rectF2=new RectF(200, 430, 600, 600);
        canvas.drawOval(rectF2, mPaint);
        mPaint.reset();

        //-------->绘制文字
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(60);
        mPaint.setUnderlineText(true);
        canvas.drawText("Hello Android", 150, 720, mPaint);
        mPaint.reset();
    }
}
