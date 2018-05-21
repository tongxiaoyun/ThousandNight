package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CourseChildAdapter;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 课程 全部
 * Created by user on 2018/5/10.
 */

public class CourseChildFragment extends BaseFragment {

    @BindView(R.id.xrv_course_child)
    XRecyclerView xrv_course_child;

    private CourseChildAdapter<Object> courseChildAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_course_child, container, false);
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
        xrv_course_child.setLayoutManager(linearLayoutManager);
        courseChildAdapter = new CourseChildAdapter<>();
        courseChildAdapter.setActivity(getActivity());
        xrv_course_child.setAdapter(courseChildAdapter);
    }
}
