package com.wk.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by apple on 2017/12/27.
 */

public class SimpleLayout extends ViewGroup {
    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        Log.e("wk", "SimpleLayout width " + width);
        Log.e("wk", "SimpleLayout height " + height);
        Log.e("wk", "SimpleLayout widthMode " + switchSpec(widthMode));
        Log.e("wk", "SimpleLayout heightMode " + switchSpec(heightMode));

        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            childView.layout(100, 100, childView.getMeasuredWidth()+100, childView.getMeasuredHeight()+100);
        }
    }

    private String switchSpec(int mode) {
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                return "UNSPECIFIED";
            case MeasureSpec.AT_MOST:
                return "AT_MOST";
            case MeasureSpec.EXACTLY:
                return "EXACTLY";
        }
        return "";
    }
}
