package com.stay4it.testpatheffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PathEffectView extends View{
    public PathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0,300);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(8);
        Path  path = new Path();
        path.moveTo(15, 60);
        for (int i = 0; i <= 35; i++) {
            path.lineTo(i * 30, (float) (Math.random() * 150));
        }
        canvas.drawPath(path, paint);

        canvas.translate(0, 400);
        paint.setPathEffect(new CornerPathEffect(60));
        canvas.drawPath(path, paint);


        canvas.translate(0, 400);
        paint.setPathEffect(new DashPathEffect(new float[] {15, 8}, 1));
        canvas.drawPath(path, paint);
    }
}
