package com.risenb.thousandnight.ui.mine.organizeattest;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * 机构认证
 * Created by user on 2018/5/25.
 */

public class OrganizeAttestUI extends BaseUI {


    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_organize_attest;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构认证");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 认证
     */
    @OnClick(R.id.tv_organize_attest)
    void attest() {
        Intent intent = new Intent(OrganizeAttestUI.this, OrganizeInfoSubmitUI.class);
        startActivity(intent);
    }

}
