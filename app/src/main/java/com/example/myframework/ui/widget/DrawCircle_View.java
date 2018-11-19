package com.example.myframework.ui.widget;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/11/15 0015.
 */

public class DrawCircle_View extends View {

    Paint paint=new Paint();

    public DrawCircle_View(Context context) {
        super(context);
    }

    public DrawCircle_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircle_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawCircle_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setAntiAlias(true);
//        paint.setColor();
//        paint.setTextSize();

        canvas.drawCircle(150,150,50,paint);
//        canvas.drawColor();
//        canvas.drawArc();
//        canvas.drawOval();
//        canvas.drawBitmap();
//        canvas.drawPoint();
//        canvas.drawPoints();
//        canvas.drawRect();
//        canvas.drawLines()
//        canvas.drawPath()
//        canvas.drawText()
    }

}
