package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/24.
 */

public class MineRecruitDetailAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_recruit_detail, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_recruit_detail_item)
        LinearLayout ll_recruit_detail_item;

        @BindView(R.id.ll_recruit_detail_top)
        LinearLayout ll_recruit_detail_top;

        @Override
        protected void prepareData() {
            ll_recruit_detail_item.setVisibility(View.VISIBLE);
            ll_recruit_detail_top.setVisibility(View.GONE);
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_recruit_detail_item.setVisibility(View.GONE);
            ll_recruit_detail_top.setVisibility(View.VISIBLE);
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
