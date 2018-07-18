package com.risenb.thousandnight.ui.mine.setting;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;


/**
 * Created by user on 2018/6/28.
 */

public class LoginPwdEditP extends PresenterBase {

    private LoginPwdEditFace face;

    public LoginPwdEditP(LoginPwdEditFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void changePwd() {
        if (TextUtils.isEmpty(face.getOldPwd())) {
            makeText("请输入旧密码");
            return;
        }
        if (TextUtils.isEmpty(face.getNewPwdOne())) {
            makeText("请输入新密码");
            return;
        }
        if (TextUtils.isEmpty(face.getNewPwdTwo())) {
            makeText("请输入确认密码");
            return;
        }
        if (face.getNewPwdOne().length() < 6) {
            makeText("您输入的密码过于简单");
            return;
        }
        if (!face.getNewPwdOne().equals(face.getNewPwdTwo())) {
            makeText("您输入的密码不一致");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().changePwd(face.getOldPwd(), face.getNewPwdOne(), face.getNewPwdTwo(), new HttpBack<Object>() {
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

    public interface LoginPwdEditFace {

        String getOldPwd();

        String getNewPwdOne();

        String getNewPwdTwo();

    }

}
