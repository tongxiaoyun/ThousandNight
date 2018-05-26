package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2017/3/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class SelectCourseAdapter<T extends Object> extends BaseRecyclerAdapter<T> {

    private int type = 0;

    public void setType(int type) {
        this.type = type;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select_course, null);
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

        @BindView(R.id.cb_select_course)
        CheckBox cb_select_course;


        @Override
        protected void prepareData() {
            if (type == 0) {
                cb_select_course.setVisibility(View.GONE);
            } else {
                cb_select_course.setVisibility(View.VISIBLE);
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
    }


}
