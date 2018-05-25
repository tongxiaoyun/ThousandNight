package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

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

public class MineOrderChildAdapter<T extends Object> extends BaseRecyclerAdapter {

    private String ui;

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_order_child, null));
    }

    public void setUI(String ui){
        this.ui = ui;
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.tv_order_course_price)
        TextView tv_order_course_price;

        @BindView(R.id.tv_order_course_episode)
        TextView tv_order_course_episode;

        @Override
        protected void prepareData() {
            if ("order".equals(ui)){
                tv_order_course_price.setVisibility(View.GONE);
                tv_order_course_episode.setText("共13集");
            } else if ("detail".equals(ui)){
                tv_order_course_price.setVisibility(View.VISIBLE);
                tv_order_course_episode.setText("第13集");
            }
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
