package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/9.
 */

public class MineDynamicAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_dynamic, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.rv_home_dynamic)
        RecyclerView rv_home_dynamic;

        private ImageAdapter<Object> imageAdapter;

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
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            rv_home_dynamic.setLayoutManager(gridLayoutManager);
            imageAdapter = new ImageAdapter<>();
            imageAdapter.setActivity(getActivity());
            rv_home_dynamic.setAdapter(imageAdapter);
        }

    }
}
