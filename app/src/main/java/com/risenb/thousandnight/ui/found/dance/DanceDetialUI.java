package com.risenb.thousandnight.ui.found.dance;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CommentAdapter;
import com.risenb.thousandnight.adapter.CourseRecordAdapter;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class DanceDetialUI extends BaseUI {

    @BindView(R.id.rv_course_comment)
    RecyclerView rv_course_comment;
    private CommentAdapter<CommentBean> commentAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_dance_detial;
    }

    @Override
    protected void setControlBasis() {
        setTitle("舞伴详情");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {

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

}
