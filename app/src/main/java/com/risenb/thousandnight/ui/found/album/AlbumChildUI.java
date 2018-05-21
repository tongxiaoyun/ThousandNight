package com.risenb.thousandnight.ui.found.album;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundAlbumChildAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 相册名称
 * Created by user on 2018/5/15.
 */

public class AlbumChildUI extends BaseUI {

    @BindView(R.id.xrv_found_album)
    XRecyclerView xrv_found_album;

    private FoundAlbumChildAdapter<Object> foundAlbumChildAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_album_child;
    }

    @Override
    protected void setControlBasis() {
        setTitle("相册名称");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        xrv_found_album.setLayoutManager(gridLayoutManager);
        foundAlbumChildAdapter = new FoundAlbumChildAdapter<>();
        foundAlbumChildAdapter.setActivity(this);
        xrv_found_album.setAdapter(foundAlbumChildAdapter);
        foundAlbumChildAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(AlbumChildUI.this, AlbumDetailUI.class);
                startActivity(intent);
            }
        });
    }
}
