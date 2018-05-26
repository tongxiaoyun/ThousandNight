package com.risenb.thousandnight.ui.mine.invite;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 邀请好友
 * Created by user on 2018/5/25.
 */

public class InviteFriendUI extends BaseUI {
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
        setTitle("邀请好友");
    }

    @Override
    protected void prepareData() {

    }
}
