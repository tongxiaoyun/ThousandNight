package com.risenb.thousandnight.ui.found.livevideo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundLiveVideoAdapter;
import com.risenb.thousandnight.adapter.FoundLiveVideoTopAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 直播
 * Created by user on 2018/5/16.
 */

public class FoundLiveVideoUI extends BaseUI {

    @BindView(R.id.rv_found_live_video)
    RecyclerView rv_found_live_video;

    @BindView(R.id.xrv_found_live_video)
    XRecyclerView xrv_found_live_video;

    private FoundLiveVideoTopAdapter<Object> liveVideoTopAdapter;

    private FoundLiveVideoAdapter<Object> liveVideoAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_live_video;
    }

    @Override
    protected void setControlBasis() {
        setTitle("直播");
        rightVisible(R.drawable.found_living);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager llm_top = new LinearLayoutManager(this);
        llm_top.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_found_live_video.setLayoutManager(llm_top);
        liveVideoTopAdapter = new FoundLiveVideoTopAdapter<>();
        liveVideoTopAdapter.setActivity(this);
        rv_found_live_video.setAdapter(liveVideoTopAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_found_live_video.setLayoutManager(linearLayoutManager);
        liveVideoAdapter = new FoundLiveVideoAdapter<>();
        liveVideoAdapter.setActivity(this);
        xrv_found_live_video.setAdapter(liveVideoAdapter);
    }
}
