package com.risenb.thousandnight.ui.square;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 隐私
 * Created by user on 2018/5/11.
 */

public class SquareSecretUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_square_secret;
    }

    @Override
    protected void setControlBasis() {
        setTitle("隐私");
        rightVisible("确定");
    }

    @Override
    protected void prepareData() {

    }
}
