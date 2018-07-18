package com.risenb.thousandnight.ui.square.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.SquareHotAdapter;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.homep.BannerP;
import com.risenb.thousandnight.ui.square.SquareDetailUI;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 热门
 * Created by user on 2018/5/11.
 */

public class HotFragment extends BaseFragment implements BannerP.BannerFace, HotP.HotFace, XRecyclerView.LoadingListener {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private BannerP bannerP;
    private HotP hotP;

    private SquareHotAdapter<MomentBean> squareHotAdapter;
    private int page = 1;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
    }

    @Override
    protected void setControlBasis() {
        bannerP = new BannerP(this, getActivity());
        hotP = new HotP(this, getActivity());
        initAdapter();
    }

    @Override
    protected void prepareData() {
        bannerP.getBanner();
        hotP.momentList();
    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        xrv_common.setHeadPosition(1);
        xrv_common.setLayoutManager(gridLayoutManager);
        squareHotAdapter = new SquareHotAdapter<>();
        squareHotAdapter.setActivity(getActivity());
        squareHotAdapter.setmHeaderCount(1);
        xrv_common.setAdapter(squareHotAdapter);
        xrv_common.setLoadingListener(this);
        squareHotAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), SquareDetailUI.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public String getBannerType() {
        return "2";
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
    public String getType() {
        return "1";
    }

    @Override
    public String getLat() {
        return "";
    }

    @Override
    public String getLng() {
        return "";
    }

    @Override
    public String getTargetId() {
        return "";
    }

    @Override
    public void setResult(ArrayList<MomentBean> result) {
        squareHotAdapter.setList(result);
        xrv_common.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<MomentBean> result) {
        squareHotAdapter.addList(result);
        xrv_common.loadMoreComplete();
    }

    @Override
    public void setBanner(ArrayList<BannerBean> result) {
        squareHotAdapter.setResult(result);
    }

    @Override
    public void onRefresh() {
        page = 1;
        hotP.momentList();
    }

    @Override
    public void onLoadMore() {
        page++;
        hotP.momentList();
    }
}
