package com.risenb.thousandnight.ui.mine.setting;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 修改密码
 * Created by user on 2018/5/9.
 */

public class LoginPwdEditUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_login_pwd_edit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("修改密码");
    }

    @Override
    protected void prepareData() {

    }
}
