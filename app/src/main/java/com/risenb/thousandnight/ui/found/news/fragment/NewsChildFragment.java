package com.risenb.thousandnight.ui.found.news.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundNewsAdapter;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.homep.BannerP;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 分类
 * Created by user on 2018/5/15.
 */

public class NewsChildFragment extends BaseFragment implements BannerP.BannerFace {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private BannerP bannerP;

    private FoundNewsAdapter<Object> foundNewsAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
    }

    @Override
    protected void setControlBasis() {
        bannerP = new BannerP(this, getActivity());
        initAdapter();
    }

    @Override
    protected void prepareData() {
        bannerP.getBanner();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        foundNewsAdapter = new FoundNewsAdapter<>();
        foundNewsAdapter.setActivity(getActivity());
        foundNewsAdapter.setmHeaderCount(1);
        xrv_common.setAdapter(foundNewsAdapter);
    }

    @Override
    public String getType() {
        return "3";
    }

    @Override
    public void setBanner(ArrayList<BannerBean> result) {
        foundNewsAdapter.setResult(result);
    }
}
