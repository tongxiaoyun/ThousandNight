package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeCourseAdapter;
import com.risenb.thousandnight.adapter.HomeMusicAdapter;
import com.risenb.thousandnight.adapter.HomeVideoAdapter;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/21
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ChoiceCourseUI extends BaseUI {

    @BindView(R.id.xrv_choice_course)
    XRecyclerView xrv_choice_course;
    private HomeCourseAdapter<CourseListBean> choiceCourseAdapter;


    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_choice_course;
    }

    @Override
    protected void setControlBasis() {
        setTitle("精选课程");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        //精选课程
        GridLayoutManager glm_course = new GridLayoutManager(getActivity(), 2);
        xrv_choice_course.setLayoutManager(glm_course);
        choiceCourseAdapter = new HomeCourseAdapter<>();
        choiceCourseAdapter.setActivity(getActivity());
        xrv_choice_course.setAdapter(choiceCourseAdapter);
    }
}
