package com.risenb.thousandnight.ui.mine.attention;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineAttentionAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 我关注的
 * Created by user on 2018/5/24.
 */

public class AttentionUI extends BaseUI {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    private MineAttentionAdapter<Object> mineAttentionAdapter;
    private String ui = "";

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_common_2;
    }

    @Override
    protected void setControlBasis() {
        ui = getIntent().getStringExtra("ui");
        setTitle(ui);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_common.setLayoutManager(linearLayoutManager);
        mineAttentionAdapter = new MineAttentionAdapter<>();
        mineAttentionAdapter.setActivity(this);
        mineAttentionAdapter.setUI(ui);
        xrv_common.setAdapter(mineAttentionAdapter);
    }

}
