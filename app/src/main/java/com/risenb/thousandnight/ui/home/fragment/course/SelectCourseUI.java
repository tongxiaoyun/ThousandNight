package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.SelectCourseAdapter;
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
public class SelectCourseUI extends BaseUI {

    @BindView(R.id.rv_select_course)
    RecyclerView rv_select_course;


    @BindView(R.id.ll_select_course_menu)
    LinearLayout ll_select_course_menu;

    private SelectCourseAdapter<Object> selectCourseAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_select_course;
    }

    @Override
    protected void setControlBasis() {
        setTitle("选集");
        rightVisible("多选");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_select_course.setLayoutManager(linearLayoutManager);
        selectCourseAdapter = new SelectCourseAdapter<>();
        selectCourseAdapter.setActivity(getActivity());
        rv_select_course.setAdapter(selectCourseAdapter);
    }

    @OnClick(R.id.ll_right)
    void right(){
        if(ll_select_course_menu.getVisibility() == View.GONE){
            ll_select_course_menu.setVisibility(View.VISIBLE);
            selectCourseAdapter.setType(1);
            rightVisible("取消");
        }else{
            ll_select_course_menu.setVisibility(View.GONE);
            selectCourseAdapter.setType(0);
            rightVisible("多选");
        }
    }
}
