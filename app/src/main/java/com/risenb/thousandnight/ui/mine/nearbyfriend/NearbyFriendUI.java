package com.risenb.thousandnight.ui.mine.nearbyfriend;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 附近的舞友
 * Created by user on 2018/5/9.
 */

public class NearbyFriendUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_nearby_friend;
    }

    @Override
    protected void setControlBasis() {
        setTitle("附近的舞友");
    }

    @Override
    protected void prepareData() {

    }
}
