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
 * Created by user on 2018/5/7.
 */

public class HomeCourseAdapter<T extends CourseListBean> extends BaseRecyclerAdapter {


    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_course, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        @BindView(R.id.iv_home_course_cover)
        ImageView iv_home_course_cover;

        @BindView(R.id.iv_home_course_playcount)
        TextView iv_home_course_playcount;

        @BindView(R.id.iv_home_course_name)
        TextView iv_home_course_name;

        @BindView(R.id.iv_home_course_count)
        TextView iv_home_course_count;

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
                    .into(iv_home_course_cover);

            iv_home_course_playcount.setText(bean.getWatchAmount() + "次");
            iv_home_course_name.setText(bean.getCourseName());
            iv_home_course_count.setText("共" + bean.getCourseEpisode() + "集");
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
