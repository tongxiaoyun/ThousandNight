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
import com.risenb.thousandnight.beans.AlbumBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/15.
 */

public class FoundAlbumAdapter<T extends AlbumBean> extends BaseRecyclerAdapter {

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_found_album, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.iv_album_img)
        ImageView iv_album_img;

        @BindView(R.id.tv_album_title)
        TextView tv_album_title;

        @BindView(R.id.tv_album_time)
        TextView tv_album_time;

        @BindView(R.id.tv_album_picno)
        TextView tv_album_picno;

        @BindView(R.id.tv_album_look)
        TextView tv_album_look;

        @BindView(R.id.tv_album_share)
        TextView tv_album_share;

        @Override
        protected void prepareData() {
            Glide.with(getActivity()).load(bean.getImg()).placeholder(R.drawable.default_img).error(R.drawable.default_img).into(iv_album_img);
            tv_album_title.setText(bean.getTitle());
            tv_album_time.setText(bean.getCreateTimeStr());
            tv_album_picno.setText(bean.getPicNo());
            tv_album_look.setText(bean.getViewCount());
            tv_album_share.setText(bean.getShareNo());
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
