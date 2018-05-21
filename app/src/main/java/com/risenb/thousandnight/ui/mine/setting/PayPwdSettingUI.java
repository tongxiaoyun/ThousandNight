package com.risenb.thousandnight.ui.mine.setting;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 支付密码设置
 * Created by user on 2018/5/9.
 */

public class PayPwdSettingUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_pay_pwd_setting;
    }

    @Override
    protected void setControlBasis() {
        setTitle("支付密码设置");
    }

    @Override
    protected void prepareData() {

    }
}
