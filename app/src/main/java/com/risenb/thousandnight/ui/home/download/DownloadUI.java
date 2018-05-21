package com.risenb.thousandnight.ui.home.download;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeDownloadAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 下载记录
 * Created by user on 2018/5/18.
 */

public class DownloadUI extends BaseUI {

    @BindView(R.id.xrv_download)
    XRecyclerView xrv_download;

    @BindView(R.id.iv_right)
    ImageView iv_right;

    @BindView(R.id.tv_right)
    TextView tv_right;

    @BindView(R.id.ll_download_delete)
    LinearLayout ll_download_delete;

    private HomeDownloadAdapter<Object> homeDownloadAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_download;
    }

    @Override
    protected void setControlBasis() {
        setTitle("下载记录");
        rightVisible(R.drawable.home_delete);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_download.setLayoutManager(linearLayoutManager);
        homeDownloadAdapter = new HomeDownloadAdapter<>();
        homeDownloadAdapter.setActivity(this);
        homeDownloadAdapter.setmHeaderCount(1);
        xrv_download.setAdapter(homeDownloadAdapter);
    }

    @OnClick(R.id.ll_right)
    void delete(){
        if (ll_download_delete.getVisibility() == View.VISIBLE){
            iv_right.setVisibility(View.VISIBLE);
            tv_right.setVisibility(View.GONE);
            rightVisible(R.drawable.home_delete);
            ll_download_delete.setVisibility(View.GONE);
        } else {
            iv_right.setVisibility(View.GONE);
            tv_right.setVisibility(View.VISIBLE);
            rightVisible("取消");
            ll_download_delete.setVisibility(View.VISIBLE);
        }
    }

}
