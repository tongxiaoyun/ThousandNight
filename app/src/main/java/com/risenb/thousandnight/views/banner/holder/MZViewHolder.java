package com.risenb.thousandnight.views.banner.holder;

import android.content.Context;
import android.view.View;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/13
 * 描    述：
 * 修订历史：
 * ================================================
 */
public interface MZViewHolder<T> {
    /**
     *  创建View
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context, int position, T data);
}