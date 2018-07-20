package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/16.
 */

public class FoundRecruitAdapter<T extends PositonBean> extends BaseRecyclerAdapter<T> {

    private String ui;

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_found_recruit, null));
    }

    public void setUI(String ui) {
        this.ui = ui;
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_recruit_user)
        LinearLayout ll_recruit_user;

        @BindView(R.id.v_line)
        View v_line;

        @BindView(R.id.ll_recruit_person_num)
        LinearLayout ll_recruit_person_num;

        @BindView(R.id.tv_recruit_name)
        TextView tv_recruit_name;

        @BindView(R.id.tv_recruit_salary)
        TextView tv_recruit_salary;

        @BindView(R.id.tv_recruit_desc)
        TextView tv_recruit_desc;

        @BindView(R.id.tv_recruit_addr)
        TextView tv_recruit_addr;

        @BindView(R.id.tv_recruit_years)
        TextView tv_recruit_years;

        @BindView(R.id.tv_recruit_grade)
        TextView tv_recruit_grade;

        @BindView(R.id.iv_recruit_icon)
        ImageView iv_recruit_icon;

        @BindView(R.id.tv_recruit_nickname)
        TextView tv_recruit_nickname;

        @BindView(R.id.iv_recruit_level)
        ImageView iv_recruit_level;

        @BindView(R.id.tv_recruit_person_num)
        TextView tv_recruit_person_num;

        @Override
        protected void prepareData() {
            if ("发现".equals(ui)) {
                ll_recruit_user.setVisibility(View.VISIBLE);
                v_line.setVisibility(View.VISIBLE);
                ll_recruit_person_num.setVisibility(View.GONE);
            } else if ("招聘".equals(ui)) {
                ll_recruit_user.setVisibility(View.GONE);
                v_line.setVisibility(View.GONE);
                ll_recruit_person_num.setVisibility(View.VISIBLE);
            } else if ("投递".equals(ui)) {
                ll_recruit_user.setVisibility(View.GONE);
                v_line.setVisibility(View.GONE);
                ll_recruit_person_num.setVisibility(View.INVISIBLE);
            }
            tv_recruit_name.setText(bean.getPositionName());
            //1 范围  2 面议
            if ("1".equals(bean.getSalaryType())) {
                tv_recruit_salary.setText(bean.getSalaryBegin() + "-" + bean.getSalaryEnd());
            } else if ("2".equals(bean.getSalaryType())) {
                tv_recruit_salary.setText("面议");
            }
            tv_recruit_desc.setText(bean.getPositionDesc());
            tv_recruit_addr.setText(bean.getProvinceName() + " " + bean.getCityName() + " " + bean.getAreaName());
            tv_recruit_years.setText(bean.getYearsName());
            tv_recruit_grade.setText(bean.getGradeName());
            tv_recruit_nickname.setText(bean.getNickName());
            Glide.with(getActivity()).load(bean.getThumb()).transform(new GlideRoundTransform(getActivity()))
                    .placeholder(R.drawable.default_icon)
                    .error(R.drawable.default_icon)
                    .into(iv_recruit_icon);

        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {

        }

        @Override
        protected void initFoot(BaseFootBean baseFootBean) {

        }

        @Override
        protected void reflectionView(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
