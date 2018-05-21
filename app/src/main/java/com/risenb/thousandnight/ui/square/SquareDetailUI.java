package com.risenb.thousandnight.ui.square;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 动态详情
 * Created by user on 2018/5/11.
 */

public class SquareDetailUI extends BaseUI {
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
        setTitle("动态详情");
    }

    @Override
    protected void prepareData() {

    }
}
