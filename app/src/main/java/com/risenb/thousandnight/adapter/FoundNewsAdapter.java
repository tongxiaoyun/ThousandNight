package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.beans.NewsBean;
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

public class FoundNewsAdapter<T extends NewsBean> extends BaseRecyclerAdapter {

    private ArrayList<BannerBean> result = new ArrayList<>();

    public void setResult(ArrayList<BannerBean> result) {
        this.result = result;
        notifyDataSetChanged();
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

        @BindView(R.id.iv_news_img)
        ImageView iv_news_img;

        @BindView(R.id.tv_news_title)
        TextView tv_news_title;

        @BindView(R.id.tv_news_look)
        TextView tv_news_look;

        @BindView(R.id.tv_news_zan)
        TextView tv_news_zan;

        @BindView(R.id.tv_news_time)
        TextView tv_news_time;

        @Override
        protected void prepareData() {
            ll_news_item.setVisibility(View.VISIBLE);
            ll_banner_top.setVisibility(View.GONE);
            Glide.with(getActivity()).load(bean.getImg()).placeholder(R.drawable.default_img).error(R.drawable.default_img).into(iv_news_img);
            tv_news_title.setText(bean.getTitle());
            tv_news_look.setText(bean.getViewCount());
            tv_news_zan.setText(bean.getLikeCount());
            tv_news_time.setText(bean.getCreateTimeStr());
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_news_item.setVisibility(View.GONE);
            ll_banner_top.setVisibility(View.VISIBLE);
            if (result.size() != 0)
                initBanner();
            else
                ll_banner_top.setVisibility(View.GONE);
        }

        @Override
        protected void initFoot(BaseFootBean baseFootBean) {

        }

        @Override
        protected void reflectionView(View view) {
            ButterKnife.bind(this, view);
        }

        private void initBanner() {
            mzb_banner.setPages(result, new MZHolderCreator<ViewPagerHolder>() {
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
            Glide.with(context).load(data.getImageUrl()).error(R.drawable.default_banner).placeholder(R.drawable.default_banner).into(iv_home_banner);

        }
    }

}
