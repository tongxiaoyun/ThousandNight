package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.VideoChildAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/21
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NewsVideoUI extends BaseUI {

    @BindView(R.id.xrv_news_video)
    XRecyclerView xrv_news_video;
    private VideoChildAdapter<Object> newsVideoAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_news_video;
    }

    @Override
    protected void setControlBasis() {
        setTitle("最新");
        initAdapter();

    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_news_video.setLayoutManager(linearLayoutManager);
        newsVideoAdapter = new VideoChildAdapter<>();
        newsVideoAdapter.setActivity(getActivity());
        xrv_news_video.setAdapter(newsVideoAdapter);
    }
}
