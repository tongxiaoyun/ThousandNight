package com.risenb.thousandnight.ui.home.fragment.course;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/25
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class PaySuccessUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_pay_success;
    }

    @Override
    protected void setControlBasis() {
        setTitle("支付成功");
    }

    @Override
    protected void prepareData() {

    }
}
