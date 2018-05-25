package com.risenb.thousandnight.ui.mine.coin;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * 充值
 * Created by user on 2018/5/23.
 */

public class CoinRechargeUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_coin_recharge;
    }

    @Override
    protected void setControlBasis() {
        setTitle("充值");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 确定充值
     */
    @OnClick(R.id.tv_coin_recharge_confirm)
    void confirm(){
        Intent intent = new Intent(CoinRechargeUI.this, CoinPayPwdUI.class);
        startActivity(intent);
    }

}
