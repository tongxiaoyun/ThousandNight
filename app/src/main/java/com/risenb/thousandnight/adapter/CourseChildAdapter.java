package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.CourseListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/10.
 */

public class CourseChildAdapter<T extends CourseListBean> extends BaseRecyclerAdapter {


    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_course_child, null));
    }


    class ViewHolder extends BaseViewHolder<T> {

        @BindView(R.id.iv_course_cover)
        ImageView iv_course_cover;

        @BindView(R.id.tv_course_name)
        TextView tv_course_name;

        @BindView(R.id.tv_course_price)
        TextView tv_course_price;

        @BindView(R.id.tv_course_episode)
        TextView tv_course_episode;

        @BindView(R.id.tv_course_buy)
        TextView tv_course_buy;


        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void prepareData() {
            Glide.with(getActivity())
                    .load(bean.getCourseCover())
                    .error(R.drawable.default_img)
                    .placeholder(R.drawable.default_img)
                    .dontAnimate()
                    .into(iv_course_cover);

            tv_course_name.setText(bean.getCourseName());
            tv_course_price.setText("¥" + bean.getCoursePrice());
            tv_course_episode.setText("共" + bean.getCourseEpisode() + "集");
            tv_course_buy.setText(bean.getBuyAmount() + "购买");

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
