package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.utils.DisplayUtil;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.VideoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2017/3/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CourseRecordAdapter<T extends VideoBean> extends BaseRecyclerAdapter<T> {

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course_record, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(DisplayUtil.getDimen(context, R.dimen.dm270), ViewGroup.LayoutParams.MATCH_PARENT));
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseViewHolder<T> {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        //
        @BindView(R.id.iv_cover)
        ImageView iv_cover;
        @BindView(R.id.tv_name)
        TextView tv_name;


        @Override
        protected void prepareData() {
            tv_name.setText(bean.getVideoName());

            Glide.with(getActivity()).load(bean.getThumb()).error(R.drawable.default_img).into(iv_cover);
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
