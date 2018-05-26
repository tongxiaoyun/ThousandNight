package com.risenb.thousandnight.ui.mine.organizeattest;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * 机构简介
 * Created by user on 2018/5/25.
 */

public class OrganizeUnmaintainedUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_organize_unmaintained;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构简介");
        rightVisible("认证信息");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 认证信息
     */
    @OnClick(R.id.ll_right)
    void info() {
        Intent intent = new Intent(OrganizeUnmaintainedUI.this, AttestSuccessUI.class);
        startActivity(intent);
    }

    /**
     * 去维护
     */
    @OnClick(R.id.tv_unmaintained_go)
    void maintenance() {
        Intent intent = new Intent(OrganizeUnmaintainedUI.this, OrganizeMaintenanceUI.class);
        startActivity(intent);
    }

}
