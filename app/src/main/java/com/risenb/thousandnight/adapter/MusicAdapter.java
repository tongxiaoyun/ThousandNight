package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/10.
 */

public class MusicAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_music, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.mrv_music)
        MyRecyclerView mrv_music;

        private HomeMusicAdapter<Object> homeMusicAdapter;

        @Override
        protected void prepareData() {
            initAdapter();
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

        private void initAdapter() {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mrv_music.setLayoutManager(linearLayoutManager);
            homeMusicAdapter = new HomeMusicAdapter<>();
            homeMusicAdapter.setActivity(getActivity());
            mrv_music.setAdapter(homeMusicAdapter);
        }

    }
}
