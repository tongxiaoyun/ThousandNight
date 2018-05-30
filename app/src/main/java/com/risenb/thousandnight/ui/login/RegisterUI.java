package com.risenb.thousandnight.ui.login;

import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.login.loginp.RegisterP;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by user on 2018/5/4.
 */

public class RegisterUI extends BaseUI implements RegisterP.RegisterFace {

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

    private RegisterP registerP;
    private int second = 60;
    private String isAgreement = "0";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (second == 0) {
                second = 60;
                tv_register_code.setClickable(true);
                tv_register_code.setText("获取验证码");
            } else {
                tv_register_code.setText(second + "s 后点击重发");
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
        return R.layout.ui_register;
    }

    @Override
    protected void setControlBasis() {
        setTitle("注册");
        registerP = new RegisterP(this, getActivity());
        cb_register_agreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isAgreement = "1";
                } else {
                    isAgreement = "0";
                }
            }
        });
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 获取验证码
     */
    @OnClick(R.id.tv_register_code)
    void code() {
        registerP.sendCode();
        tv_register_code.setClickable(false);
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
        if ("0".equals(isAgreement)){
            makeText("请阅读并同意《千夜注册协议》");
            return;
        }
        registerP.register();
    }

    @Override
    public String getTel() {
        return et_register_phone.getText().toString().trim();
    }

    @Override
    public String getCode() {
        return et_register_code.getText().toString().trim();
    }

    @Override
    public String getPWD() {
        return et_register_pwd.getText().toString().trim();
    }

    @Override
    public String getInviteCode() {
        return et_register_invitecode.getText().toString().trim();
    }

    @Override
    public void sendSMSSuccess() {
        handler.sendEmptyMessage(0);
    }

    @Override
    public void sendSMSFaile() {
        tv_register_code.setClickable(true);
    }

    @Override
    public void registerSuccess() {
        finish();
    }
}
