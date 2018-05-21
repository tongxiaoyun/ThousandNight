package com.risenb.thousandnight.ui.square.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.SquareAttentionAdapter;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.square.SquareDetailUI;
import com.risenb.thousandnight.ui.square.SquareReportUI;

import butterknife.BindView;

/**
 * 关注
 * Created by user on 2018/5/11.
 */

public class AttentionFragment extends BaseFragment {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private SquareAttentionAdapter<Object> squareAttentionAdapter;

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
        squareAttentionAdapter = new SquareAttentionAdapter<>();
        squareAttentionAdapter.setActivity(getActivity());
        xrv_common.setAdapter(squareAttentionAdapter);
        squareAttentionAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), SquareDetailUI.class);
                startActivity(intent);
            }
        });
        squareAttentionAdapter.setOnItemReportClickListener(new SquareAttentionAdapter.OnItemReportClickListener() {
            @Override
            public void onItemReportClick(int position) {
                Intent intent = new Intent(getActivity(), SquareReportUI.class);
                startActivity(intent);
            }
        });
    }

}
