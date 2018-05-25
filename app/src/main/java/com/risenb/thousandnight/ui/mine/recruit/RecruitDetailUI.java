package com.risenb.thousandnight.ui.mine.recruit;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineRecruitDetailAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 招聘详情
 * Created by user on 2018/5/24.
 */

public class RecruitDetailUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private MineRecruitDetailAdapter<Object> mineRecruitDetailAdapter;

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
        setTitle("拉丁舞教练");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        mineRecruitDetailAdapter = new MineRecruitDetailAdapter<>();
        mineRecruitDetailAdapter.setActivity(this);
        mineRecruitDetailAdapter.setmHeaderCount(1);
        xrv_common.setAdapter(mineRecruitDetailAdapter);
        mineRecruitDetailAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(RecruitDetailUI.this, ResumeDetailUI.class);
                startActivity(intent);
            }
        });
    }

}
