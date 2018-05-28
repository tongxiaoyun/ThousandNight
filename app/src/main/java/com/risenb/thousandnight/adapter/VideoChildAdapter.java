package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.home.fragment.video.ReplayUI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/10.
 */

public class VideoChildAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video_child, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        @BindView(R.id.rl_video_message)
        RelativeLayout rl_video_message;

        public ViewHolder(View itemView) {
            super(itemView);
        }


        @Override
        protected void prepareData() {
            rl_video_message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), ReplayUI.class);
                    getActivity().startActivity(intent);
                }
            });

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
