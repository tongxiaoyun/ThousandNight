package com.risenb.thousandnight.ui.found.album;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundAlbumAdapter;
import com.risenb.thousandnight.beans.AlbumBean;
import com.risenb.thousandnight.ui.BaseUI;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 千夜相册
 * Created by user on 2018/5/15.
 */

public class FoundAlbumUI extends BaseUI implements XRecyclerView.LoadingListener, FoundAlbumP.FoundAlbumFace {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private FoundAlbumP foundAlbumP;

    private FoundAlbumAdapter<AlbumBean> foundAlbumAdapter;
    private int page = 1;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_common;
    }

    @Override
    protected void setControlBasis() {
        setTitle("千夜相册");
        initAdapter();
        foundAlbumP = new FoundAlbumP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        foundAlbumP.albumList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        foundAlbumAdapter = new FoundAlbumAdapter<>();
        foundAlbumAdapter.setActivity(this);
        xrv_common.setAdapter(foundAlbumAdapter);
        xrv_common.setLoadingListener(this);
        foundAlbumAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(FoundAlbumUI.this, AlbumChildUI.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRefresh() {
        page = 1;
        foundAlbumP.albumList();
    }

    @Override
    public void onLoadMore() {
        page++;
        foundAlbumP.albumList();
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
    public void setResult(ArrayList<AlbumBean> result) {
        foundAlbumAdapter.setList(result);
        xrv_common.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<AlbumBean> result) {
        foundAlbumAdapter.addList(result);
        xrv_common.loadMoreComplete();
    }
}
