package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CourseRecordAdapter;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.CourseDetialBean;
import com.risenb.thousandnight.beans.VideoBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import java.util.ArrayList;
import java.util.Date;

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
public class CourseIntroduceUI extends BaseUI implements CourseDetialP.CourseDetialFace {

    @BindView(R.id.rv_course_detial_record)
    RecyclerView rv_course_detial_record;

    @BindView(R.id.tv_course_detial_grade)
    TextView tv_course_detial_grade;


    @BindView(R.id.tv_course_detial_name)
    TextView tv_course_detial_name;

    @BindView(R.id.tv_course_detial_episode)
    TextView tv_course_detial_episode;


    @BindView(R.id.tv_course_detial_episode_watchAmount)
    TextView tv_course_detial_episode_watchAmount;

    @BindView(R.id.tv_course_detial_episode_coursePrice)
    TextView tv_course_detial_episode_coursePrice;

    @BindView(R.id.tv_course_detial_select)
    TextView tv_course_detial_select;

    @BindView(R.id.tv_couse_detial_introduce)
    TextView tv_couse_detial_introduce;

    private CourseRecordAdapter<VideoBean> courseRecordAdapter;
    private CourseDetialP courseDetialP;

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
        courseDetialP = new CourseDetialP(this, getActivity());
        courseDetialP.courseDetail();
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
    void toBuy() {
        Intent intent = new Intent(getActivity(), ConfirmPayUI.class);
        startActivity(intent);
    }

    @Override
    public String getCourseId() {
        return getIntent().getStringExtra("courseId");
    }

    @Override
    public void setCourse(CourseDetialBean result) {
        tv_course_detial_name.setText(result.getCourse().getCourseName());
        tv_couse_detial_introduce.setText(result.getCourse().getCourseIntroduce());

        tv_course_detial_grade.setText(result.getCourse().getParamName());
        tv_course_detial_episode.setText("共" + result.getCourse().getCourseEpisode() + "集");
        tv_course_detial_select.setText("共" + result.getCourse().getCourseEpisode() + "集");
        tv_course_detial_episode_watchAmount.setText(result.getCourse().getWatchAmount());
        tv_course_detial_episode_coursePrice.setText("¥ " + result.getCourse().getBuyAmount());
        courseRecordAdapter.setList(result.getCourseVideo());
    }

    @Override
    public int getPageNo() {
        return 0;
    }

    @Override
    public String getPageSize() {
        return "";
    }

    @Override
    public void setResule(ArrayList<CommentBean> result) {

    }

    @Override
    public void addResult(ArrayList<CommentBean> result) {

    }
}
