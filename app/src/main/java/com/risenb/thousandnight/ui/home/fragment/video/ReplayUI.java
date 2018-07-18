package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CommentAdapter;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.ui.BaseUI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/26
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ReplayUI extends BaseUI implements XRecyclerView.LoadingListener, ReplayP.ReplayFace {

    @BindView(R.id.xrv_replay)
    XRecyclerView xrv_replay;

    @BindView(R.id.et_replay_content)
    EditText et_replay_content;

    private CommentAdapter<CommentBean> commentAdapter;
    private int page = 1;
    private String videoId = "";

    private ReplayP replayP;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_replay;
    }

    @Override
    protected void setControlBasis() {
        setTitle("评论");
        videoId = getIntent().getStringExtra("videoId");
        initAdapter();
        replayP = new ReplayP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        replayP.commentList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_replay.setLayoutManager(linearLayoutManager);
        commentAdapter = new CommentAdapter<>();
        commentAdapter.setActivity(getActivity());
        xrv_replay.setAdapter(commentAdapter);
        xrv_replay.setLoadingListener(this);

    }

    @Override
    public void onRefresh() {
        page = 1;
        replayP.commentList();
    }

    @Override
    public void onLoadMore() {
        page++;
        replayP.commentList();
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
    public String getVideoId() {
        return videoId;
    }

    @Override
    public void setResule(ArrayList<CommentBean> result) {
        commentAdapter.setList(result);
        xrv_replay.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<CommentBean> result) {
        commentAdapter.addList(result);
        xrv_replay.loadMoreComplete();
    }

    @Override
    public String getCommentContent() {
        return et_replay_content.getText().toString().trim();
    }

    @OnClick(R.id.tv_replay_publish)
    void publish() {
        replayP.addComment();
    }

    @Override
    public void commentSuccess() {
        makeText("发布成功");
        et_replay_content.setText("");
        replayP.commentList();
    }
}
