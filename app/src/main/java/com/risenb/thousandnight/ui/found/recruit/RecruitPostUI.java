package com.risenb.thousandnight.ui.found.recruit;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.mine.recruit.DeliverDetailP;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import java.io.File;

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
public class RecruitPostUI extends BaseUI implements DeliverDetailP.DeliverDetailFace, RecruitPostP.RecruitPostFace {

    @BindView(R.id.tv_recruit_post_name)
    TextView tv_recruit_post_name;

    @BindView(R.id.tv_recruit_post_type)
    TextView tv_recruit_post_type;

    @BindView(R.id.tv_recruit_post_salary)
    TextView tv_recruit_post_salary;

    @BindView(R.id.tv_recruit_post_desc)
    TextView tv_recruit_post_desc;

    @BindView(R.id.tv_recruit_post_addr)
    TextView tv_recruit_post_addr;

    @BindView(R.id.tv_recruit_post_years)
    TextView tv_recruit_post_years;

    @BindView(R.id.tv_recruit_post_grade)
    TextView tv_recruit_post_grade;

    @BindView(R.id.et_recruit_post_info)
    EditText et_recruit_post_info;

    //上传视频
    @BindView(R.id.rl_recruit_post_novideo)
    RelativeLayout rl_recruit_post_novideo;

    @BindView(R.id.rl_recruit_post_video)
    RelativeLayout rl_recruit_post_video;

    //视频第一帧
    @BindView(R.id.iv_recruit_post_video)
    ImageView iv_recruit_post_video;

    private String positionId = "";

    private DeliverDetailP deliverDetailP;
    private RecruitPostP recruitPostP;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_post_recruit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("求职投递");
        positionId = getIntent().getStringExtra("positionId");
        deliverDetailP = new DeliverDetailP(this, getActivity());
        recruitPostP = new RecruitPostP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        deliverDetailP.positionDetail();
    }

    @Override
    public String getPositionId() {
        return positionId;
    }

    @Override
    public String getDeliveryInfo() {
        return et_recruit_post_info.getText().toString().trim();
    }

    @Override
    public File getVideo() {
        return null;
    }

    @Override
    public void setResult(PositonBean result) {
        if (result != null) {
            tv_recruit_post_name.setText(result.getPositionName());
            tv_recruit_post_type.setText(result.getTypeName());
            if ("1".equals(result.getSalaryType())) {
                tv_recruit_post_salary.setText(result.getSalaryBegin() + "-" + result.getSalaryEnd());
            } else if ("2".equals(result.getSalaryType())) {
                tv_recruit_post_salary.setText("面议");
            }
            tv_recruit_post_desc.setText(result.getPositionDesc());
            tv_recruit_post_addr.setText(result.getProvinceName() + " " + result.getCityName() + " " + result.getAreaName());
            tv_recruit_post_years.setText(result.getYearsName());
            tv_recruit_post_grade.setText(result.getGradeName());
        }
    }

    @OnClick(R.id.rl_recruit_post_novideo)
    void uploadVideo() {

    }

    @OnClick(R.id.tv_recruit_post_post)
    void post() {
        recruitPostP.addPositoinDelivery();
    }

    @Override
    public void postSuccess() {
        finish();
    }

}
