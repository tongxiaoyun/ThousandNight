package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.found.activity.ActivityHomeUI;
import com.risenb.thousandnight.ui.found.activity.ReleaseAcitivityUI;
import com.risenb.thousandnight.ui.found.album.FoundAlbumUI;
import com.risenb.thousandnight.ui.found.dance.FoundDanceUI;
import com.risenb.thousandnight.ui.found.livevideo.FoundLiveVideoUI;
import com.risenb.thousandnight.ui.found.mall.FoundMallUI;
import com.risenb.thousandnight.ui.found.news.FoundNewsUI;
import com.risenb.thousandnight.ui.found.recruit.FoundRecruitUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2018/5/15.
 */

public class FoundAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_found, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_found_item)
        LinearLayout ll_found_item;

        @BindView(R.id.ll_found_top)
        LinearLayout ll_found_top;

        @BindView(R.id.rv_found)
        MyRecyclerView rv_found;

        private FoundChildAdapter<Object> foundChildAdapter;

        @Override
        protected void prepareData() {
            ll_found_item.setVisibility(View.VISIBLE);
            ll_found_top.setVisibility(View.GONE);
            initAdapter();
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_found_item.setVisibility(View.GONE);
            ll_found_top.setVisibility(View.VISIBLE);
        }

        @Override
        protected void initFoot(BaseFootBean baseFootBean) {

        }

        @Override
        protected void reflectionView(View view) {
            ButterKnife.bind(this, view);
        }

        private void initAdapter() {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            rv_found.setLayoutManager(gridLayoutManager);
            foundChildAdapter = new FoundChildAdapter<>();
            foundChildAdapter.setActivity(getActivity());
            rv_found.setAdapter(foundChildAdapter);
        }

        /**
         * 直播
         */
        @OnClick(R.id.rl_found_livevideo)
        void liveVideo() {
            Intent intent = new Intent(getActivity(), FoundLiveVideoUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 舞伴大厅
         */
        @OnClick(R.id.rl_found_dance)
        void dance() {
            Intent intent = new Intent(getActivity(), FoundDanceUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 求职招聘
         */
        @OnClick(R.id.rl_found_job)
        void job() {
            Intent intent = new Intent(getActivity(), FoundRecruitUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 周边商城
         */
        @OnClick(R.id.rl_found_mall)
        void mall() {
            Intent intent = new Intent(getActivity(), FoundMallUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 千夜新闻
         */
        @OnClick(R.id.ll_found_news)
        void news() {
            Intent intent = new Intent(getActivity(), FoundNewsUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 千夜相册
         */
        @OnClick(R.id.ll_found_album)
        void album() {
            Intent intent = new Intent(getActivity(), FoundAlbumUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 报名参加
         */
        @OnClick(R.id.tv_found_join)
        void join() {
            Intent intent = new Intent(getActivity(), ReleaseAcitivityUI.class);
            getActivity().startActivity(intent);
        }

        /**
         * 查看活动详情
         */
        @OnClick(R.id.tv_found_detail)
        void detail() {
            Intent intent = new Intent(getActivity(), ActivityHomeUI.class);
            getActivity().startActivity(intent);
        }

    }
}
