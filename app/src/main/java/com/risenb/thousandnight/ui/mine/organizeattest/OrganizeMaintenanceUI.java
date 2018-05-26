package com.risenb.thousandnight.ui.mine.organizeattest;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 机构简介
 * Created by user on 2018/5/25.
 */

public class OrganizeMaintenanceUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_organize_maintenance;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构简介");
    }

    @Override
    protected void prepareData() {

    }
}
