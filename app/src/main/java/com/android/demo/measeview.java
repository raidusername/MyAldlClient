package com.android.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;

/**
 * @Description
 * @Author 14289
 * @Version 1.0
 **/
public class measeview extends ViewGroup {
    public measeview(Context context) {
        super(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
