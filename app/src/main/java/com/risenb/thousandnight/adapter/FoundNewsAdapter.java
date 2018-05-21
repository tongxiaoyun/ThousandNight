package com.risenb.thousandnight.adapter;

import android.content.Context;
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
 * Created by user on 2018/5/15.
 */

public class FoundNewsAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_found_news, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_news_item)
        LinearLayout ll_news_item;

        @BindView(R.id.ll_banner_top)
        LinearLayout ll_banner_top;

        @BindView(R.id.mzb_banner)
        MZBannerView mzb_banner;

        @Override
        protected void prepareData() {
            ll_news_item.setVisibility(View.VISIBLE);
            ll_banner_top.setVisibility(View.GONE);
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_news_item.setVisibility(View.GONE);
            ll_banner_top.setVisibility(View.VISIBLE);
            initBanner();
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

            mzb_banner.setPages(banners, new MZHolderCreator<ViewPagerHolder>() {
                @Override
                public ViewPagerHolder createViewHolder() {
                    return new ViewPagerHolder();
                }
            });
            mzb_banner.start();
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
