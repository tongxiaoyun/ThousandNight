package com.risenb.thousandnight.ui.home.lookrecord.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeCourseRecordAdapter;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 课程记录
 * Created by user on 2018/5/17.
 */

public class CourseFragment extends BaseFragment {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private HomeCourseRecordAdapter<Object> homeCourseRecordAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
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
        xrv_common.setLayoutManager(linearLayoutManager);
        homeCourseRecordAdapter = new HomeCourseRecordAdapter<>();
        homeCourseRecordAdapter.setActivity(getActivity());
        xrv_common.setAdapter(homeCourseRecordAdapter);
    }

}
