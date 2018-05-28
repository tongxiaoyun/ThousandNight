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
public class ReleaseRecuitUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_release_recuit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("职位发布");
    }

    @Override
    protected void prepareData() {

    }
}
