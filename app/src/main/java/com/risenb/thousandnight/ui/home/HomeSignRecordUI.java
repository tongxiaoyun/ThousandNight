package com.risenb.thousandnight.ui.home;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 签到记录
 * Created by user on 2018/5/18.
 */

public class HomeSignRecordUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_sign_record;
    }

    @Override
    protected void setControlBasis() {
        setTitle("签到记录");
    }

    @Override
    protected void prepareData() {

    }
}
