package com.risenb.thousandnight.ui.mine.setting;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * 手机号
 * Created by user on 2018/5/9.
 */

public class PhoneUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_phone;
    }

    @Override
    protected void setControlBasis() {
        setTitle("手机号");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 更换手机号
     */
    @OnClick(R.id.tv_phone_change)
    void changePhone(){
        Intent intent = new Intent(PhoneUI.this, PhoneChangeUI.class);
        startActivity(intent);
    }

}
