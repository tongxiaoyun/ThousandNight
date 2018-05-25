package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/24.
 */

public class Image2Adapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_2, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void prepareData() {

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
