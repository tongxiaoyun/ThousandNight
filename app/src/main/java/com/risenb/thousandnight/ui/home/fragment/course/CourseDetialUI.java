package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CommentAdapter;
import com.risenb.thousandnight.adapter.CourseRecordAdapter;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.CourseDetialBean;
import com.risenb.thousandnight.beans.VideoBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.utils.GlideRoundTransform;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CourseDetialUI extends BaseUI implements CourseDetialP.CourseDetialFace {


    @BindView(R.id.rv_course_detial_record)
    RecyclerView rv_course_detial_record;

    @BindView(R.id.rv_course_comment)
    RecyclerView rv_course_comment;


    @BindView(R.id.tv_couse_detial_name)
    TextView tv_couse_detial_name;

    @BindView(R.id.tv_couse_detial_introduce)
    TextView tv_couse_detial_introduce;


    @BindView(R.id.tv_couse_detial_price)
    TextView tv_couse_detial_price;

    @BindView(R.id.tv_couse_detial_time)
    TextView tv_couse_detial_time;

    @BindView(R.id.tv_course_detial_grade)
    TextView tv_course_detial_grade;


    @BindView(R.id.tv_course_detial_name2)
    TextView tv_course_detial_name2;

    @BindView(R.id.tv_course_detial_episode)
    TextView tv_course_detial_episode;

    @BindView(R.id.tv_course_detial_episode_watchAmount)
    TextView tv_course_detial_episode_watchAmount;

    @BindView(R.id.tv_course_detial_episode_coursePrice)
    TextView tv_course_detial_episode_coursePrice;

    @BindView(R.id.tv_course_detial_select)
    TextView tv_course_detial_select;

    @BindView(R.id.iv_teacher_cover)
    ImageView iv_teacher_cover;

    @BindView(R.id.tv_teacher_name)
    TextView tv_teacher_name;

    @BindView(R.id.tv_teacher_video_count)
    TextView tv_teacher_video_count;


    @BindView(R.id.tv_teacher_video_rate)
    TextView tv_teacher_video_rate;

    @BindView(R.id.iv_cover)
    ImageView iv_cover;

    private CourseRecordAdapter<VideoBean> courseRecordAdapter;
    private CommentAdapter<CommentBean> commentAdapter;
    private CourseDetialP courseDetialP;
    private SimpleDateFormat sdf;

    @Override

    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_course_detial;
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    protected void prepareData() {
        courseDetialP = new CourseDetialP(this, getActivity());
        courseDetialP.courseDetail();
        courseDetialP.commentList();
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        courseRecordAdapter = new CourseRecordAdapter<>();
        courseRecordAdapter.setActivity(getActivity());
        rv_course_detial_record.setLayoutManager(linearLayoutManager);
        rv_course_detial_record.setAdapter(courseRecordAdapter);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        rv_course_comment.setLayoutManager(linearLayoutManager2);
        commentAdapter = new CommentAdapter<>();
        commentAdapter.setActivity(getActivity());
        rv_course_comment.setAdapter(commentAdapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @OnClick(R.id.ll_course_detial_introduce)
    void toIntroduce() {
        Intent intent = new Intent(getActivity(), CourseIntroduceUI.class);
        intent.putExtra("courseId", getCourseId());
        startActivity(intent);
    }


    @OnClick(R.id.tv_course_detial_buy)
    void toBuy() {
        Intent intent = new Intent(getActivity(), ConfirmPayUI.class);
        startActivity(intent);
    }


    @OnClick(R.id.tv_course_detial_down)
    void toDown() {
        Intent intent = new Intent(getActivity(), SelectCourseUI.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_course_detial_select)
    void toSelect() {
        Intent intent = new Intent(getActivity(), SelectCourseUI.class);
        startActivity(intent);
    }

    @Override
    public String getCourseId() {
        return getIntent().getStringExtra("courseId");
    }

    @Override
    public void setCourse(CourseDetialBean result) {
        tv_couse_detial_name.setText(result.getCourse().getCourseName());
        tv_couse_detial_introduce.setText(result.getCourse().getCourseIntroduce());
        tv_couse_detial_price.setText("¥ " + result.getCourse().getCoursePrice());
        if (!TextUtils.isEmpty(result.getCourse().getCreateTime()))
            tv_couse_detial_time.setText("发布时间：" + sdf.format(new Date(Long.parseLong(result.getCourse().getCreateTime()))));
        else
            tv_couse_detial_time.setText("发布时间：" + sdf.format(new Date(System.currentTimeMillis())));
        tv_course_detial_grade.setText(result.getCourse().getParamName());
        tv_course_detial_name2.setText(result.getCourse().getCourseName());
        tv_course_detial_episode.setText("共" + result.getCourse().getCourseEpisode() + "集");
        tv_course_detial_select.setText("共" + result.getCourse().getCourseEpisode() + "集");
        tv_course_detial_episode_watchAmount.setText(result.getCourse().getWatchAmount());
        tv_course_detial_episode_coursePrice.setText("¥ " + result.getCourse().getBuyAmount());
        courseRecordAdapter.setList(result.getCourseVideo());

        if (result.getTeacherList().size() > 0) {
            Glide.with(getActivity()).load(result.getTeacherList().get(0).getThumb()).transform(new GlideRoundTransform(getActivity())).error(R.drawable.default_icon).into(iv_teacher_cover);
            tv_teacher_name.setText(TextUtils.isEmpty(result.getTeacherList().get(0).getName()) ? "无名" : result.getTeacherList().get(0).getName());
            tv_teacher_video_count.setText("共" + result.getTeacherList().get(0).getVideoCount() + "节课");
            tv_teacher_video_rate.setText(result.getTeacherList().get(0).getPraiseRate() + "%");
        }
        Glide.with(getActivity()).load(result.getCourse().getCourseCover()).error(R.drawable.default_img).into(iv_cover);


    }

    @Override
    public int getPageNo() {
        return 1;
    }

    @Override
    public String getPageSize() {
        return "3";
    }

    @Override
    public void setResule(ArrayList<CommentBean> result) {
        commentAdapter.setList(result);
    }

    @Override
    public void addResult(ArrayList<CommentBean> result) {

    }
}
