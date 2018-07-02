package com.risenb.thousandnight.ui.mine.recruit;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundRecruitAdapter;
import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 求职招聘
 * Created by user on 2018/5/18.
 */

public class RecruitUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private FoundRecruitAdapter<PositonBean> foundRecruitAdapter;
    private String ui = "";

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_common;
    }

    @Override
    protected void setControlBasis() {
        setTitle("求职招聘");
        rightVisible(R.drawable.mine_delete);
        ui = getIntent().getStringExtra("ui");
//        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        foundRecruitAdapter = new FoundRecruitAdapter<>();
        foundRecruitAdapter.setActivity(this);
        if ("招聘".equals(ui)) {
            foundRecruitAdapter.setUI(ui);
            foundRecruitAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int i) {
                    Intent intent = new Intent(RecruitUI.this, RecruitDetailUI.class);
                    intent.putExtra("ui", "mine");
                    startActivity(intent);
                }
            });
        } else if ("投递".equals(ui)) {
            foundRecruitAdapter.setUI(ui);
            foundRecruitAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int i) {
                    Intent intent = new Intent(RecruitUI.this, DeliverDetailUI.class);
                    intent.putExtra("ui", "mine");
                    startActivity(intent);
                }
            });
        }
        xrv_common.setAdapter(foundRecruitAdapter);
    }

}
