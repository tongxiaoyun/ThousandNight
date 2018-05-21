package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/11.
 */

public class SquareAttentionAdapter<T extends Object> extends BaseRecyclerAdapter {

    @Override
    public int getItemCount() {
        return 5;
    }

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

        private ImageAdapter<Object> imageAdapter;

        @Override
        protected void prepareData() {
            initAdapter();
            if (onItemReportClickListener != null){
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
