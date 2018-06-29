package com.risenb.thousandnight.ui.login;

import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.login.loginp.CodeP;
import com.risenb.thousandnight.ui.login.loginp.ForgetPwdP;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码
 * Created by user on 2018/5/4.
 */

public class ForgetPwdUI extends BaseUI implements CodeP.CodeFace, ForgetPwdP.ForgetPwdFace {

    @BindView(R.id.et_forget_pwd_phone)
    EditText et_forget_pwd_phone;

    @BindView(R.id.et_forget_pwd_code)
    EditText et_forget_pwd_code;

    @BindView(R.id.et_forget_pwd_pwd)
    EditText et_forget_pwd_pwd;

    @BindView(R.id.et_forget_pwd_pwd2)
    EditText et_forget_pwd_pwd2;

    @BindView(R.id.tv_forget_pwd_code)
    TextView tv_forget_pwd_code;

    private CodeP codeP;
    private ForgetPwdP forgetPwdP;

    private int second = 60;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (second == 0) {
                second = 60;
                tv_forget_pwd_code.setClickable(true);
                tv_forget_pwd_code.setText("获取验证码");
            } else {
                tv_forget_pwd_code.setText(second + "s 后点击重发");
                second--;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0);
                    }
                }, 1000);
            }

        }
    };

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
        setTitle("忘记密码");
        codeP = new CodeP(this, getActivity());
        forgetPwdP = new ForgetPwdP(this, getActivity());
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 获取验证码
     */
    @OnClick(R.id.tv_forget_pwd_code)
    void code() {
        codeP.sendCode();
        tv_forget_pwd_code.setClickable(false);
    }

    /**
     * 确认
     */
    @OnClick(R.id.tv_forget_pwd_confirm)
    void confirm() {
        forgetPwdP.forgetPwd();
    }

    @Override
    public String getTel() {
        return et_forget_pwd_phone.getText().toString().trim();
    }

    @Override
    public String getType() {
        return "2";
    }

    @Override
    public String getCode() {
        return et_forget_pwd_code.getText().toString().trim();
    }

    @Override
    public String getPWD() {
        return et_forget_pwd_pwd.getText().toString().trim();
    }

    @Override
    public String getConfirmPWD() {
        return et_forget_pwd_pwd2.getText().toString().trim();
    }

    @Override
    public void sendSMSSuccess() {
        handler.sendEmptyMessage(0);
    }

    @Override
    public void sendSMSFaile() {
        tv_forget_pwd_code.setClickable(true);
    }

}
