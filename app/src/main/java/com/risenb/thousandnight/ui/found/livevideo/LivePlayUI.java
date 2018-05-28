package com.risenb.thousandnight.ui.found.livevideo;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.LiveAudienceAdapter;
import com.risenb.thousandnight.adapter.LiveCommentAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class LivePlayUI extends BaseUI {

    @BindView(R.id.rv_live_play_audience)
    RecyclerView rv_live_play_audience;


    @BindView(R.id.rv_live_play_comment)
    RecyclerView rv_live_play_comment;
    private LiveAudienceAdapter<Object> liveAudienceAdapter;
    private LiveCommentAdapter<Object> liveCommentAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_live_play;
    }

    @Override
    protected void setControlBasis() {
        setSwipeBackEnable(false);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        liveAudienceAdapter = new LiveAudienceAdapter<>();
        liveAudienceAdapter.setActivity(getActivity());
        rv_live_play_audience.setLayoutManager(linearLayoutManager);
        rv_live_play_audience.setAdapter(liveAudienceAdapter);


        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        liveCommentAdapter = new LiveCommentAdapter<>();
        liveCommentAdapter.setActivity(getActivity());
        rv_live_play_comment.setLayoutManager(linearLayoutManager2);
        rv_live_play_comment.setAdapter(liveCommentAdapter);

    }


    @OnClick(R.id.tv_live_play_exit)
    void liveExit() {
        finish();
    }
}
