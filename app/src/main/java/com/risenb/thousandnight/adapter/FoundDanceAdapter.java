package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.text.TextUtils;
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
import com.risenb.thousandnight.beans.DanceHallBean;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/16.
 */

public class FoundDanceAdapter<T extends DanceHallBean> extends BaseRecyclerAdapter<T> {

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_found_dance, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.iv_dance_icon)
        ImageView iv_dance_icon;

        @BindView(R.id.tv_dance_nickname)
        TextView tv_dance_nickname;

        @BindView(R.id.ll_dance_sex)
        LinearLayout ll_dance_sex;

        @BindView(R.id.iv_dance_sex)
        ImageView iv_dance_sex;

        @BindView(R.id.tv_dance_age)
        TextView tv_dance_age;

        @BindView(R.id.tv_dance_title)
        TextView tv_dance_title;

        @BindView(R.id.tv_dance_type1)
        TextView tv_dance_type1;

        @BindView(R.id.tv_dance_type2)
        TextView tv_dance_type2;

        @BindView(R.id.tv_dance_grade)
        TextView tv_dance_grade;

        @BindView(R.id.tv_dance_addr)
        TextView tv_dance_addr;

        @BindView(R.id.tv_dance_distance)
        TextView tv_dance_distance;

        @BindView(R.id.tv_dance_begintime)
        TextView tv_dance_begintime;

        @BindView(R.id.tv_dance_partner_sex)
        TextView tv_dance_partner_sex;

        @BindView(R.id.tv_dance_partner_num)
        TextView tv_dance_partner_num;

        @BindView(R.id.tv_dance_desc)
        TextView tv_dance_desc;

        @BindView(R.id.tv_dance_look)
        TextView tv_dance_look;

        @BindView(R.id.tv_dance_comment)
        TextView tv_dance_comment;

        @BindView(R.id.tv_dance_zan)
        TextView tv_dance_zan;

        @BindView(R.id.tv_dance_createtime)
        TextView tv_dance_createtime;

        @Override
        protected void prepareData() {
            Glide.with(getActivity()).load(bean.getThumb()).transform(new GlideRoundTransform(getActivity()))
                    .placeholder(R.drawable.default_icon)
                    .error(R.drawable.default_icon)
                    .into(iv_dance_icon);
            tv_dance_nickname.setText(bean.getNickName());
            tv_dance_age.setText(bean.getAge());
            if ("0".equals(bean.getGender())) {
                ll_dance_sex.setBackgroundResource(R.drawable.sp_blue_bg_cor);
                iv_dance_sex.setImageResource(R.drawable.found_boy);
            } else if ("1".equals(bean.getGender())) {
                ll_dance_sex.setBackgroundResource(R.drawable.sp_blue_bg_cor);
                iv_dance_sex.setImageResource(R.drawable.found_boy);
            } else if ("2".equals(bean.getGender())) {
                ll_dance_sex.setBackgroundResource(R.drawable.sp_pink_bg_cor);
                iv_dance_sex.setImageResource(R.drawable.found_girl);
            }
            tv_dance_title.setText(bean.getTitle());
            if (!TextUtils.isEmpty(bean.getDancesFirstName())) {
                tv_dance_type1.setVisibility(View.VISIBLE);
                tv_dance_type1.setText(bean.getDancesFirstName());
            } else {
                tv_dance_type1.setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(bean.getDancesSecondName())) {
                tv_dance_type2.setVisibility(View.VISIBLE);
                tv_dance_type2.setText(bean.getDancesSecondName());
            } else {
                tv_dance_type2.setVisibility(View.GONE);
            }
            tv_dance_grade.setText(bean.getLevelName());
            tv_dance_addr.setText(bean.getAddress());
            tv_dance_distance.setText("0km");
            SimpleDateFormat format_begin = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
            tv_dance_begintime.setText(format_begin.format(new Date(new Long(bean.getBeginTime()))));
            if ("1".equals(bean.getDancePartnerType())) {
                tv_dance_partner_sex.setText("男伴");
            } else if ("2".equals(bean.getDancePartnerType())) {
                tv_dance_partner_sex.setText("女伴");
            } else if ("3".equals(bean.getDancePartnerType())) {
                tv_dance_partner_sex.setText("男女伴");
            }
            tv_dance_partner_num.setText("x" + bean.getPeopleNum());
            tv_dance_desc.setText(bean.getExplain());
            tv_dance_look.setText(bean.getViewNum());
            tv_dance_comment.setText(bean.getCommentCount());
            tv_dance_zan.setText(bean.getLikeNum());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            tv_dance_createtime.setText(format.format(new Date(new Long(bean.getCreateTime()))));
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
