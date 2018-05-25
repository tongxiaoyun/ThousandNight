package com.risenb.thousandnight.ui.found.recruit;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundRecruitAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 求职招聘
 * Created by user on 2018/5/16.
 */

public class FoundRecruitUI extends BaseUI {

    @BindView(R.id.xrv_found_job)
    XRecyclerView xrv_found_job;

    private FoundRecruitAdapter<Object> foundRecruitAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_recruit;
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
        foundRecruitAdapter = new FoundRecruitAdapter<>();
        foundRecruitAdapter.setActivity(this);
        foundRecruitAdapter.setUI("发现");
        xrv_found_job.setAdapter(foundRecruitAdapter);
    }
}
