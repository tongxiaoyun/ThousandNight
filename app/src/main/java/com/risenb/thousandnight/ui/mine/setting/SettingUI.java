package com.risenb.thousandnight.ui.mine.setting;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.User;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.login.LoginUI;
import com.risenb.thousandnight.utils.UIManager;

import butterknife.OnClick;

/**
 * 设置
 * Created by user on 2018/5/9.
 */

public class SettingUI extends BaseUI {

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_setting;
    }

    @Override
    protected void setControlBasis() {
        setTitle("设置");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 手机号
     */
    @OnClick(R.id.ll_setting_phone)
    void phone() {
        Intent intent = new Intent(SettingUI.this, PhoneUI.class);
        startActivity(intent);
    }

    /**
     * 修改密码
     */
    @OnClick(R.id.ll_setting_login_pwd)
    void loginPwd() {
        Intent intent = new Intent(SettingUI.this, LoginPwdEditUI.class);
        startActivity(intent);
    }

    /**
     * 支付密码设置
     */
    @OnClick(R.id.ll_setting_pay_pwd)
    void payPwd() {
        Intent intent = new Intent(SettingUI.this, PayPwdSettingUI.class);
        startActivity(intent);
    }

    /**
     * 账号绑定
     */
    @OnClick(R.id.ll_setting_bind)
    void accountBind() {
        Intent intent = new Intent(SettingUI.this, AccountBindUI.class);
        startActivity(intent);
    }

    /**
     * 意见反馈
     */
    @OnClick(R.id.ll_setting_feedback)
    void feedback() {
        Intent intent = new Intent(SettingUI.this, FeedBackUI.class);
        startActivity(intent);
    }

    /**
     * 关于我们
     */
    @OnClick(R.id.ll_setting_aboutus)
    void aboutus() {
        Intent intent = new Intent(SettingUI.this, AboutUsUI.class);
        startActivity(intent);
    }

    /**
     * 退出登录
     */
    @OnClick(R.id.tv_setting_exit)
    void exitLogin() {
        application.setC("");
        application.setUserBean(new User());
        UIManager.getInstance().popAllActivity();
        Intent intent = new Intent(SettingUI.this, LoginUI.class);
        startActivity(intent);
    }

}
