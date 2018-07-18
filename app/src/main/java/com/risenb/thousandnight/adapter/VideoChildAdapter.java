package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.ui.home.fragment.video.ReplayUI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/10.
 */

public class VideoChildAdapter<T extends VideoListBean> extends BaseRecyclerAdapter<T> {

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video_child, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        @BindView(R.id.rl_video_message)
        RelativeLayout rl_video_message;

        @BindView(R.id.iv_video_img)
        ImageView iv_video_img;

        @BindView(R.id.iv_video_play)
        ImageView iv_video_play;

        @BindView(R.id.tv_video_des)
        TextView tv_video_des;

        @BindView(R.id.iv_video_icon)
        ImageView iv_video_icon;

        @BindView(R.id.tv_video_nickname)
        TextView tv_video_nickname;

        @BindView(R.id.tv_video_message)
        TextView tv_video_message;

        @BindView(R.id.iv_video_collect)
        ImageView iv_video_collect;

        @BindView(R.id.iv_video_download)
        ImageView iv_video_download;

        @BindView(R.id.iv_video_share)
        ImageView iv_video_share;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void prepareData() {
            Glide.with(getActivity()).load(bean.getCover()).placeholder(R.drawable.default_img).error(R.drawable.default_img).into(iv_video_img);
            tv_video_des.setText(bean.getName());
            Glide.with(getActivity()).load("").placeholder(R.drawable.default_icon).error(R.drawable.default_icon).into(iv_video_icon);
            tv_video_nickname.setText("");
            tv_video_message.setText(bean.getCommentNum());
            if ("0".equals(bean.getIsLike())) {
                iv_video_collect.setImageResource(R.drawable.home_video_collect);
            } else if ("1".equals(bean.getIsLike())) {
                iv_video_collect.setImageResource(R.drawable.home_video_collected);
            }
            iv_video_collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemCollectClickListener != null) {
                        onItemCollectClickListener.onItemCollectClick(position);
                    }
                }
            });

            rl_video_message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), ReplayUI.class);
                    intent.putExtra("videoId", bean.getVideoId());
                    getActivity().startActivity(intent);
                }
            });

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

    public interface OnItemCollectClickListener {
        void onItemCollectClick(int position);
    }

    private OnItemCollectClickListener onItemCollectClickListener;

    public void setOnItemCollectClickListener(OnItemCollectClickListener onItemCollectClickListener) {
        this.onItemCollectClickListener = onItemCollectClickListener;
    }

}
