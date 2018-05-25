package com.risenb.thousandnight.ui.mine.coin;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 关于千夜币
 * Created by user on 2018/5/23.
 */

public class CoinAboutUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_webview;
    }

    @Override
    protected void setControlBasis() {
        setTitle("关于千夜币");
    }

    @Override
    protected void prepareData() {

    }
}
