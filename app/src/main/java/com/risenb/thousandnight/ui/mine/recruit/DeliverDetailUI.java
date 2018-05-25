package com.risenb.thousandnight.ui.mine.recruit;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 投递详情
 * Created by user on 2018/5/24.
 */

public class DeliverDetailUI extends BaseUI {

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_deliver_detail;
    }

    @Override
    protected void setControlBasis() {
        setTitle("拉丁舞教练");
    }

    @Override
    protected void prepareData() {

    }
}
