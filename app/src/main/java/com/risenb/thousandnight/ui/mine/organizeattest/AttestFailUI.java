package com.risenb.thousandnight.ui.mine.organizeattest;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 认证失败
 * Created by user on 2018/5/25.
 */

public class AttestFailUI extends BaseUI {


    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_attest_fail;
    }

    @Override
    protected void setControlBasis() {
        setTitle("认证失败");
    }

    @Override
    protected void prepareData() {

    }
}
