package com.risenb.thousandnight.ui.login;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.TabUI;
import com.risenb.thousandnight.ui.login.loginp.LoginP;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录
 * Created by user on 2018/5/4.
 */

public class LoginUI extends BaseUI implements LoginP.LoginFace {

    @BindView(R.id.et_login_phone)
    EditText et_login_phone;

    @BindView(R.id.et_login_pwd)
    EditText et_login_pwd;

    @BindView(R.id.iv_login_status1)
    ImageView iv_login_status1;

    @BindView(R.id.iv_login_status2)
    ImageView iv_login_status2;

    private LoginP loginP;

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
        if (!TextUtils.isEmpty(application.getC())){
            Intent intent = new Intent(LoginUI.this, TabUI.class);
            startActivity(intent);
            finish();
        }

        loginP = new LoginP(this, getActivity());
//        et_login_phone.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                iv_login_status1.setVisibility(View.VISIBLE);
//                if ("".equals(et_login_phone.getText().toString().trim())) {
//                    iv_login_status1.setImageResource(R.drawable.login_correct);
//                } else {
//                    iv_login_status1.setImageResource(R.drawable.login_error);
//                }
//            }
//        });
//        et_login_pwd.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                iv_login_status2.setVisibility(View.VISIBLE);
//                if ("".equals(et_login_pwd.getText().toString().trim())) {
//                    iv_login_status2.setImageResource(R.drawable.login_correct);
//                } else {
//                    iv_login_status2.setImageResource(R.drawable.login_error);
//                }
//            }
//        });
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
        loginP.login();
    }

    /**
     * 微信
     */
    @OnClick(R.id.tv_login_weixin)
    void weixinLogin() {
        Intent intent = new Intent(LoginUI.this, BindMobileUI.class);
        startActivity(intent);
    }

    /**
     * qq
     */
    @OnClick(R.id.tv_login_qq)
    void qqLogin() {
        Intent intent = new Intent(LoginUI.this, BindMobileUI.class);
        startActivity(intent);
    }

    @Override
    public String getTel() {
        return et_login_phone.getText().toString().trim();
    }

    @Override
    public String getPWD() {
        return et_login_pwd.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(LoginUI.this, TabUI.class);
        startActivity(intent);
        finish();
    }
}
