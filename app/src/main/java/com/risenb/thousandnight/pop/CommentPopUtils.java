package com.risenb.thousandnight.pop;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;


/**
 * @author 作者 : 佟啸云
 * @version 创建时间：2015-7-20 上午10:33:09
 * @类说明 pop窗口基础类
 */
public abstract class CommentPopUtils {
    private View v;
    protected PopupWindow popupWindow;
    protected OnClickListener onClickListener;
    protected OnItemClickListener itemClickListener;
    protected OnDismissListener onDismissListener;
    protected Context context;

    public CommentPopUtils(View v, Context context, int layout) {
        super();
        this.v = v;
        View view = LayoutInflater.from(context).inflate(layout, null);
        popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                popupWindow.dismiss();
                if (onDismissListener != null) {
                    onDismissListener.onDismiss();
                }
            }
        });
        this.context = context;
        initLayout(view, context);
        context = null;

    }


    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public abstract void initLayout(View v, Context context);

    /**
     * 下拉式 弹出 pop菜单 parent 右下角
     *
     * @paramparent
     */
    @SuppressWarnings("deprecation")
    public void showAsDropDown(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //获取目标控件在屏幕中的坐标位置
            int[] location = new int[2];
            v.getLocationOnScreen(location);
            if (Build.VERSION.SDK_INT == 25) {
                //【note!】Gets the screen height without the virtual key
                WindowManager wm = (WindowManager) popupWindow.getContentView().getContext().getSystemService(Context.WINDOW_SERVICE);
                int screenHeight = wm.getDefaultDisplay().getHeight();
                /*
                /*
                 * PopupWindow height for match_parent,
                 * will occupy the entire screen, it needs to do special treatment in Android 7.1
                */
                popupWindow.setHeight(screenHeight - location[1] - v.getHeight() - 0);
            }
            popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, 0, location[1] + v.getHeight());
        } else {
            popupWindow.showAsDropDown(v);
        }

        // 这个是为了点击“返回Back”也能使其消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);
        // 使其聚集
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true); // 设置PopupWindow可触摸
        // 设置弹出位置
        popupWindow.showAsDropDown(v);
        // 刷新状态
        popupWindow.update();

    }

    @SuppressWarnings("deprecation")
    public void showPopUp(View v) {

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        popupWindow.showAtLocation(v, Gravity.TOP, 15, location[1] - popupWindow.getHeight());
        popupWindow.update();
    }

    /**
     * 下拉式 弹出 pop菜单 parent 右下角
     *
     * @paramparent
     */
    @SuppressWarnings("deprecation")
    public void showAsDropDownInstance() {
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(false);
        // 使其聚集
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true); // 设置PopupWindow可触摸
        // 设置弹出位置
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
        // 刷新状态
        popupWindow.update();

    }

    /**
     * 下拉式 弹出 pop菜单 parent 右下角
     *
     * @paramparent
     */
    @SuppressWarnings("deprecation")
    public void showAtLocation() {
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 使其聚集
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        // 设置弹出位置
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
        // 刷新状态
        popupWindow.update();

    }

    /**
     * 下拉式 弹出 pop菜单 parent 右下角
     *
     * @paramparent
     */
    @SuppressWarnings("deprecation")
    public void showAtBottom() {
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 使其聚集
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        popupWindow.update();

    }

    /**
     * 隐藏菜单
     */
    public void dismiss() {
        popupWindow.dismiss();

    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}
