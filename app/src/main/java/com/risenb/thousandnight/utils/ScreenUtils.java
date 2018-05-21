package com.risenb.thousandnight.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ScreenUtils {

    private static ScreenUtils screenUtils;

    public ScreenUtils() {
    }

    public static ScreenUtils getScreenUtils() {
        if (screenUtils == null) {
            screenUtils = new ScreenUtils();
        }

        return screenUtils;
    }

    public int getDpi(Context context) {
        int dpi = 0;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();

        try {
            Class c = Class.forName("android.view.Display");
            Method e = c.getMethod("getRealMetrics", new Class[]{DisplayMetrics.class});
            e.invoke(display, new Object[]{displayMetrics});
            dpi = displayMetrics.heightPixels;
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return dpi;
    }

    public int getBottomStatusHeight(Context context) {
        int totalHeight = this.getDpi(context);
        int contentHeight = this.getScreenHeight(context);
        return totalHeight - contentHeight;
    }


    public int getStatusHeight(Context context) {
        int statusHeight = -1;

        try {
            Class e = Class.forName("com.android.internal.R$dimen");
            Object object = e.newInstance();
            int height = Integer.parseInt(e.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return statusHeight;
    }

    public int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
