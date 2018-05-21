package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.home.download.DownloadListUI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2018/5/18.
 */

public class HomeDownloadAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_download, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_download_item)
        LinearLayout ll_download_item;

        @BindView(R.id.ll_download_top)
        LinearLayout ll_download_top;

        @Override
        protected void prepareData() {
            ll_download_item.setVisibility(View.VISIBLE);
            ll_download_top.setVisibility(View.GONE);
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_download_item.setVisibility(View.GONE);
            ll_download_top.setVisibility(View.VISIBLE);
        }

        @Override
        protected void initFoot(BaseFootBean baseFootBean) {

        }

        @Override
        protected void reflectionView(View view) {
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.ll_download_top)
        void list(){
            Intent intent = new Intent(getActivity(), DownloadListUI.class);
            getActivity().startActivity(intent);
        }

    }
}
