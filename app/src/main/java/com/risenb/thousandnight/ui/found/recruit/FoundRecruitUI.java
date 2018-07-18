package com.risenb.thousandnight.ui.found.recruit;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundRecruitAdapter;
import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.mine.recruit.DeliverDetailUI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 求职招聘
 * Created by user on 2018/5/16.
 */

public class FoundRecruitUI extends BaseUI implements XRecyclerView.LoadingListener, FoundRecruitP.FoundRecruitFace {

    @BindView(R.id.xrv_found_job)
    XRecyclerView xrv_found_job;

    private FoundRecruitP foundRecruitP;

    private FoundRecruitAdapter<PositonBean> foundRecruitAdapter;
    private int page = 1;

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
        foundRecruitP = new FoundRecruitP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        foundRecruitP.positionList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_found_job.setLayoutManager(linearLayoutManager);
        foundRecruitAdapter = new FoundRecruitAdapter<>();
        foundRecruitAdapter.setActivity(this);
        foundRecruitAdapter.setUI("发现");
        xrv_found_job.setAdapter(foundRecruitAdapter);
        xrv_found_job.setLoadingListener(this);
        foundRecruitAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(FoundRecruitUI.this, DeliverDetailUI.class);
                intent.putExtra("ui", "found");
                intent.putExtra("positionId", foundRecruitAdapter.getList().get(i).getPositionId());
                startActivity(intent);
            }
        });
    }


    @OnClick(R.id.ll_right)
    void right() {
        Intent intent = new Intent(getActivity(), ReleaseRecuitUI.class);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        page = 1;
        foundRecruitP.positionList();
    }

    @Override
    public void onLoadMore() {
        page++;
        foundRecruitP.positionList();
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
    public String getProvinceId() {
        return "";
    }

    @Override
    public String getCityId() {
        return "";
    }

    @Override
    public String getAreaId() {
        return "";
    }

    @Override
    public String getPositionType() {
        return "";
    }

    @Override
    public String getWorkYears() {
        return "";
    }

    @Override
    public String getPositionGrade() {
        return "";
    }

    @Override
    public String getSalaryType() {
        return "";
    }

    @Override
    public String getSalaryBegin() {
        return "";
    }

    @Override
    public String getSalaryEnd() {
        return "";
    }

    @Override
    public void setResult(ArrayList<PositonBean> result) {
        foundRecruitAdapter.setList(result);
        xrv_found_job.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<PositonBean> result) {
        foundRecruitAdapter.addList(result);
        xrv_found_job.loadMoreComplete();
    }
}
