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
 * Created by user on 2018/5/25.
 */

public class MineVipOpenAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_vip_open, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.tv_vip_open_title)
        TextView tv_vip_open_title;

        @BindView(R.id.tv_vip_open_price)
        TextView tv_vip_open_price;

        @BindView(R.id.tv_vip_open_status)
        TextView tv_vip_open_status;

        @Override
        protected void prepareData() {
            if (position == 0) {
                tv_vip_open_title.setText("1个月");
                tv_vip_open_price.setText("¥ 112.00");
                tv_vip_open_status.setText("立即开通");
            } else if (position == 1) {
                tv_vip_open_title.setText("3个月");
                tv_vip_open_price.setText("¥ 298.00");
                tv_vip_open_status.setText("立即开通");
            } else if (position == 2) {
                tv_vip_open_title.setText("12个月");
                tv_vip_open_price.setText("¥ 498.00");
                tv_vip_open_status.setText("立即开通");
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
