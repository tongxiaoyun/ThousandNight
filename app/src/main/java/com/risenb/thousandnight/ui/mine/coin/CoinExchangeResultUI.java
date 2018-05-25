package com.risenb.thousandnight.ui.mine.coin;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 兑换结果
 * Created by user on 2018/5/23.
 */

public class CoinExchangeResultUI extends BaseUI {

    //兑换成功
    @BindView(R.id.ll_exchange_result_success)
    LinearLayout ll_exchange_result_success;

    //兑换失败
    @BindView(R.id.tv_exchange_result_fail)
    TextView tv_exchange_result_fail;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_coin_exchange_result;
    }

    @Override
    protected void setControlBasis() {
        setTitle("兑换结果");
        ll_exchange_result_success.setVisibility(View.VISIBLE);
        tv_exchange_result_fail.setVisibility(View.GONE);
    }

    @Override
    protected void prepareData() {

    }
}
