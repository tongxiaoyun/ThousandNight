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
import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/7.
 */

public class HomeMusicAdapter<T extends MusicSheetBean> extends BaseRecyclerAdapter {


    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_music, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        @BindView(R.id.iv_home_music_cover)
        ImageView iv_home_music_cover;

        @BindView(R.id.tv_home_music_play_count)
        TextView tv_home_music_play_count;
        @BindView(R.id.tv_home_music_sheet_name)
        TextView tv_home_music_sheet_name;
        @BindView(R.id.tv_home_music_singer)
        TextView tv_home_music_singer;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void prepareData() {
            Glide.with(getActivity())
                    .load(bean.getCover())
                    .centerCrop()
                    .placeholder(R.drawable.default_img)
                    .error(R.drawable.default_img)
                    .transform(new GlideRoundTransform(getActivity()))
                    .dontAnimate()
                    .into(iv_home_music_cover);

            tv_home_music_play_count.setText(bean.getPlayCount() + "次");
            tv_home_music_sheet_name.setText(bean.getName());
            tv_home_music_singer.setText(bean.getSinger());

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
