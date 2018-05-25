package com.risenb.thousandnight.ui.mine.dynamic;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineDynamicAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 我的动态
 * Created by user on 2018/5/24.
 */

public class DynamicUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private MineDynamicAdapter<Object> mineDynamicAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_common_2;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我的动态");
        rightVisible(R.drawable.square_take);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        mineDynamicAdapter = new MineDynamicAdapter<>();
        mineDynamicAdapter.setActivity(this);
        xrv_common.setAdapter(mineDynamicAdapter);
    }

}
