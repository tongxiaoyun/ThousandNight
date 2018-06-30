package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.utils.GlideRoundTransform;
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

public class SquareHotAdapter<T extends MomentBean> extends BaseRecyclerAdapter {

    ArrayList<BannerBean> result = new ArrayList<>();

    public void setResult(ArrayList<BannerBean> result) {
        this.result = result;
        notifyDataSetChanged();
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

        @BindView(R.id.iv_hot_img)
        ImageView iv_hot_img;

        @BindView(R.id.tv_hot_content)
        TextView tv_hot_content;

        @BindView(R.id.iv_hot_icon)
        ImageView iv_hot_icon;

        @BindView(R.id.tv_hot_nickname)
        TextView tv_hot_nickname;

        @BindView(R.id.tv_hot_comment)
        TextView tv_hot_comment;

        private SquareHotTopAdapter<Object> squareHotTopAdapter;

        @Override
        protected void prepareData() {
            ll_square_hot_item.setVisibility(View.VISIBLE);
            ll_square_hot_top.setVisibility(View.GONE);
            Glide.with(getActivity()).load("").placeholder(R.drawable.default_img).error(R.drawable.default_img).into(iv_hot_img);
            Glide.with(getActivity()).load(bean.getThumb())
                    .transform(new GlideRoundTransform(getActivity()))
                    .error(R.drawable.default_icon)
                    .placeholder(R.drawable.default_icon)
                    .into(iv_hot_icon);
            tv_hot_content.setText(bean.getContent());
            tv_hot_nickname.setText(bean.getNickName());
            tv_hot_comment.setText(bean.getCommentNum());
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_square_hot_item.setVisibility(View.GONE);
            ll_square_hot_top.setVisibility(View.VISIBLE);
            if (result.size() != 0)
                initBanner();
            else
                ll_square_hot_top.setVisibility(View.GONE);
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
            mzb_square.setPages(result, new MZHolderCreator<ViewPagerHolder>() {
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
            Glide.with(context).load(data.getImageUrl()).error(R.drawable.default_banner).placeholder(R.drawable.default_banner).into(iv_home_banner);

        }
    }

}
