package com.risenb.thousandnight.ui.mine.coin;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 兑换
 * Created by user on 2018/5/23.
 */

public class CoinExchangeUI extends BaseUI {

    @BindView(R.id.tv_coin_name)
    TextView tv_coin_name;

    @BindView(R.id.et_coin_content)
    EditText et_coin_content;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_coin_excharge;
    }

    @Override
    protected void setControlBasis() {
        setTitle("兑换");
        tv_coin_name.setText("兑换码:");
        et_coin_content.setHint("请输入兑换码");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 确定
     */
    @OnClick(R.id.tv_coin_confirm)
    void confirm(){
        Intent intent = new Intent(CoinExchangeUI.this, CoinExchangeResultUI.class);
        startActivity(intent);
    }

}
