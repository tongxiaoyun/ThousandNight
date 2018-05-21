package com.risenb.thousandnight.ui.login;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by user on 2018/5/4.
 */

public class RegisterUI extends BaseUI {

    @BindView(R.id.et_register_phone)
    EditText et_register_phone;

    @BindView(R.id.et_register_code)
    EditText et_register_code;

    @BindView(R.id.et_register_pwd)
    EditText et_register_pwd;

    @BindView(R.id.et_register_invitecode)
    EditText et_register_invitecode;

    @BindView(R.id.tv_register_code)
    TextView tv_register_code;

    @BindView(R.id.cb_register_agreement)
    CheckBox cb_register_agreement;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_register;
    }

    @Override
    protected void setControlBasis() {
        setTitle("注册");
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 立即登录
     */
    @OnClick(R.id.tv_register_login)
    void login() {
        finish();
    }

    /**
     * 完成
     */
    @OnClick(R.id.tv_register_complete)
    void complete() {
        finish();
    }

}
