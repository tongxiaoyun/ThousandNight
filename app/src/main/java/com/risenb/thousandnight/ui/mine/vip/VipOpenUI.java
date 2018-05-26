package com.risenb.thousandnight.ui.mine.vip;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineVipOpenAdapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;

/**
 * 开通会员
 * Created by user on 2018/5/25.
 */

public class VipOpenUI extends BaseUI {

    @BindView(R.id.mrv_vip_open)
    MyRecyclerView mrv_vip_open;

    private MineVipOpenAdapter<Object> mineVipOpenAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_vip_open;
    }

    @Override
    protected void setControlBasis() {
        setTitle("开通会员");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_vip_open.setLayoutManager(linearLayoutManager);
        mineVipOpenAdapter = new MineVipOpenAdapter<>();
        mineVipOpenAdapter.setActivity(this);
        mrv_vip_open.setAdapter(mineVipOpenAdapter);
    }

}
