package com.risenb.thousandnight.ui.mine.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CourseChildAdapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.home.fragment.course.CourseDetialUI;

import butterknife.BindView;

/**
 * 教师的课程
 * Created by user on 2018/5/28.
 */

public class CourseListUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private CourseChildAdapter<Object> courseChildAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_common;
    }

    @Override
    protected void setControlBasis() {
        setTitle("谁谁谁的课程");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        courseChildAdapter = new CourseChildAdapter<>();
        courseChildAdapter.setActivity(getActivity());
        xrv_common.setAdapter(courseChildAdapter);
        courseChildAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), CourseDetialUI.class);
                startActivity(intent);
            }
        });
    }
}
