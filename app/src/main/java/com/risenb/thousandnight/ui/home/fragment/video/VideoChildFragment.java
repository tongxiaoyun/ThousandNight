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
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 视频 全部
 * Created by user on 2018/5/10.
 */

public class VideoChildFragment extends BaseFragment {

    @BindView(R.id.xrv_video_child)
    XRecyclerView xrv_video_child;

    private VideoChildAdapter<Object> videoChildAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_video_child, container, false);
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
        xrv_video_child.setLayoutManager(linearLayoutManager);
        videoChildAdapter = new VideoChildAdapter<>();
        videoChildAdapter.setActivity(getActivity());
        xrv_video_child.setAdapter(videoChildAdapter);
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
    }

}
