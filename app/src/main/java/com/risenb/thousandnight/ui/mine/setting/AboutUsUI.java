package com.risenb.thousandnight.ui.mine.setting;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 关于我们
 * Created by user on 2018/5/9.
 */

public class AboutUsUI extends BaseUI {

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_aboutus;
    }

    @Override
    protected void setControlBasis() {
        setTitle("关于我们");
    }

    @Override
    protected void prepareData() {

    }
}
