package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.VideoChildAdapter;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.ui.BaseUI;

import java.util.ArrayList;

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
public class NewsVideoUI extends BaseUI implements XRecyclerView.LoadingListener, VideoChildP.VideoChildFace {

    @BindView(R.id.xrv_news_video)
    XRecyclerView xrv_news_video;

    private VideoChildAdapter<VideoListBean> newsVideoAdapter;
    private int page = 1;
    private String isHot = "";

    private VideoChildP videoChildP;

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
        setTitle(getIntent().getStringExtra("title"));
        initAdapter();
        isHot = getIntent().getStringExtra("isHot");
        videoChildP = new VideoChildP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        videoChildP.videoList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_news_video.setLayoutManager(linearLayoutManager);
        newsVideoAdapter = new VideoChildAdapter<>();
        newsVideoAdapter.setActivity(getActivity());
        xrv_news_video.setAdapter(newsVideoAdapter);
        xrv_news_video.setLoadingListener(this);
        newsVideoAdapter.setOnItemCollectClickListener(new VideoChildAdapter.OnItemCollectClickListener() {
            @Override
            public void onItemCollectClick(int position) {
                if ("0".equals(newsVideoAdapter.getList().get(position).getIsLike())){
                    videoChildP.videoCollect(newsVideoAdapter.getList().get(position).getVideoId(), "1");
                } else if ("1".equals(newsVideoAdapter.getList().get(position).getIsLike())){
                    videoChildP.videoCollect(newsVideoAdapter.getList().get(position).getVideoId(), "0");
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        page = 1;
        videoChildP.videoList();
    }

    @Override
    public void onLoadMore() {
        page++;
        videoChildP.videoList();
    }

    @Override
    public int getPageNo() {
        return page;
    }

    @Override
    public String getPageSize() {
        return "15";
    }

    @Override
    public String getIsHot() {
        return isHot;
    }

    @Override
    public String getParamId() {
        return "";
    }

    @Override
    public String getParentId() {
        return "";
    }

    @Override
    public String getOrderField() {
        return "";
    }

    @Override
    public String getOrderDirection() {
        return "";
    }

    @Override
    public void setResule(ArrayList<VideoListBean> result) {
        newsVideoAdapter.setList(result);
        xrv_news_video.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<VideoListBean> result) {
        newsVideoAdapter.addList(result);
        xrv_news_video.loadMoreComplete();
    }

    @Override
    public void collectSuccess() {
        videoChildP.videoList();
    }
}
