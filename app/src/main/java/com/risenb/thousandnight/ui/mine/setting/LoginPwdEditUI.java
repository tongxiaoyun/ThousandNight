package com.risenb.thousandnight.ui.mine.setting;

import android.widget.EditText;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改密码
 * Created by user on 2018/5/9.
 */

public class LoginPwdEditUI extends BaseUI implements LoginPwdEditP.LoginPwdEditFace {

    @BindView(R.id.et_pwd_edit_old)
    EditText et_pwd_edit_old;

    @BindView(R.id.et_pwd_edit_new1)
    EditText et_pwd_edit_new1;

    @BindView(R.id.et_pwd_edit_new2)
    EditText et_pwd_edit_new2;

    private LoginPwdEditP loginPwdEditP;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_login_pwd_edit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("修改密码");
        loginPwdEditP = new LoginPwdEditP(this, getActivity());
    }

    @Override
    protected void prepareData() {

    }

    @OnClick(R.id.tv_pwd_edit_save)
    void save() {
        loginPwdEditP.changePwd();
    }

    @Override
    public String getOldPwd() {
        return et_pwd_edit_old.getText().toString().trim();
    }

    @Override
    public String getNewPwdOne() {
        return et_pwd_edit_new1.getText().toString().trim();
    }

    @Override
    public String getNewPwdTwo() {
        return et_pwd_edit_new2.getText().toString().trim();
    }
}
