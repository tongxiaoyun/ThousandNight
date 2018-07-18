package com.risenb.thousandnight.ui.found.dance;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundDanceAdapter;
import com.risenb.thousandnight.beans.DanceHallBean;
import com.risenb.thousandnight.ui.BaseUI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 舞伴大厅
 * Created by user on 2018/5/16.
 */

public class FoundDanceUI extends BaseUI implements XRecyclerView.LoadingListener, FoundDanceP.FoundDanceFace {

    @BindView(R.id.xrv_found_dance)
    XRecyclerView xrv_found_dance;

    private FoundDanceP foundDanceP;

    private FoundDanceAdapter<DanceHallBean> foundDanceAdapter;
    private int page = 1;

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
        foundDanceP = new FoundDanceP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        foundDanceP.positionList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_found_dance.setLayoutManager(linearLayoutManager);
        foundDanceAdapter = new FoundDanceAdapter<>();
        foundDanceAdapter.setActivity(this);
        xrv_found_dance.setAdapter(foundDanceAdapter);
        xrv_found_dance.setLoadingListener(this);
        foundDanceAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), DanceDetialUI.class);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.ll_found_dance_publish)
    void publish() {
        Intent intent = new Intent(getActivity(), RelealseDanceUI.class);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        page = 1;
        foundDanceP.positionList();
    }

    @Override
    public void onLoadMore() {
        page++;
        foundDanceP.positionList();
    }

    @Override
    public int getPageNo() {
        return page;
    }

    @Override
    public String getPageSize() {
        return "10";
    }

    @Override
    public String getLongitude() {
        return "";
    }

    @Override
    public String getLatitude() {
        return "";
    }

    @Override
    public String getProvinceId() {
        return "";
    }

    @Override
    public String getDanceFirst() {
        return "";
    }

    @Override
    public String getDancePartenerType() {
        return "";
    }

    @Override
    public void setResult(ArrayList<DanceHallBean> result) {
        foundDanceAdapter.setList(result);
        xrv_found_dance.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<DanceHallBean> result) {
        foundDanceAdapter.addList(result);
        xrv_found_dance.loadMoreComplete();
    }
}
