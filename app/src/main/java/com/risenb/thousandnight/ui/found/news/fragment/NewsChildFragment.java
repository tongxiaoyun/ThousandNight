package com.risenb.thousandnight.ui.found.news.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundNewsAdapter;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.beans.NewsBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.homep.BannerP;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 分类
 * Created by user on 2018/5/15.
 */

public class NewsChildFragment extends BaseFragment implements BannerP.BannerFace, NewsChildP.NewsChildFace, XRecyclerView.LoadingListener {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private BannerP bannerP;
    private NewsChildP newsChildP;

    private FoundNewsAdapter<NewsBean> foundNewsAdapter;
    private int page = 1;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
    }

    @Override
    protected void setControlBasis() {
        bannerP = new BannerP(this, getActivity());
        newsChildP = new NewsChildP(this, getActivity());
        initAdapter();
    }

    @Override
    protected void prepareData() {
        bannerP.getBanner();
        newsChildP.newsList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        foundNewsAdapter = new FoundNewsAdapter<>();
        foundNewsAdapter.setActivity(getActivity());
        foundNewsAdapter.setmHeaderCount(1);
        xrv_common.setAdapter(foundNewsAdapter);
        xrv_common.setLoadingListener(this);
    }

    @Override
    public String getBannerType() {
        return "3";
    }

    @Override
    public void setBanner(ArrayList<BannerBean> result) {
        foundNewsAdapter.setResult(result);
    }

    @Override
    public void onRefresh() {
        page = 1;
        newsChildP.newsList();
    }

    @Override
    public void onLoadMore() {
        page++;
        newsChildP.newsList();
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
        return "";
    }

    @Override
    public String getKeyword() {
        return "";
    }

    @Override
    public void setResult(ArrayList<NewsBean> result) {
        foundNewsAdapter.setList(result);
        xrv_common.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<NewsBean> result) {
        foundNewsAdapter.addList(result);
        xrv_common.loadMoreComplete();
    }
}
