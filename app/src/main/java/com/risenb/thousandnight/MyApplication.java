package com.risenb.thousandnight;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.alibaba.fastjson.JSONObject;
import com.risenb.expand.loading.AVLoadingIndicatorView;
import com.risenb.expand.m;
import com.risenb.expand.utils.Log;
import com.risenb.thousandnight.beans.User;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.utils.PreferencesUtil;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MyApplication extends Application {

    private static  Context content;

    @Override
    public void onCreate() {
        super.onCreate();
        m.getInstance().getLoadingM().setIndicatorId(AVLoadingIndicatorView.BallBeat);
        m.getInstance().initDebug(true).initNetWorkDefault(getApplicationContext()).setApplication(this);
        Log.debug = true;
        content = getApplicationContext();
        m.getInstance().initNetWorkDefault(getApplicationContext());
        NetworkUtils.getNetworkUtils().setApplication(this);
        getAndroiodScreenProperty();
        PreferencesUtil.init(getApplicationContext());

    }

    public static  Context getContent() {
        return content;
    }

    public void getAndroiodScreenProperty() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        int screenHeight = (int) (height / density);// 屏幕高度(dp)

    }

    public String getC() {
        return (String) PreferencesUtil.getInstance().getData("c", "");
    }

    public void setC(String c) {
        PreferencesUtil.getInstance().saveData("c", c);
    }

    public void setUserBean(User bean) {
        PreferencesUtil.getInstance().saveData("UserBean", JSONObject.toJSONString(bean));
    }

    public User getUserBean() {
        String str = (String) PreferencesUtil.getInstance().getData("UserBean", "{}");
        if (!TextUtils.isEmpty(str)) {
            try {
                return JSONObject.parseObject(str, User.class);
            } catch (Exception e) {

            }
        }
        return null;
    }

}
