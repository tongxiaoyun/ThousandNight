package com.risenb.thousandnight.ui.mine.setting;

import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 支付密码设置
 * Created by user on 2018/5/9.
 */

public class PayPwdSettingUI extends BaseUI implements PayPwdSettingP.PayPwdSettingFace {

    @BindView(R.id.et_pay_pwd_phone)
    EditText et_pay_pwd_phone;

    @BindView(R.id.et_pay_pwd_code)
    EditText et_pay_pwd_code;

    @BindView(R.id.tv_pay_pwd_code)
    TextView tv_pay_pwd_code;

    @BindView(R.id.et_pay_pwd_pwd)
    EditText et_pay_pwd_pwd;

    private PayPwdSettingP payPwdSettingP;

    private int second = 60;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (second == 0) {
                second = 60;
                tv_pay_pwd_code.setClickable(true);
                tv_pay_pwd_code.setText("获取验证码");
            } else {
                tv_pay_pwd_code.setText(second + "s 后点击重发");
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
        return R.layout.ui_mine_pay_pwd_setting;
    }

    @Override
    protected void setControlBasis() {
        setTitle("支付密码设置");
        payPwdSettingP = new PayPwdSettingP(this, getActivity());
    }

    @Override
    protected void prepareData() {

    }

    @OnClick(R.id.tv_pay_pwd_code)
    void code() {
        payPwdSettingP.getPayCode();
        tv_pay_pwd_code.setClickable(false);
    }

    @OnClick(R.id.tv_pay_pwd_save)
    void save() {
        payPwdSettingP.changePay();
    }

    @Override
    public String getMobile() {
        return et_pay_pwd_phone.getText().toString().trim();
    }

    @Override
    public String getCode() {
        return et_pay_pwd_code.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return et_pay_pwd_pwd.getText().toString().trim();
    }

    @Override
    public void sendSMSSuccess() {
        handler.sendEmptyMessage(0);
    }

    @Override
    public void sendSMSFaile() {
        tv_pay_pwd_code.setClickable(true);
    }
}
