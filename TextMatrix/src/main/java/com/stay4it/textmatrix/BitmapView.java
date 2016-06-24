package com.stay4it.textmatrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class BitmapView extends View{
    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //drawBitmap(canvas);
        drawBitmapWithMatrix(canvas);
    }

    private void drawBitmap(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.aaa);
        canvas.drawBitmap(bitmap, 50, 50, paint);
    }


    private void drawBitmapWithMatrix(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mm);
        int width=bitmap.getWidth();
        int height=bitmap.getHeight();

        Matrix matrix = new Matrix();

        canvas.drawBitmap(bitmap, matrix, paint);

        matrix.setTranslate(width/2, height);
        canvas.drawBitmap(bitmap, matrix, paint);

        matrix.postScale(0.5f, 0.5f);
        //matrix.preScale(2f, 2f);
        canvas.drawBitmap(bitmap, matrix, paint);
    }

}
