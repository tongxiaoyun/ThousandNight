package com.risenb.thousandnight.views.banner.holder;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/13
 * 描    述：
 * 修订历史：
 * ================================================
 */
public interface MZHolderCreator<VH extends MZViewHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public VH createViewHolder();
}