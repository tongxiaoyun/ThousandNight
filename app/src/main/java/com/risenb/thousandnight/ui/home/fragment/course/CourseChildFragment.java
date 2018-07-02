package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CourseChildAdapter;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.ui.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 课程 全部
 * Created by user on 2018/5/10.
 */

public class CourseChildFragment extends BaseFragment implements CourseChildP.CourseFace, XRecyclerView.LoadingListener {

    @BindView(R.id.xrv_course_child)
    XRecyclerView xrv_course_child;

    private String paramsId = "";
    private CourseChildP courseChildP;

    private int pager = 1;

    public CourseChildFragment(String paramsId) {
        this.paramsId = paramsId;
    }

    private CourseChildAdapter<CourseListBean> courseChildAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_course_child, container, false);
    }

    @Override
    protected void setControlBasis() {
        courseChildP = new CourseChildP(this, getActivity());
        xrv_course_child.setLoadingListener(this);
        initAdapter();

    }

    @Override
    protected void prepareData() {
        courseChildP.classifyList();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_course_child.setLayoutManager(linearLayoutManager);
        courseChildAdapter = new CourseChildAdapter<>();
        courseChildAdapter.setActivity(getActivity());
        xrv_course_child.setAdapter(courseChildAdapter);
        courseChildAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), CourseDetialUI.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public String getParamId() {
        return paramsId;
    }

    @Override
    public String getTeacherId() {
        return "";
    }

    @Override
    public String getOrderField() {
        return "";
    }

    @Override
    public String getOrderDirection() {
        return "";
    }

    @Override
    public int getPageNo() {
        return pager;
    }

    @Override
    public String getPageSize() {
        return "10";
    }

    @Override
    public void setList(ArrayList<CourseListBean> result) {
        xrv_course_child.refreshComplete();
        courseChildAdapter.setList(result);

    }

    @Override
    public void addList(ArrayList<CourseListBean> result) {
        xrv_course_child.loadMoreComplete();
        courseChildAdapter.addList(result);
    }

    @Override
    public void onRefresh() {
        pager = 1;
        courseChildP.classifyList();
    }

    @Override
    public void onLoadMore() {
        pager++;
        courseChildP.classifyList();
    }
}
