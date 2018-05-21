package com.risenb.thousandnight.ui.login;

import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码  手机号绑定
 * Created by user on 2018/5/4.
 */

public class ForgetPwdUI extends BaseUI {

    @BindView(R.id.et_forget_pwd_phone)
    EditText et_forget_pwd_phone;

    @BindView(R.id.et_forget_pwd_code)
    EditText et_forget_pwd_code;

    @BindView(R.id.et_forget_pwd_pwd)
    EditText et_forget_pwd_pwd;

    @BindView(R.id.tv_forget_pwd_code)
    TextView tv_forget_pwd_code;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_forget_pwd;
    }

    @Override
    protected void setControlBasis() {
        setTitle(getIntent().getStringExtra("ui"));
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 确认
     */
    @OnClick(R.id.tv_forget_pwd_confirm)
    void confirm() {
        finish();
    }

}
