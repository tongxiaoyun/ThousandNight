package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/23.
 */

public class MineCoinAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_coin, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.iv_coin_img)
        ImageView iv_coin_img;

        @BindView(R.id.tv_coin_describe)
        TextView tv_coin_describe;

        @BindView(R.id.tv_coin_time)
        TextView tv_coin_time;

        @BindView(R.id.ll_coin_gift)
        LinearLayout ll_coin_gift;

        @BindView(R.id.tv_coin_detail)
        TextView tv_coin_detail;

        @Override
        protected void prepareData() {
            if (position == 0 || position == 1) {
                iv_coin_img.setImageResource(R.drawable.mine_coin_gift);
                tv_coin_describe.setText("礼物购买");
                tv_coin_time.setText("09:00");
                ll_coin_gift.setVisibility(View.VISIBLE);
                tv_coin_detail.setVisibility(View.GONE);
            } else if (position == 2) {
                iv_coin_img.setImageResource(R.drawable.mine_coin_publish);
                tv_coin_describe.setText("今日首次动态发布");
                tv_coin_time.setText("10-03 09:00");
                ll_coin_gift.setVisibility(View.GONE);
                tv_coin_detail.setVisibility(View.GONE);
            } else if (position == 3) {
                iv_coin_img.setImageResource(R.drawable.mine_coin_join);
                tv_coin_describe.setText("参与活动");
                tv_coin_time.setText("10-03 09:00");
                ll_coin_gift.setVisibility(View.GONE);
                tv_coin_detail.setVisibility(View.GONE);
            } else if (position == 4) {
                iv_coin_img.setImageResource(R.drawable.mine_coin_sign);
                tv_coin_describe.setText("签到");
                tv_coin_time.setText("09:00");
                ll_coin_gift.setVisibility(View.GONE);
                tv_coin_detail.setVisibility(View.GONE);
            } else if (position == 5) {
                iv_coin_img.setImageResource(R.drawable.mine_coin_publish);
                tv_coin_describe.setText("舞伴发布");
                tv_coin_time.setText("10-03 09:00");
                ll_coin_gift.setVisibility(View.GONE);
                tv_coin_detail.setVisibility(View.GONE);
            } else if (position == 6) {
                iv_coin_img.setImageResource(R.drawable.mine_coin_redpacket);
                tv_coin_describe.setText("抢红包");
                tv_coin_time.setText("10-03 09:00");
                ll_coin_gift.setVisibility(View.GONE);
                tv_coin_detail.setVisibility(View.VISIBLE);
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
