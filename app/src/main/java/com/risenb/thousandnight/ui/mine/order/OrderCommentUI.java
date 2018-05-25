package com.risenb.thousandnight.ui.mine.order;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 课程评价
 * Created by user on 2018/5/21.
 */

public class OrderCommentUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_order_comment;
    }

    @Override
    protected void setControlBasis() {
        setTitle("课程评价");
    }

    @Override
    protected void prepareData() {

    }
}
