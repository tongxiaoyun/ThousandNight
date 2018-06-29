package com.risenb.thousandnight.ui.login.loginp;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.beans.CodeBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;
import com.risenb.thousandnight.utils.RegexUtils;

import java.util.ArrayList;

/**
 * Created by user on 2018/6/28.
 */

public class CodeP extends PresenterBase {

    private CodeFace face;

    public CodeP(CodeFace face, FragmentActivity activity) {
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
        NetworkUtils.getNetworkUtils().getCode(face.getTel(), face.getType(), new HttpBack<CodeBean>() {
            @Override
            public void onSuccess(String data) {
                //当data中是String 时走这个
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<CodeBean> result) {
                //当data中是List 时走这个
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(CodeBean result) {
                //当data中是Object 时走这个
                dismissProgressDialog();
                face.sendSMSSuccess();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                face.sendSMSFaile();
                dismissProgressDialog();
            }
        });
    }

    public interface CodeFace {

        String getTel();

        String getType();

        void sendSMSSuccess();

        void sendSMSFaile();

    }

}
