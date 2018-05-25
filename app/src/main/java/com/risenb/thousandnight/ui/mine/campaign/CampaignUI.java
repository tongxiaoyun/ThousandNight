package com.risenb.thousandnight.ui.mine.campaign;

import android.support.v7.widget.GridLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.Image2Adapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 我的活动
 * Created by user on 2018/5/24.
 */

public class CampaignUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private Image2Adapter<Object> image2Adapter;

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
        setTitle("我的活动");
        rightVisible(R.drawable.mine_delete);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        xrv_common.setLayoutManager(gridLayoutManager);
        image2Adapter = new Image2Adapter<>();
        image2Adapter.setActivity(this);
        xrv_common.setAdapter(image2Adapter);
    }
}
