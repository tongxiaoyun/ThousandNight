package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2017/3/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ActivityHomeAdapter<T extends Object> extends BaseRecyclerAdapter<T> {

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity_home, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    class ViewHolder extends BaseViewHolder<T> {
        public ViewHolder(View itemView) {
            super(itemView);
        }

//
//        @ViewInject(R.id.back)
//        private ImageView back;

        @BindView(R.id.ll_activity)
        LinearLayout ll_activity;

        @BindView(R.id.rl_activity)
        RelativeLayout rl_activity;

        @BindView(R.id.iv_activity_home_aver_bg)
        ImageView iv_activity_home_aver_bg;

        @BindView(R.id.iv_activity_home_aver)
        ImageView iv_activity_home_aver;


        @Override
        protected void prepareData() {
            ll_activity.setVisibility(View.VISIBLE);
            rl_activity.setVisibility(View.GONE);
        }

        @Override
        protected void initHead(BaseHeadBean baseHeadBean) {
            ll_activity.setVisibility(View.GONE);
            rl_activity.setVisibility(View.VISIBLE);

            Glide.with(getActivity())
                    .load("http://img4.imgtn.bdimg.com/it/u=2945579072,2771775978&fm=27&gp=0.jpg")
                    .dontAnimate()
                    // 设置高斯模糊
                    .bitmapTransform(new BlurTransformation(getActivity(), 14, 3))
                    .into(iv_activity_home_aver_bg);

            Glide.with(getActivity())
                    .load("http://img4.imgtn.bdimg.com/it/u=2945579072,2771775978&fm=27&gp=0.jpg")
                    .dontAnimate()
                    // 设置高斯模糊
                    .bitmapTransform(new GlideRoundTransform(getActivity()))
                    .into(iv_activity_home_aver);
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
