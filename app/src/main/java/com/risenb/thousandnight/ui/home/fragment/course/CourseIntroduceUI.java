package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CourseRecordAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/25
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CourseIntroduceUI extends BaseUI {

    @BindView(R.id.rv_course_detial_record)
    RecyclerView rv_course_detial_record;
    private CourseRecordAdapter<Object> courseRecordAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_course_introduce;
    }

    @Override
    protected void setControlBasis() {
        setTitle("课程介绍");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        courseRecordAdapter = new CourseRecordAdapter<>();
        courseRecordAdapter.setActivity(getActivity());
        rv_course_detial_record.setLayoutManager(linearLayoutManager);
        rv_course_detial_record.setAdapter(courseRecordAdapter);
    }

    @OnClick(R.id.tv_course_introduce_buy)
    void toBuy(){
        Intent intent = new Intent(getActivity(), ConfirmPayUI.class);
        startActivity(intent);
    }
}
