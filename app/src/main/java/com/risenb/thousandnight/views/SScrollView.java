package com.risenb.thousandnight.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by user on 2017/6/30.
 */

public class SScrollView extends ScrollView {

    public interface OnScrollerView {
        void onScrollChanged(SScrollView sScrollView, int X, int Y, int oldX, int oldY);
    }

    public OnScrollerView onScrollerView;

    public void setOnScrollerView(OnScrollerView onScrollerView) {
        this.onScrollerView = onScrollerView;
    }

    public SScrollView(Context context) {
        super(context);
    }

    public SScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollerView != null) {
            onScrollerView.onScrollChanged(this, l, t, oldl, oldt);
        }
    }
}
