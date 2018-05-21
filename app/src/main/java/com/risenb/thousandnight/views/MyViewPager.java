package com.risenb.thousandnight.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends android.support.v4.view.ViewPager {

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
