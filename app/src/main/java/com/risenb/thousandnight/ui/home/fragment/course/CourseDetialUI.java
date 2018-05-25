package com.risenb.thousandnight.ui.home.fragment.course;

import android.net.Uri;
import android.os.Bundle;


import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

import butterknife.BindView;

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
    private TXVodPlayer mVodPlayer;

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
    }

    @Override
    protected void prepareData() {

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


}
