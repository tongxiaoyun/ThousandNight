package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.ButterKnife;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2017/3/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CommentAdapter<T extends Object> extends BaseRecyclerAdapter<T> {

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    private class ViewHolder extends BaseViewHolder<T> {
        public ViewHolder(View itemView) {
            super(itemView);
        }

//
//        @ViewInject(R.id.back)
//        private ImageView back;


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
