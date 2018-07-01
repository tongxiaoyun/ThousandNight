package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.VideoListBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/7.
 */

public class HomeVideoAdapter<T extends VideoListBean> extends BaseRecyclerAdapter {


    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_video, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        @BindView(R.id.iv_video_cover)
        ImageView iv_video_cover;

        @BindView(R.id.tv_video_title)
        TextView tv_video_title;

        @BindView(R.id.tv_video_viewNum)
        TextView tv_video_viewNum;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void prepareData() {
            Glide.with(getActivity()).load(bean.getCover())
                    .centerCrop()
                    .error(R.drawable.default_img)
                    .placeholder(R.drawable.default_img)
                    .dontAnimate()
                    .into(iv_video_cover);

            tv_video_title.setText(bean.getName());
            tv_video_viewNum.setText(bean.getViewNum() +"人");
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
