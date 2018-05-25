package com.risenb.thousandnight.ui.mine.vip;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * 会员中心
 * Created by user on 2018/5/25.
 */

public class VipUI extends BaseUI {


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
        setTitle("会员中心");
        rightVisible("购买记录");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 购买记录
     */
    @OnClick(R.id.ll_right)
    void buyRecord() {
        Intent intent = new Intent(VipUI.this, VipRecordUI.class);
        startActivity(intent);
    }

}
