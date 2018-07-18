package com.risenb.thousandnight.ui.home.fragment.video;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.VideoChildAdapter;
import com.risenb.thousandnight.beans.HomeHotVideoBean;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.ui.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 视频 全部
 * Created by user on 2018/5/10.
 */

public class VideoChildFragment extends BaseFragment implements XRecyclerView.LoadingListener, VideoChildP.VideoChildFace {

    @BindView(R.id.xrv_video_child)
    XRecyclerView xrv_video_child;

    private VideoChildAdapter<VideoListBean> videoChildAdapter;
    private int page = 1;

    private String paramsId = "";
    private VideoChildP videoChildP;

    public VideoChildFragment(String paramsId) {
        this.paramsId = paramsId;
    }

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_video_child, container, false);
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
        videoChildP = new VideoChildP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        videoChildP.videoList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_video_child.setLayoutManager(linearLayoutManager);
        videoChildAdapter = new VideoChildAdapter<>();
        videoChildAdapter.setActivity(getActivity());
        xrv_video_child.setAdapter(videoChildAdapter);
        xrv_video_child.setLoadingListener(this);
        videoChildAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                if (!"UI".equals(getActivity().getIntent().getStringExtra("from"))) {
                    Intent intent = new Intent(getActivity(), CategoryVideoUI.class);
                    intent.putExtra("from", "UI");
                    startActivity(intent);
                }

            }
        });
        videoChildAdapter.setOnItemCollectClickListener(new VideoChildAdapter.OnItemCollectClickListener() {
            @Override
            public void onItemCollectClick(int position) {
                if ("0".equals(videoChildAdapter.getList().get(position).getIsLike())){
                    videoChildP.videoCollect(videoChildAdapter.getList().get(position).getVideoId(), "1");
                } else if ("1".equals(videoChildAdapter.getList().get(position).getIsLike())){
                    videoChildP.videoCollect(videoChildAdapter.getList().get(position).getVideoId(), "0");
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
        return "0";
    }

    @Override
    public String getParamId() {
        return paramsId;
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
        videoChildAdapter.setList(result);
        xrv_video_child.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<VideoListBean> result) {
        videoChildAdapter.addList(result);
        xrv_video_child.loadMoreComplete();
    }

    @Override
    public void collectSuccess() {
        videoChildP.videoList();
    }
}
