package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CommentAdapter;
import com.risenb.thousandnight.adapter.CourseRecordAdapter;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CourseDetialUI extends BaseUI {

    /**
     * 视频播放器
     */
    @BindView(R.id.video_view)
    TXCloudVideoView video_view;


    @BindView(R.id.rv_course_detial_record)
    RecyclerView rv_course_detial_record;

    @BindView(R.id.rv_course_comment)
    RecyclerView rv_course_comment;

    private TXVodPlayer mVodPlayer;
    private CourseRecordAdapter<Object> courseRecordAdapter;
    private CommentAdapter<CommentBean> commentAdapter;

    @Override

    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_course_detial;
    }

    @Override
    protected void setControlBasis() {
        initPlayer();
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        courseRecordAdapter = new CourseRecordAdapter<>();
        courseRecordAdapter.setActivity(getActivity());
        rv_course_detial_record.setLayoutManager(linearLayoutManager);
        rv_course_detial_record.setAdapter(courseRecordAdapter);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        rv_course_comment.setLayoutManager(linearLayoutManager2);
        commentAdapter = new CommentAdapter<>();
        commentAdapter.setActivity(getActivity());
        rv_course_comment.setAdapter(commentAdapter);
    }

    /**
     * 初始化视频播放器
     */
    private void initPlayer() {
        //创建player对象
        mVodPlayer = new TXVodPlayer(getActivity());
        //关键player对象与界面view
        mVodPlayer.setPlayerView(video_view);
        video_view.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN);
        mVodPlayer.setAutoPlay(false);
        mVodPlayer.startPlay("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4");
        mVodPlayer.resume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mVodPlayer.stopPlay(true); // true代表清除最后一帧画面
        video_view.onDestroy();
    }


    @OnClick(R.id.ll_course_detial_introduce)
    void toIntroduce() {
        Intent intent = new Intent(getActivity(), CourseIntroduceUI.class);
        startActivity(intent);
    }


    @OnClick(R.id.tv_course_detial_buy)
    void toBuy() {
        Intent intent = new Intent(getActivity(), ConfirmPayUI.class);
        startActivity(intent);
    }


    @OnClick(R.id.tv_course_detial_down)
    void toDown() {
        Intent intent = new Intent(getActivity(), SelectCourseUI.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_course_detial_select)
    void toSelect() {
        Intent intent = new Intent(getActivity(), SelectCourseUI.class);
        startActivity(intent);
    }

}
