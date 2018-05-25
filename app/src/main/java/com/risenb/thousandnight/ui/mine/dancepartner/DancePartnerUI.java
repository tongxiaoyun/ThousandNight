package com.risenb.thousandnight.ui.mine.dancepartner;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundDanceAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 寻找舞伴记录
 * Created by user on 2018/5/24.
 */

public class DancePartnerUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private FoundDanceAdapter<Object> foundDanceAdapter;

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
        setTitle("寻找舞伴记录");
        rightVisible(R.drawable.mine_delete);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        foundDanceAdapter = new FoundDanceAdapter<>();
        foundDanceAdapter.setActivity(this);
        xrv_common.setAdapter(foundDanceAdapter);
    }
}
