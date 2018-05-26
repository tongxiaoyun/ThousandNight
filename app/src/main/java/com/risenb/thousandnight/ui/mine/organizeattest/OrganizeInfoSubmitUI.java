package com.risenb.thousandnight.ui.mine.organizeattest;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * 机构信息提交
 * Created by user on 2018/5/25.
 */

public class OrganizeInfoSubmitUI extends BaseUI {

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_organize_info_submit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构信息提交");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 提交
     */
    @OnClick(R.id.tv_organize_info_submit)
    void submit() {
        Intent intent = new Intent(OrganizeInfoSubmitUI.this, AttestingUI.class);
        startActivity(intent);
    }

}
