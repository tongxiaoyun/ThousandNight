package com.risenb.thousandnight.ui.mine.recruit;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.found.recruit.RecruitPostUI;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 投递详情
 * Created by user on 2018/5/24.
 */

public class DeliverDetailUI extends BaseUI implements DeliverDetailP.DeliverDetailFace {

    @BindView(R.id.tv_recruit_detail_name)
    TextView tv_recruit_detail_name;

    @BindView(R.id.tv_recruit_detail_type)
    TextView tv_recruit_detail_type;

    @BindView(R.id.tv_recruit_detail_salary)
    TextView tv_recruit_detail_salary;

    @BindView(R.id.tv_recruit_detail_addr)
    TextView tv_recruit_detail_addr;

    @BindView(R.id.tv_recruit_detail_years)
    TextView tv_recruit_detail_years;

    @BindView(R.id.tv_recruit_detail_grade)
    TextView tv_recruit_detail_grade;

    @BindView(R.id.iv_recruit_detail_icon)
    ImageView iv_recruit_detail_icon;

    @BindView(R.id.tv_recruit_detail_nickname)
    TextView tv_recruit_detail_nickname;

    @BindView(R.id.iv_recruit_detail_level)
    ImageView iv_recruit_detail_level;

    @BindView(R.id.tv_recruit_detail_desc)
    TextView tv_recruit_detail_desc;

    @BindView(R.id.ll_recruit_detail_apply)
    LinearLayout ll_recruit_detail_apply;

    private String ui = "";
    private String positionId = "";

    private DeliverDetailP deliverDetailP;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_deliver_detail;
    }

    @Override
    protected void setControlBasis() {
        setTitle(getIntent().getStringExtra("positionName"));
        ui = getIntent().getStringExtra("ui");
        positionId = getIntent().getStringExtra("positionId");
        if ("found".equals(ui)) {
            ll_recruit_detail_apply.setVisibility(View.GONE);
        } else {
            ll_recruit_detail_apply.setVisibility(View.VISIBLE);
        }
        deliverDetailP = new DeliverDetailP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        deliverDetailP.positionDetail();
    }

    @OnClick(R.id.tv_deliver_detial_post)
    void toPost() {
        Intent intent = new Intent(getActivity(), RecruitPostUI.class);
        intent.putExtra("positionId", positionId);
        startActivity(intent);
    }

    /**
     * 立即沟通
     */
    @OnClick(R.id.tv_deliver_detial_message)
    void toMessage() {
    }

    @Override
    public String getPositionId() {
        return positionId;
    }

    @Override
    public void setResult(PositonBean result) {
        if (result != null) {
            tv_recruit_detail_name.setText(result.getPositionName());
            tv_recruit_detail_type.setText(result.getTypeName());
            if ("1".equals(result.getSalaryType())) {
                tv_recruit_detail_salary.setText(result.getSalaryBegin() + "-" + result.getSalaryEnd());
            } else if ("2".equals(result.getSalaryType())) {
                tv_recruit_detail_salary.setText("面议");
            }
            tv_recruit_detail_addr.setText(result.getProvinceName() + " " + result.getCityName() + " " + result.getAreaName());
            tv_recruit_detail_years.setText(result.getYearsName());
            tv_recruit_detail_grade.setText(result.getGradeName());
            Glide.with(this).load(result.getThumb()).transform(new GlideRoundTransform(this))
                    .placeholder(R.drawable.default_icon)
                    .error(R.drawable.default_icon)
                    .into(iv_recruit_detail_icon);
            tv_recruit_detail_nickname.setText(result.getNickName());
            tv_recruit_detail_desc.setText(result.getPositionDesc());

        }
    }
}
