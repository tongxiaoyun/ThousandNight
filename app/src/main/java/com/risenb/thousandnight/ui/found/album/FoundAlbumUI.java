package com.risenb.thousandnight.ui.found.album;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundAlbumAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 千夜相册
 * Created by user on 2018/5/15.
 */

public class FoundAlbumUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private FoundAlbumAdapter<Object> foundAlbumAdapter;

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
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        foundAlbumAdapter = new FoundAlbumAdapter<>();
        foundAlbumAdapter.setActivity(this);
        xrv_common.setAdapter(foundAlbumAdapter);
        foundAlbumAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(FoundAlbumUI.this, AlbumChildUI.class);
                startActivity(intent);
            }
        });
    }

}