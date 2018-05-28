package com.risenb.thousandnight.ui.found.activity;

import android.support.v7.widget.GridLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.ActivityHomeAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ActivityHomeUI extends BaseUI {


    @BindView(R.id.xrv_activity_home)
    XRecyclerView xrv_activity_home;
    private ActivityHomeAdapter<Object> activityHomeAdapter;


    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_activity_home;
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
        setTitle("千夜活动");
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        xrv_activity_home.setHeadPosition(1);
        xrv_activity_home.setLayoutManager(gridLayoutManager);
        xrv_activity_home.setPullRefreshEnabled(false);
        activityHomeAdapter = new ActivityHomeAdapter<>();
        activityHomeAdapter.setmHeaderCount(1);
        activityHomeAdapter.setActivity(getActivity());
        xrv_activity_home.setAdapter(activityHomeAdapter);
    }
}
