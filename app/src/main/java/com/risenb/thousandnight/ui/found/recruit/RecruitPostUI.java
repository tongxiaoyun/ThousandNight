package com.risenb.thousandnight.ui.found.recruit;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class RecruitPostUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_post_recruit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("求职投递");
    }

    @Override
    protected void prepareData() {

    }
}
