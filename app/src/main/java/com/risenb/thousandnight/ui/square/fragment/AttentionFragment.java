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
import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.square.SquareDetailUI;
import com.risenb.thousandnight.ui.square.SquareReportUI;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 关注
 * Created by user on 2018/5/11.
 */

public class AttentionFragment extends BaseFragment implements XRecyclerView.LoadingListener, HotP.HotFace {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private HotP hotP;

    private SquareAttentionAdapter<MomentBean> squareAttentionAdapter;
    private int page = 1;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
        hotP = new HotP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        hotP.momentList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        squareAttentionAdapter = new SquareAttentionAdapter<>();
        squareAttentionAdapter.setActivity(getActivity());
        xrv_common.setAdapter(squareAttentionAdapter);
        xrv_common.setLoadingListener(this);
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
        return "2";
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
        squareAttentionAdapter.setList(result);
        xrv_common.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<MomentBean> result) {
        squareAttentionAdapter.addList(result);
        xrv_common.loadMoreComplete();
    }
}
