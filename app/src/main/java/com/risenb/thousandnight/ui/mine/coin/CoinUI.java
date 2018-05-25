package com.risenb.thousandnight.ui.mine.coin;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineCoinAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的千夜币
 * Created by user on 2018/5/23.
 */

public class CoinUI extends BaseUI {

    @BindView(R.id.xrv_mine_coin)
    XRecyclerView xrv_mine_coin;

    private MineCoinAdapter<Object> mineCoinAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_coin;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我的千夜币");
        rightVisible("千夜币", R.drawable.mine_help);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_mine_coin.setLayoutManager(linearLayoutManager);
        mineCoinAdapter = new MineCoinAdapter<>();
        mineCoinAdapter.setActivity(this);
        xrv_mine_coin.setAdapter(mineCoinAdapter);
    }

    /**
     * 关于千夜币
     */
    @OnClick(R.id.ll_right)
    void about() {
        Intent intent = new Intent(CoinUI.this, CoinAboutUI.class);
        startActivity(intent);
    }

    /**
     * 充值
     */
    @OnClick(R.id.tv_coin_recharge)
    void recharge() {
        Intent intent = new Intent(CoinUI.this, CoinRechargeUI.class);
        startActivity(intent);
    }

    /**
     * 兑换
     */
    @OnClick(R.id.tv_coin_exchange)
    void exchange() {
        Intent intent = new Intent(CoinUI.this, CoinExchangeUI.class);
        startActivity(intent);
    }

}
