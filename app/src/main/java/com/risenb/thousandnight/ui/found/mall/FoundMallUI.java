package com.risenb.thousandnight.ui.found.mall;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 周边商城
 * Created by user on 2018/5/16.
 */

public class FoundMallUI extends BaseUI {
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
        setTitle("周边商城");
    }

    @Override
    protected void prepareData() {

    }
}
