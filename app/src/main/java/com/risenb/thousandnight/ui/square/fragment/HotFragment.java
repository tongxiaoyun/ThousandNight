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
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.homep.BannerP;
import com.risenb.thousandnight.ui.square.SquareDetailUI;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 热门
 * Created by user on 2018/5/11.
 */

public class HotFragment extends BaseFragment implements BannerP.BannerFace {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private BannerP bannerP;

    private SquareHotAdapter<Object> squareHotAdapter;

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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        xrv_common.setHeadPosition(1);
        xrv_common.setLayoutManager(gridLayoutManager);
        squareHotAdapter = new SquareHotAdapter<>();
        squareHotAdapter.setActivity(getActivity());
        squareHotAdapter.setmHeaderCount(1);
        xrv_common.setAdapter(squareHotAdapter);
        squareHotAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), SquareDetailUI.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public String getType() {
        return "2";
    }

    @Override
    public void setBanner(ArrayList<BannerBean> result) {

    }
}
