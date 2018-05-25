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
 * Created by user on 2018/5/24.
 */

public class MineAttentionAdapter<T extends Object> extends BaseRecyclerAdapter {

    private String ui;

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_attention, null));
    }

    public void setUI(String ui) {
        this.ui = ui;
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.tv_attention_status)
        TextView tv_attention_status;

        @Override
        protected void prepareData() {
            if ("我关注的".equals(ui)) {
                tv_attention_status.setText("取消关注");
            } else if ("我的粉丝".equals(ui)) {
                tv_attention_status.setText("互相关注");
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
