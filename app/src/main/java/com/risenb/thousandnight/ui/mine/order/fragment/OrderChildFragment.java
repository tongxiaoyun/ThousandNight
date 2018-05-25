package com.risenb.thousandnight.ui.mine.order.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineOrderAdapter;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.mine.order.OrderDetailUI;

import butterknife.BindView;

/**
 * Created by user on 2018/5/21.
 */

public class OrderChildFragment extends BaseFragment {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private MineOrderAdapter<Object> mineOrderAdapter;

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
        mineOrderAdapter = new MineOrderAdapter<>();
        mineOrderAdapter.setActivity(getActivity());
        xrv_common.setAdapter(mineOrderAdapter);
        mineOrderAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), OrderDetailUI.class);
                intent.putExtra("pay", "1");
                startActivity(intent);
            }
        });
    }

}
