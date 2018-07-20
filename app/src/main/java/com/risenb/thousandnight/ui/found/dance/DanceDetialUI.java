package com.risenb.thousandnight.ui.found.dance;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.CommentAdapter;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.DanceHallBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class DanceDetialUI extends BaseUI implements DanceDetailP.DanceDetailFace, XRecyclerView.LoadingListener {

    @BindView(R.id.iv_dance_detail_icon)
    ImageView iv_dance_detail_icon;

    @BindView(R.id.tv_dance_detail_nickanme)
    TextView tv_dance_detail_nickanme;

    @BindView(R.id.ll_dance_detail_sex)
    LinearLayout ll_dance_detail_sex;

    @BindView(R.id.iv_dance_detail_sex)
    ImageView iv_dance_detail_sex;

    @BindView(R.id.tv_dance_detail_age)
    TextView tv_dance_detail_age;

    //关注
    @BindView(R.id.tv_dance_detail_attention)
    TextView tv_dance_detail_attention;

    @BindView(R.id.tv_dance_detail_title)
    TextView tv_dance_detail_title;

    @BindView(R.id.tv_dance_detail_addr)
    TextView tv_dance_detail_addr;

    @BindView(R.id.tv_dance_detail_distance)
    TextView tv_dance_detail_distance;

    @BindView(R.id.tv_dance_detail_time)
    TextView tv_dance_detail_time;

    @BindView(R.id.tv_dance_detail_partner)
    TextView tv_dance_detail_partner;

    @BindView(R.id.tv_dance_detail_partnernum)
    TextView tv_dance_detail_partnernum;

    @BindView(R.id.tv_dance_detail_type)
    TextView tv_dance_detail_type;

    @BindView(R.id.tv_dance_detail_grade)
    TextView tv_dance_detail_grade;

    @BindView(R.id.tv_dance_detail_desc)
    TextView tv_dance_detail_desc;

    @BindView(R.id.tv_dance_detail_look)
    TextView tv_dance_detail_look;

    @BindView(R.id.tv_dance_detail_message)
    TextView tv_dance_detail_message;

    @BindView(R.id.tv_dance_detail_zan)
    TextView tv_dance_detail_zan;

    @BindView(R.id.tv_dance_detail_publishtime)
    TextView tv_dance_detail_publishtime;

    @BindView(R.id.tv_comment_num)
    TextView tv_comment_num;

    @BindView(R.id.rv_course_comment)
    XRecyclerView rv_course_comment;

    @BindView(R.id.et_replay_content)
    EditText et_replay_content;

    private CommentAdapter<CommentBean> commentAdapter;
    private String danceHallId = "";

    private DanceDetailP danceDetailP;
    private int page = 1;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_dance_detial;
    }

    @Override
    protected void setControlBasis() {
        setTitle("舞伴详情");
        danceHallId = getIntent().getStringExtra("danceHallId");
        initAdapter();
        danceDetailP = new DanceDetailP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        danceDetailP.danceDetail();
        danceDetailP.commentList();
    }

    /**
     * 初始化适配器
     */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_course_comment.setLayoutManager(linearLayoutManager);
        commentAdapter = new CommentAdapter<>();
        commentAdapter.setActivity(getActivity());
        rv_course_comment.setAdapter(commentAdapter);
        rv_course_comment.setLoadingListener(this);
    }

    @Override
    public String getDanceHallId() {
        return danceHallId;
    }

    @Override
    public String getLongtitude() {
        return "";
    }

    @Override
    public String getLatitude() {
        return "";
    }

    @Override
    public void setResult(DanceHallBean result) {
        if (result != null) {
            Glide.with(getActivity()).load(result.getThumb()).transform(new GlideRoundTransform(getActivity()))
                    .placeholder(R.drawable.default_icon)
                    .error(R.drawable.default_icon)
                    .into(iv_dance_detail_icon);
            tv_dance_detail_nickanme.setText(result.getNickName());
            tv_dance_detail_age.setText(result.getAge());
            if ("0".equals(result.getGender())) {
                ll_dance_detail_sex.setBackgroundResource(R.drawable.sp_blue_bg_cor);
                iv_dance_detail_sex.setImageResource(R.drawable.found_boy);
            } else if ("1".equals(result.getGender())) {
                ll_dance_detail_sex.setBackgroundResource(R.drawable.sp_blue_bg_cor);
                iv_dance_detail_sex.setImageResource(R.drawable.found_boy);
            } else if ("2".equals(result.getGender())) {
                ll_dance_detail_sex.setBackgroundResource(R.drawable.sp_pink_bg_cor);
                iv_dance_detail_sex.setImageResource(R.drawable.found_girl);
            }
            if ("0".equals(result.getIsFocus())) {
                tv_dance_detail_attention.setText("关注");
            } else if ("1".equals(result.getIsFocus())) {
                tv_dance_detail_attention.setText("已关注");
            }
            tv_dance_detail_title.setText(result.getTitle());
            tv_dance_detail_addr.setText(result.getAddress());
            tv_dance_detail_distance.setText(result.getDistance());
            SimpleDateFormat format_begin = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
            tv_dance_detail_time.setText(format_begin.format(new Date(Long.parseLong(result.getBeginTime()))));
            if ("1".equals(result.getDancePartnerType())) {
                tv_dance_detail_partner.setText("男伴");
            } else if ("2".equals(result.getDancePartnerType())) {
                tv_dance_detail_partner.setText("女伴");
            } else if ("3".equals(result.getDancePartnerType())) {
                tv_dance_detail_partner.setText("男女伴");
            }
            tv_dance_detail_partnernum.setText(result.getPeopleNum() + " 位");
            tv_dance_detail_type.setText(result.getDancesFirstName() + " " + result.getDancesSecondName());
            tv_dance_detail_grade.setText(result.getLevelName());
            tv_dance_detail_desc.setText(result.getExplain());
            tv_dance_detail_look.setText(result.getViewNum());
            tv_dance_detail_message.setText(result.getCommentCount());
            tv_comment_num.setText("评论(" + result.getCommentCount() + ")");
            tv_dance_detail_zan.setText(result.getLikeNum());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            tv_dance_detail_publishtime.setText(format.format(new Date(Long.parseLong(result.getCreateTime()))));
        }
    }

    @Override
    public void onRefresh() {
        page = 1;
        danceDetailP.commentList();
    }

    @Override
    public void onLoadMore() {
        page++;
        danceDetailP.commentList();
    }

    @Override
    public int getPageNo() {
        return page;
    }

    @Override
    public String getPageSize() {
        return "15";
    }

    @Override
    public void setResule(ArrayList<CommentBean> result) {
        commentAdapter.setList(result);
        rv_course_comment.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<CommentBean> result) {
        commentAdapter.addList(result);
        rv_course_comment.loadMoreComplete();
    }

    @Override
    public String getCommentContent() {
        return et_replay_content.getText().toString().trim();
    }

    @OnClick(R.id.tv_replay_publish)
    void publish() {
        danceDetailP.addComment();
    }

    @Override
    public void commentSuccess() {
        makeText("发布成功");
        et_replay_content.setText("");
        danceDetailP.commentList();
    }

}
