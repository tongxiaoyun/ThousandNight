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

public class RegisterP extends PresenterBase {

    private RegisterP presenter;

    private RegisterFace face;

    public RegisterP(RegisterFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void sendCode() {
        if (TextUtils.isEmpty(face.getTel())){
            makeText("请输入手机号");
            return;
        }
        if (!RegexUtils.checkMobile(face.getTel())) {
            makeText("电话号码格式不正确");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().getCode(face.getTel(), "1", new HttpBack<Object>() {
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

    public void register() {
        if (TextUtils.isEmpty(face.getTel())){
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
        if (TextUtils.isEmpty(face.getInviteCode())) {
            makeText("请输入邀请码");
            return;
        }

        showProgressDialog();
        NetworkUtils.getNetworkUtils().register("1", face.getTel(), face.getPWD(), face.getCode(), "", "", "", new HttpBack<UserBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<UserBean> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(UserBean result) {
                dismissProgressDialog();
                application.setC(result.getC());
                application.setUserBean(result);
                face.registerSuccess();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public interface RegisterFace {

        String getTel();

        String getCode();

        String getPWD();

        String getInviteCode();

        void sendSMSSuccess();

        void sendSMSFaile();

        void registerSuccess();

    }
}
