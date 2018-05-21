package com.risenb.thousandnight.ui.mine.setting;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 意见反馈
 * Created by user on 2018/5/9.
 */

public class FeedBackUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_feedback;
    }

    @Override
    protected void setControlBasis() {
        setTitle("意见反馈");
    }

    @Override
    protected void prepareData() {

    }
}
