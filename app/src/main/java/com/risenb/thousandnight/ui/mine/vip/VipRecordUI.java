package com.risenb.thousandnight.ui.mine.vip;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineVipRecordAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 购买记录
 * Created by user on 2018/5/25.
 */

public class VipRecordUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private MineVipRecordAdapter<Object> mineVipRecordAdapter;

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
        setTitle("购买记录");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        mineVipRecordAdapter = new MineVipRecordAdapter<>();
        mineVipRecordAdapter.setActivity(this);
        xrv_common.setAdapter(mineVipRecordAdapter);
    }

}
