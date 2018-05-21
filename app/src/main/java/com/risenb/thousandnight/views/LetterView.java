package com.risenb.thousandnight.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.risenb.expand.utils.DisplayUtil;
import com.risenb.expand.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/15
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class LetterView extends View {
    private String TAG = LetterView.class.getSimpleName();
    //A,B,C....Z,#
    public List<String> letters;
    private Paint mPaint;
    private int selectPosition = -1;
    private TextView mLetter;

    public void setmLetter(TextView mLetter) {
        this.mLetter = mLetter;
    }

    public LetterView(Context context) {
        this(context, null);
    }

    public LetterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LetterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //生产字母
        letters = new ArrayList<>();
        //肺  大  胃  脾  心  小  膀  肾  包  三  胆  肝  督  任  经
        letters.add("肺");
        letters.add("大");
        letters.add("胃");
        letters.add("脾");
        letters.add("心");
        letters.add("小");
        letters.add("膀");
        letters.add("肾");
        letters.add("包");
        letters.add("胆");
        letters.add("肝");
        letters.add("督");
        letters.add("任");
        letters.add("经");
        //初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#8a5134"));
        mPaint.setTextSize(DisplayUtil.getDimen(context.getApplicationContext(), com.risenb.expand.R.dimen.dm028));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 获取View的宽度
         * 获取View的高度
         */
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        //测量字的宽度
        int size = letters.size();
        for (int i = 0; i < size; i++) {
            float textWidth = mPaint.measureText(letters.get(i));
            int singleHeight = height / size;
            canvas.drawText(letters.get(i), (width - textWidth) / 2, singleHeight * (i + 1), mPaint);
            /**
             * drawText() x y \_ 为基准线
             */
            invalidate();
        }
    }

    /**
     * Android将触摸事件封装,包装了动作,位置信息;onClick也是一种motionEvent
     * onClick 事件 实际上是 onTouchEvent事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //包装了动作,位置信息
//    event.getY();//相对于View本身的坐标值
//    event.getRawY();//返回的是相对于屏幕的坐标值
        float y = event.getY();
        Log.e(TAG, "onTouchEvent: Y:" + y);
//    Log.e(TAG, "onTouchEvent: RawY:"+event.getRawY() );
        int measuredHeight = getMeasuredHeight();
        int singleHeight = measuredHeight / letters.size();
        int position = (int) (y / singleHeight);
        Log.e(TAG, "onTouchEvent: " + position);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent: ACTION_MOVE");
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent: ACTION_DOWN");
                selectPosition = position;
                if (mLetter != null) {
                    mLetter.setVisibility(View.VISIBLE);
                    //极限情况有可能下标越界,需要判断一下
                    if (position < letters.size() && position >= 0) {
                        mLetter.setText(letters.get(position));
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent: ACTION_UP");
                selectPosition = -1;
                if (mLetter != null) {
                    mLetter.setVisibility(View.GONE);
                }
                break;
        }
        //返回true代表事件被处理了
        return true;
    }
}