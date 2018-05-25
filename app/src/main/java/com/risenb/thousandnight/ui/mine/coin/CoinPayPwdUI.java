package com.risenb.thousandnight.ui.mine.coin;


import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 支付密码
 * Created by user on 2018/5/23.
 */

public class CoinPayPwdUI extends BaseUI {

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
        setTitle("支付密码");
        tv_coin_name.setText("支付密码:");
        et_coin_content.setHint("请输入您的支付密码");
        et_coin_content.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 确定
     */
    @OnClick(R.id.tv_coin_confirm)
    void confirm(){
    }
}
