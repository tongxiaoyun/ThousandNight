package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
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
 * Created by user on 2018/5/21.
 */

public class MineOrderAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_order, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.rv_order)
        RecyclerView rv_order;

        private MineOrderChildAdapter<Object> mineOrderChildAdapter;

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
            rv_order.setLayoutManager(linearLayoutManager);
            mineOrderChildAdapter = new MineOrderChildAdapter<>();
            mineOrderChildAdapter.setActivity(getActivity());
            mineOrderChildAdapter.setUI("order");
            rv_order.setAdapter(mineOrderChildAdapter);
        }

    }
}
