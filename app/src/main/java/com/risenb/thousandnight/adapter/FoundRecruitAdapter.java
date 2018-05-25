package com.risenb.thousandnight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.expand.xrecyclerview.adapter.BaseViewHolder;
import com.risenb.expand.xrecyclerview.bean.BaseFootBean;
import com.risenb.expand.xrecyclerview.bean.BaseHeadBean;
import com.risenb.thousandnight.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2018/5/16.
 */

public class FoundRecruitAdapter<T extends Object> extends BaseRecyclerAdapter {

    private String ui;

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    protected BaseViewHolder loadView(Context context, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_found_recruit, null));
    }

    public void setUI(String ui) {
        this.ui = ui;
    }

    class ViewHolder extends BaseViewHolder<T> {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @BindView(R.id.ll_job_user)
        LinearLayout ll_job_user;

        @BindView(R.id.v_line)
        View v_line;

        @BindView(R.id.ll_job_person_num)
        LinearLayout ll_job_person_num;

        @Override
        protected void prepareData() {
            if ("发现".equals(ui)) {
                ll_job_user.setVisibility(View.VISIBLE);
                v_line.setVisibility(View.VISIBLE);
                ll_job_person_num.setVisibility(View.INVISIBLE);
            } else if ("招聘".equals(ui)) {
                ll_job_user.setVisibility(View.GONE);
                v_line.setVisibility(View.GONE);
                ll_job_person_num.setVisibility(View.VISIBLE);
            } else if ("投递".equals(ui)) {
                ll_job_user.setVisibility(View.GONE);
                v_line.setVisibility(View.GONE);
                ll_job_person_num.setVisibility(View.INVISIBLE);
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
