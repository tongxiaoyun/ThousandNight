package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/7/20.
 */

public class FoundDanceCommentAdapter<T extends CommentBean> extends BaseRecyclerAdapter<T> {

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseViewHolder<T> {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.iv_comment_icon)
        ImageView iv_comment_icon;

        @BindView(R.id.tv_comment_nickname)
        TextView tv_comment_nickname;

        @BindView(R.id.tv_comment_time)
        TextView tv_comment_time;

        @BindView(R.id.tv_comment_content)
        TextView tv_comment_content;

        @Override
        protected void prepareData() {
            Glide.with(getActivity()).load(bean.getThumb()).transform(new GlideRoundTransform(getActivity())).placeholder(R.drawable.default_icon).error(R.drawable.default_icon).into(iv_comment_icon);
            tv_comment_nickname.setText(bean.getNickName());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tv_comment_time.setText(format.format(new Date(Long.parseLong(bean.getCreateTime()))));
            tv_comment_content.setText(bean.getContent());
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
