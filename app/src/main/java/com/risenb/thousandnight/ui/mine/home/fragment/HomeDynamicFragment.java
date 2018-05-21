package com.risenb.thousandnight.ui.mine.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineHomeDynamicAdapter;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 动态
 * Created by user on 2018/5/9.
 */

public class HomeDynamicFragment extends BaseFragment {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private MineHomeDynamicAdapter<Object> mineHomeDynamicAdapter;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        mineHomeDynamicAdapter = new MineHomeDynamicAdapter<>();
        mineHomeDynamicAdapter.setActivity(getActivity());
        xrv_common.setAdapter(mineHomeDynamicAdapter);
    }

}
