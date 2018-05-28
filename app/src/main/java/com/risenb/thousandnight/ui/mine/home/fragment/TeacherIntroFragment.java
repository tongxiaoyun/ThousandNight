package com.risenb.thousandnight.ui.mine.home.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineTeacherIntroAdapter;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.mine.home.CourseListUI;
import com.risenb.thousandnight.views.MyRecyclerView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 教师简介
 * Created by user on 2018/5/28.
 */

public class TeacherIntroFragment extends BaseFragment {

    @BindView(R.id.mrv_teacher_intro)
    MyRecyclerView mrv_teacher_intro;

    @BindView(R.id.tfl_teacher_intro_feature)
    TagFlowLayout tfl_teacher_intro_feature;

    private MineTeacherIntroAdapter<Object> mineTeacherIntroAdapter;
    private List<String> features = new ArrayList<String>();

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_mine_teacher_intro, container, false);
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
        initTag();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mrv_teacher_intro.setLayoutManager(linearLayoutManager);
        mineTeacherIntroAdapter = new MineTeacherIntroAdapter<>();
        mineTeacherIntroAdapter.setActivity(getActivity());
        mrv_teacher_intro.setAdapter(mineTeacherIntroAdapter);
    }

    private void initTag() {
        features.add("科班出身");
        features.add("漂亮");
        features.add("活泼");
        tfl_teacher_intro_feature.setAdapter(new TagAdapter<String>(features) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv_hot_word = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_mine_personinfo,
                        tfl_teacher_intro_feature, false);
                tv_hot_word.setText(s);
                return tv_hot_word;
            }
        });
    }

    @OnClick(R.id.ll_teacher_intro_course)
    void course(){
        Intent intent = new Intent(getActivity(), CourseListUI.class);
        startActivity(intent);
    }

}
