package com.risenb.thousandnight.ui.login;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.TabUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录
 * Created by user on 2018/5/4.
 */

public class LoginUI extends BaseUI {

    @BindView(R.id.et_login_phone)
    EditText et_login_phone;

    @BindView(R.id.et_login_pwd)
    EditText et_login_pwd;

    @BindView(R.id.iv_login_status1)
    ImageView iv_login_status1;

    @BindView(R.id.iv_login_status2)
    ImageView iv_login_status2;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_login;
    }

    @Override
    protected void setControlBasis() {
        setTitle("登录");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 忘了密码
     */
    @OnClick(R.id.tv_login_forget_pwd)
    void forgetPwd() {
        Intent intent = new Intent(LoginUI.this, ForgetPwdUI.class);
        intent.putExtra("ui", "忘记密码");
        startActivity(intent);
    }

    /**
     * 注册
     */
    @OnClick(R.id.tv_login_register)
    void register() {
        Intent intent = new Intent(LoginUI.this, RegisterUI.class);
        startActivity(intent);
    }

    /**
     * 登录
     */
    @OnClick(R.id.tv_login_login)
    void login() {
        Intent intent = new Intent(LoginUI.this, TabUI.class);
        startActivity(intent);
    }

    /**
     * 微信
     */
    @OnClick(R.id.tv_login_weixin)
    void weixinLogin() {
        Intent intent = new Intent(LoginUI.this, ForgetPwdUI.class);
        intent.putExtra("ui", "手机号绑定");
        startActivity(intent);
    }

    /**
     * qq
     */
    @OnClick(R.id.tv_login_qq)
    void qqLogin() {
        Intent intent = new Intent(LoginUI.this, ForgetPwdUI.class);
        intent.putExtra("ui", "手机号绑定");
        startActivity(intent);
    }

}
