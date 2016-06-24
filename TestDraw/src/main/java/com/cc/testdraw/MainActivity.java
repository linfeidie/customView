package com.cc.testdraw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        drawOnBitmap();
    }

    private void init(){
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    private void drawOnBitmap(){
        Bitmap bitmap=Bitmap.createBitmap(800, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        canvas.drawColor(Color.GREEN);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(60);
        canvas.drawText("hello , everyone", 150, 200, paint);
        mImageView.setImageBitmap(bitmap);
    }
}
