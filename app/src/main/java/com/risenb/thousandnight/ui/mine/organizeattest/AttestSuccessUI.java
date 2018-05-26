package com.risenb.thousandnight.ui.mine.organizeattest;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 认证成功
 * Created by user on 2018/5/25.
 */

public class AttestSuccessUI extends BaseUI {

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_attest_success;
    }

    @Override
    protected void setControlBasis() {
        setTitle("认证成功");
    }

    @Override
    protected void prepareData() {

    }
}
