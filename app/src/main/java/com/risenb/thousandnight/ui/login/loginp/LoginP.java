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

public class LoginP extends PresenterBase {

    private LoginFace face;

    public LoginP(LoginFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void login() {
        if (TextUtils.isEmpty(face.getTel())) {
            makeText("请输入手机号");
            return;
        }
        if (!RegexUtils.checkMobile(face.getTel())) {
            makeText("电话号码格式不正确");
            return;
        }
        if (TextUtils.isEmpty(face.getPWD())) {
            makeText("请输入密码");
            return;
        }

        showProgressDialog();
        NetworkUtils.getNetworkUtils().login("1", face.getTel(), face.getPWD(), "", "", "", new HttpBack<UserBean>() {
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
                application.setUserBean(result.getUser());
                face.loginSuccess();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public interface LoginFace {

        String getTel();

        String getPWD();

        void loginSuccess();
    }

}
