package com.risenb.thousandnight.adapter;

import android.view.View;

import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;

import butterknife.ButterKnife;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2017/3/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public abstract class MyBaseViewHold extends BaseViewHolder {

    public MyBaseViewHold(View itemView) {
        super(itemView);
    }

    @Override
    protected abstract void prepareData();

    @Override
    protected void reflectionView(View view) {
        ButterKnife.bind(this, view);
    }
}
