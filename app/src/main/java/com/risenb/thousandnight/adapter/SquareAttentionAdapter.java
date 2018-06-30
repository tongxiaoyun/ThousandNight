package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/11.
 */

public class SquareAttentionAdapter<T extends MomentBean> extends BaseRecyclerAdapter {

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_square_attention, null));
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.rv_square_attention)
        RecyclerView rv_square_attention;

        @BindView(R.id.iv_attention_report)
        ImageView iv_attention_report;

        @BindView(R.id.iv_attention_icon)
        ImageView iv_attention_icon;

        @BindView(R.id.tv_attention_nickname)
        TextView tv_attention_nickname;

        @BindView(R.id.iv_attention_sex)
        ImageView iv_attention_sex;

        @BindView(R.id.tv_attention_age)
        TextView tv_attention_age;

        @BindView(R.id.tv_attention_content)
        TextView tv_attention_content;

        @BindView(R.id.tv_attention_zan)
        TextView tv_attention_zan;

        @BindView(R.id.tv_attention_comment)
        TextView tv_attention_comment;

        @BindView(R.id.tv_attention_time)
        TextView tv_attention_time;

        private ImageAdapter<Object> imageAdapter;

        @Override
        protected void prepareData() {
            initAdapter();
            Glide.with(getActivity()).load(bean.getThumb())
                    .transform(new GlideRoundTransform(getActivity()))
                    .error(R.drawable.default_icon)
                    .placeholder(R.drawable.default_icon)
                    .into(iv_attention_icon);
            tv_attention_nickname.setText(bean.getNickName());
            tv_attention_age.setText(bean.getAgeStr());
            if ("0".equals(bean.getGender())) {
                iv_attention_sex.setImageResource(R.drawable.found_boy);
            } else if ("1".equals(bean.getGender())) {
                iv_attention_sex.setImageResource(R.drawable.found_boy);
            } else if ("2".equals(bean.getGender())) {
                iv_attention_sex.setImageResource(R.drawable.found_girl);
            }
            tv_attention_content.setText(bean.getContent());
            tv_attention_zan.setText(bean.getLikeNum());
            tv_attention_comment.setText(bean.getCommentNum());
            tv_attention_time.setText(bean.getCreateTimeStr());

            if (onItemReportClickListener != null) {
                iv_attention_report.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemReportClickListener.onItemReportClick(position);
                    }
                });
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

        private void initAdapter() {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
            rv_square_attention.setLayoutManager(gridLayoutManager);
            imageAdapter = new ImageAdapter<>();
            imageAdapter.setActivity(getActivity());
            rv_square_attention.setAdapter(imageAdapter);
        }
    }

    public interface OnItemReportClickListener {
        void onItemReportClick(int position);
    }

    private OnItemReportClickListener onItemReportClickListener;

    public void setOnItemReportClickListener(OnItemReportClickListener onItemReportClickListener) {
        this.onItemReportClickListener = onItemReportClickListener;
    }
}
