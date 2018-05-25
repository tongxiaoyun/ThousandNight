package com.risenb.thousandnight.ui.mine.course;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineCourseAdapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;

/**
 * 我的课程
 * Created by user on 2018/5/24.
 */

public class CourseUI extends BaseUI {

    @BindView(R.id.mrv_course)
    MyRecyclerView mrv_course;

    //已下课程将要过期
    @BindView(R.id.mrv_course_expiring)
    MyRecyclerView mrv_course_expiring;

    private MineCourseAdapter<Object> mineCourseAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_course;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我的课程");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_course.setLayoutManager(llm);
        mineCourseAdapter = new MineCourseAdapter<>();
        mineCourseAdapter.setActivity(this);
        mrv_course.setAdapter(mineCourseAdapter);

        LinearLayoutManager llm_expiring = new LinearLayoutManager(this);
        llm_expiring.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_course_expiring.setLayoutManager(llm_expiring);
        mineCourseAdapter = new MineCourseAdapter<>();
        mineCourseAdapter.setActivity(this);
        mrv_course_expiring.setAdapter(mineCourseAdapter);
    }

}
