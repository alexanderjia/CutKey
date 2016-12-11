package com.example.zhangjia.cutkey.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjia on 16/5/30.
 */
public class ProcessView extends View {
    private int viewWidth;
    private int viewHeight;
    private List<Point> pointList1 = new ArrayList<>();
    private List<Point> pointList2 = new ArrayList<>();
    private int bilie = 4;

    public ProcessView(Context context) {
        super(context);
    }

    public ProcessView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        viewWidth = this.getWidth();
        viewHeight = this.getMeasuredHeight();
        canvas.drawRect(0, 0, viewWidth, viewHeight, paint);
        Log.d("ww",viewHeight + "");
        Log.d("wh",viewWidth + "");
        if (pointList1.size() != 0) {
            Path path = new Path();
            path.moveTo(pointList1.get(0).x / bilie, -pointList1.get(0).y / bilie);
            for (int i = 1; i < pointList1.size(); i++) {
                path.lineTo(pointList1.get(i).x / bilie,- pointList1.get(i).y / bilie);
            }
            Paint paint1 = new Paint();
            paint1.setAntiAlias(true);
            paint1.setPathEffect(null);
            paint1.setColor(Color.WHITE);
            paint1.setStrokeWidth(4);
            paint1.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, paint1);
        }

        if (pointList2.size() != 0){
            Path path1 = new Path();
            path1.moveTo(pointList2.get(0).x / bilie,-pointList2.get(0).y / bilie);
            for (int i = 1;i < pointList2.size();i++){
                path1.lineTo(pointList2.get(i).x / bilie,-pointList2.get(i).y / bilie);
            }
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setPathEffect(null);
            paint2.setColor(Color.WHITE);
            paint2.setStrokeWidth(4);
            paint2.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path1, paint2);
        }

    }

    public void process(List<Point> points1,List<Point> points2) {
        pointList1 = points1;
        pointList2 = points2;
        invalidate();
    }
}
