package com.risenb.thousandnight.ui.found.dance;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundDanceAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 舞伴大厅
 * Created by user on 2018/5/16.
 */

public class FoundDanceUI extends BaseUI {

    @BindView(R.id.xrv_found_dance)
    XRecyclerView xrv_found_dance;

    private FoundDanceAdapter<Object> foundDanceAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_dance;
    }

    @Override
    protected void setControlBasis() {
        setTitle("舞伴大厅");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_found_dance.setLayoutManager(linearLayoutManager);
        foundDanceAdapter = new FoundDanceAdapter<>();
        foundDanceAdapter.setActivity(this);
        xrv_found_dance.setAdapter(foundDanceAdapter);
    }

}
