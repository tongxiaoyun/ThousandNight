package com.risenb.thousandnight.ui.mine.recruit;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * 简历详情
 * Created by user on 2018/5/24.
 */

public class ResumeDetailUI extends BaseUI {


    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_resume_detail;
    }

    @Override
    protected void setControlBasis() {
        setTitle("简历详情");
    }

    @Override
    protected void prepareData() {

    }
}
