package com.risenb.thousandnight.ui.mine.setting;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 账号绑定
 * Created by user on 2018/5/9.
 */

public class AccountBindUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_account_bind;
    }

    @Override
    protected void setControlBasis() {
        setTitle("账号绑定");
    }

    @Override
    protected void prepareData() {

    }
}
