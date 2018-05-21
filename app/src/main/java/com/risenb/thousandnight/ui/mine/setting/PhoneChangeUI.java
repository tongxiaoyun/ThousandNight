package com.risenb.thousandnight.ui.mine.setting;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 修改手机号
 * Created by user on 2018/5/9.
 */

public class PhoneChangeUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_phone_change;
    }

    @Override
    protected void setControlBasis() {
        setTitle("修改手机号");
    }

    @Override
    protected void prepareData() {

    }
}
