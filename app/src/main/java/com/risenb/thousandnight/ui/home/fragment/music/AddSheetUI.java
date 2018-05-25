package com.risenb.thousandnight.ui.home.fragment.music;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class AddSheetUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_add_sheet;
    }

    @Override
    protected void setControlBasis() {
        backGone();
        leftVisible("取消");
        rightVisible("确定");
        setTitle("创建歌单");

    }

    @OnClick(R.id.ll_left)
    void left() {
        back();
    }

    @Override
    protected void prepareData() {

    }
}
