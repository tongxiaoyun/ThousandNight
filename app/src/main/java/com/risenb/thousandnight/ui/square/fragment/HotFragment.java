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
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.square.SquareDetailUI;

import butterknife.BindView;

/**
 * 热门
 * Created by user on 2018/5/11.
 */

public class HotFragment extends BaseFragment {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private SquareHotAdapter<Object> squareHotAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
    }

    @Override
    protected void prepareData() {

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

}
