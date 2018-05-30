package com.risenb.thousandnight.ui.login;

import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 手机号绑定
 * Created by user on 2018/5/30.
 */

public class BindMobileUI extends BaseUI {

    @BindView(R.id.et_bind_mobile_phone)
    EditText et_bind_mobile_phone;

    @BindView(R.id.et_bind_mobile_code)
    EditText et_bind_mobile_code;

    @BindView(R.id.et_bind_mobile_pwd)
    EditText et_bind_mobile_pwd;

    @BindView(R.id.tv_bind_mobile_code)
    TextView tv_bind_mobile_code;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_bind_mobile;
    }

    @Override
    protected void setControlBasis() {
        setTitle("手机号绑定");
    }

    @Override
    protected void prepareData() {

    }
}
