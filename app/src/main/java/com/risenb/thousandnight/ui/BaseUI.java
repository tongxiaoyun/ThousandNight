package com.risenb.thousandnight.ui;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.risenb.expand.loading.LoadingUtils;
import com.risenb.expand.loading.listener.ReloadListener;
import com.risenb.expand.swipeback.base.SwipeBackUI;
import com.risenb.thousandnight.MyApplication;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.utils.ScreenUtils;
import com.risenb.thousandnight.utils.UIManager;

import butterknife.ButterKnife;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/12
 * 描    述：
 * 修订历史：
 * ================================================
 */
public abstract class BaseUI extends SwipeBackUI implements ReloadListener {

    private long exitTime = 0;
    protected MyApplication application;
    private boolean isContentView = false;
    protected boolean isDestroy = true;
    private LoadingUtils loadingUtils;
    protected boolean isHeadVisiable = true;
    protected int customHeight = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {

            }
        }
    };

    /**
     * 描述：返回
     */
    protected abstract void back();

    /**
     * 描述：设置控件
     */
    protected abstract int getLayout();

    /**
     * 描述：设置控件基础
     */
    protected abstract void setControlBasis();

    /**
     * 描述：准备数据
     */
    protected abstract void prepareData();

    /**
     * 描述：创建
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式布局
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        if (getLayout() != -1) {
            setContentView(getLayout());
        }
        ButterKnife.bind(this);

        application = (MyApplication) getApplication();
        UIManager.getInstance().pushActivity(this);
        setControlBasis();
        RelativeLayout back = (RelativeLayout) findViewById(R.id.back);
        if (back != null) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    back();
                }
            });
        }

        RelativeLayout v_top = (RelativeLayout) findViewById(R.id.v_top);
        if (v_top != null) {
            ViewGroup.MarginLayoutParams topParams = (ViewGroup.MarginLayoutParams) v_top.getLayoutParams();
            topParams.height = ScreenUtils.getScreenUtils().getStatusHeight(getActivity());
            v_top.setLayoutParams(topParams);
        }

        TextView v_bottom = (TextView) findViewById(R.id.v_bottom);
        if (v_bottom != null) {
            ViewGroup.MarginLayoutParams bottomParams = (ViewGroup.MarginLayoutParams) v_bottom.getLayoutParams();
            bottomParams.height = ScreenUtils.getScreenUtils().getBottomStatusHeight(getActivity());
            v_bottom.setLayoutParams(bottomParams);
        }
        prepareData();
    }

    @Override
    protected void onDestroy() {
        if (isDestroy) {
            UIManager.getInstance().popActivity(getClass());
        }
        super.onDestroy();
    }


    @Override
    public void setContentView(int layoutResID) {
        if (!isContentView) {
            isContentView = true;
            super.setContentView(layoutResID);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected FragmentActivity getActivity() {
        return BaseUI.this;
    }


    /**
     * 描述：退出程序
     */
    protected void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            UIManager.getInstance().popAllActivity();
        }
    }

    /**
     * 描述：设置标题
     *
     * @param text 标题
     */
    protected void setTitle(String text) {
        TextView tv_title = (TextView) findViewById(R.id.title);
        if (tv_title != null) {
            tv_title.setText(text);
        }
    }

    /**
     * 描述:隐藏返回按钮
     */
    protected void backGone() {
        RelativeLayout back = (RelativeLayout) findViewById(R.id.back);
        if (back != null) {
            back.setVisibility(View.GONE);
        }
    }

    /**
     * 描述:显示左菜单全部
     */
    protected void leftVisible(String title, int drawable) {
        backGone();
        leftVisible(title);
        leftVisible(drawable);
    }

    /**
     * 描述:显示左菜单文字
     */
    protected void leftVisible(String title) {
        LinearLayout ll_left = (LinearLayout) findViewById(R.id.ll_left);
        if (ll_left != null) {
            ll_left.setVisibility(View.VISIBLE);
        }
        TextView tv_left = (TextView) findViewById(R.id.tv_left);
        if (tv_left != null) {
            tv_left.setVisibility(View.VISIBLE);
            tv_left.setText(title);
        }
    }

    /**
     * 描述:显示左菜单图片
     */
    protected void leftVisible(int drawable) {
        LinearLayout ll_left = (LinearLayout) findViewById(R.id.ll_left);
        if (ll_left != null) {
            ll_left.setVisibility(View.VISIBLE);
        }
        ImageView iv_left = (ImageView) findViewById(R.id.iv_left);
        if (iv_left != null) {
            iv_left.setVisibility(View.VISIBLE);
            iv_left.setImageResource(drawable);
        }
    }

    /**
     * 描述:显示右菜单全部
     */
    protected void rightVisible(String title, int drawable) {
        rightVisible(title);
        rightVisible(drawable);
    }

    /**
     * 描述:显示右菜单文字
     */
    protected void rightVisible(String title) {
        LinearLayout ll_right = (LinearLayout) findViewById(R.id.ll_right);
        if (ll_right != null) {
            ll_right.setVisibility(View.VISIBLE);
        }
        TextView tv_right = (TextView) findViewById(R.id.tv_right);
        if (tv_right != null) {
            tv_right.setVisibility(View.VISIBLE);
            tv_right.setText(title);
        }
    }

    /**
     * 描述:显示右菜单图片
     */
    protected void rightVisible(int drawable) {
        LinearLayout ll_right = (LinearLayout) findViewById(R.id.ll_right);
        if (ll_right != null) {
            ll_right.setVisibility(View.VISIBLE);
        }
        ImageView iv_right = (ImageView) findViewById(R.id.iv_right);
        if (iv_right != null) {
            iv_right.setVisibility(View.VISIBLE);
            iv_right.setImageResource(drawable);
        }
    }

    protected void makeText(final String content) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private synchronized void initLoading(boolean head) {
        loadingUtils = new LoadingUtils();
        if (customHeight != 0) {
            loadingUtils.setCustomHeight(customHeight);
        }
        if (head) {
            loadingUtils.setShowHead();
        }
        loadingUtils.init(this);
        loadingUtils.setReloadListener(this);
    }

    /**
     * 加载中。。。
     */
    protected synchronized void loading() {
        if (loadingUtils == null) {
            initLoading(isHeadVisiable);
        }
        loadingUtils.show(LoadingUtils.LoadResult.LOADING);
    }

    /**
     * 加载失败
     */
    protected synchronized void loadingError() {
        if (loadingUtils == null) {
            initLoading(isHeadVisiable);
        }
        loadingUtils.show(LoadingUtils.LoadResult.ERROR);
    }

    /**
     * 数据为空
     */
    protected synchronized void loadingEmpty() {
        if (loadingUtils == null) {
            initLoading(isHeadVisiable);
        }
        loadingUtils.show(LoadingUtils.LoadResult.EMPTY);
    }

    /**
     * 加载成功
     */
    protected synchronized void loadingSuccess() {
        if (loadingUtils == null) {
            initLoading(isHeadVisiable);
        }
        loadingUtils.show(LoadingUtils.LoadResult.SUCCESS);
    }


    @Override
    public void reload() {

    }


}
