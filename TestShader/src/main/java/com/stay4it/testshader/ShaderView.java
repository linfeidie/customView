package com.stay4it.testshader;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class ShaderView extends View {
    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mm);
        int radius = bitmap.getWidth()/2;
        BitmapShader bitmapShader = new BitmapShader(bitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT);
        paint.setShader(bitmapShader);
        canvas.translate(250,430);
        canvas.drawCircle(radius, radius, radius, paint);
    }



}
