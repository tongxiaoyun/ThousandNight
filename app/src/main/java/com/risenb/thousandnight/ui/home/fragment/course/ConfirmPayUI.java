package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/25
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ConfirmPayUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_confrim_pay;
    }

    @Override
    protected void setControlBasis() {
        setTitle("确认支付");
    }

    @Override
    protected void prepareData() {

    }


    @OnClick(R.id.tv_confirm_pay_confirm)
    void pay() {
        Intent intent = new Intent(getActivity(), PaySuccessUI.class);
        startActivity(intent);
    }
}
