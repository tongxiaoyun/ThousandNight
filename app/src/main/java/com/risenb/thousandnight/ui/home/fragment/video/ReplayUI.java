package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CommentAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/26
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ReplayUI extends BaseUI {

    @BindView(R.id.xrv_replay)
    XRecyclerView xrv_replay;
    private CommentAdapter<Object> commentAdapter;

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
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_replay.setLayoutManager(linearLayoutManager);
        commentAdapter = new CommentAdapter<>();
        commentAdapter.setActivity(getActivity());
        xrv_replay.setAdapter(commentAdapter);

    }
}
