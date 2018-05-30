package com.risenb.thousandnight.ui.login.loginp;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.beans.UserBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;
import com.risenb.thousandnight.utils.RegexUtils;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/30.
 */

public class ForgetPwdP extends PresenterBase {

    private ForgetPwdP presenter;

    private ForgetPwdFace face;

    public ForgetPwdP(ForgetPwdFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void sendCode() {
        if (TextUtils.isEmpty(face.getTel())) {
            makeText("请输入手机号");
            return;
        }
        if (!RegexUtils.checkMobile(face.getTel())) {
            makeText("电话号码格式不正确");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().getCode(face.getTel(), "2", new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                //当data中是String 时走这个
                dismissProgressDialog();
                face.sendSMSSuccess();
            }

            @Override
            public void onSuccess(ArrayList<Object> result) {
                //当data中是List 时走这个
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(Object result) {
                //当data中是Object 时走这个
                dismissProgressDialog();

            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                face.sendSMSFaile();
                dismissProgressDialog();
            }
        });
    }

    public void forgetPwd() {
        if (TextUtils.isEmpty(face.getTel())) {
            makeText("请输入手机号");
            return;
        }
        if (!RegexUtils.checkMobile(face.getTel())) {
            makeText("电话号码格式不正确");
            return;
        }
        if (TextUtils.isEmpty(face.getCode())) {
            makeText("请输入验证码");
            return;
        }
        if (TextUtils.isEmpty(face.getPWD())) {
            makeText("请输入密码");
            return;
        }
        if (face.getPWD().length() < 6) {
            makeText("您输入的密码过于简单");
            return;
        }
        if (!face.getPWD().equals(face.getConfirmPWD())) {
            makeText("您输入的密码不一致");
            return;
        }

        showProgressDialog();
        NetworkUtils.getNetworkUtils().findPwd(face.getTel(), face.getCode(), face.getPWD(), face.getConfirmPWD(), new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
                makeText("修改成功");
                getActivity().finish();
            }

            @Override
            public void onSuccess(ArrayList<Object> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(Object result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public interface ForgetPwdFace {

        String getTel();

        String getCode();

        String getPWD();

        String getConfirmPWD();

        void sendSMSSuccess();

        void sendSMSFaile();

    }

}
