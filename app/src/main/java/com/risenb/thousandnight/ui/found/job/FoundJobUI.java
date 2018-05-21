package com.risenb.thousandnight.ui.found.job;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundJobAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 求职招聘
 * Created by user on 2018/5/16.
 */

public class FoundJobUI extends BaseUI {

    @BindView(R.id.xrv_found_job)
    XRecyclerView xrv_found_job;

    private FoundJobAdapter<Object> foundJobAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_job;
    }

    @Override
    protected void setControlBasis() {
        setTitle("求职招聘");
        rightVisible(R.drawable.found_add);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_found_job.setLayoutManager(linearLayoutManager);
        foundJobAdapter = new FoundJobAdapter<>();
        foundJobAdapter.setActivity(this);
        xrv_found_job.setAdapter(foundJobAdapter);
    }
}
