package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.views.banner.MZBannerView;
import com.risenb.thousandnight.views.banner.holder.MZHolderCreator;
import com.risenb.thousandnight.views.banner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/11.
 */

public class SquareHotAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_square_hot, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_square_hot_item)
        LinearLayout ll_square_hot_item;

        @BindView(R.id.ll_square_hot_top)
        LinearLayout ll_square_hot_top;

        @BindView(R.id.mzb_square)
        MZBannerView mzb_square;

        @BindView(R.id.rv_square_notice)
        RecyclerView rv_square_notice;

        private SquareHotTopAdapter<Object> squareHotTopAdapter;

        @Override
        protected void prepareData() {
            ll_square_hot_item.setVisibility(View.VISIBLE);
            ll_square_hot_top.setVisibility(View.GONE);
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_square_hot_item.setVisibility(View.GONE);
            ll_square_hot_top.setVisibility(View.VISIBLE);
            initBanner();
            initAdapter();
        }

        @Override
        protected void initFoot(BaseFootBean baseFootBean) {

        }

        @Override
        protected void reflectionView(View view) {
            ButterKnife.bind(this, view);
        }

        private void initBanner() {
            List<BannerBean> banners = new ArrayList<>();
            BannerBean bannerBean = null;
            bannerBean = new BannerBean();
            bannerBean.setImg("");
            banners.add(bannerBean);
            bannerBean = new BannerBean();
            bannerBean.setImg("");
            banners.add(bannerBean);
            bannerBean = new BannerBean();
            bannerBean.setImg("");
            banners.add(bannerBean);

            mzb_square.setPages(banners, new MZHolderCreator<ViewPagerHolder>() {
                @Override
                public ViewPagerHolder createViewHolder() {
                    return new ViewPagerHolder();
                }
            });
            mzb_square.start();
        }

        private void initAdapter() {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_square_notice.setLayoutManager(linearLayoutManager);
            squareHotTopAdapter = new SquareHotTopAdapter<>();
            squareHotTopAdapter.setActivity(getActivity());
            rv_square_notice.setAdapter(squareHotTopAdapter);
        }

    }

    public static final class ViewPagerHolder implements MZViewHolder<BannerBean> {

        private ImageView iv_home_banner;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.include_home_banner, null);
            iv_home_banner = (ImageView) view.findViewById(R.id.iv_home_banner);
            return view;
        }

        @Override
        public void onBind(Context context, int position, BannerBean data) {
            Glide.with(context).load("").error(R.drawable.default_banner).placeholder(R.drawable.default_banner).into(iv_home_banner);

        }
    }

}