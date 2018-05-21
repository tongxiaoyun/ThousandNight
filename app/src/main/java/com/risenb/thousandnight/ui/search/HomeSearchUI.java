package com.risenb.thousandnight.ui.search;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeSearchAdapter;
import com.risenb.thousandnight.pop.SearchTypePopUtils;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索
 * Created by user on 2018/5/18.
 */

public class HomeSearchUI extends BaseUI {

    @BindView(R.id.rv_home_search)
    RecyclerView rv_home_search;


    @BindView(R.id.tv_home_search)
    TextView tv_home_search;

    private HomeSearchAdapter<Object> homeSearchAdapter;
    private SearchTypePopUtils searchTypePopUtils;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_search;
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
        initPop();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_home_search.setLayoutManager(linearLayoutManager);
        homeSearchAdapter = new HomeSearchAdapter<>();
        homeSearchAdapter.setActivity(this);
        rv_home_search.setAdapter(homeSearchAdapter);
    }


    private void initPop(){
        searchTypePopUtils = new SearchTypePopUtils(tv_home_search,getActivity(),R.layout.pop_search_type);
    }

    @OnClick(R.id.tv_home_search_cancel)
    void cancel(){
        finish();
    }

    @OnClick(R.id.tv_home_search)
    void show(){
        searchTypePopUtils.showAsDropDown(tv_home_search);
    }

}
