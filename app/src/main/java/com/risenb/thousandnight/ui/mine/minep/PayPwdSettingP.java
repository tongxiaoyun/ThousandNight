package com.risenb.thousandnight.ui.mine.minep;

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

public class PayPwdSettingP extends PresenterBase {

    private PayPwdSettingFace face;

    public PayPwdSettingP(PayPwdSettingFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void getPayCode() {
        if (TextUtils.isEmpty(face.getMobile())) {
            makeText("请输入手机号");
            return;
        }
        if (!RegexUtils.checkMobile(face.getMobile())) {
            makeText("电话号码格式不正确");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().getPayCode(new HttpBack<CodeBean>() {
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

    public void changePay() {
        if (TextUtils.isEmpty(face.getMobile())) {
            makeText("请输入手机号");
            return;
        }
        if (!RegexUtils.checkMobile(face.getMobile())) {
            makeText("电话号码格式不正确");
            return;
        }
        if (TextUtils.isEmpty(face.getCode())) {
            makeText("请输入验证码");
            return;
        }
        if (TextUtils.isEmpty(face.getPwd())) {
            makeText("请输入密码");
            return;
        }
        if (face.getPwd().length() < 6) {
            makeText("您输入的密码过于简单");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().changePay(face.getCode(), face.getPwd(), new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
                makeText("设置成功");
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

    public interface PayPwdSettingFace {

        String getMobile();

        String getCode();

        String getPwd();

        void sendSMSSuccess();

        void sendSMSFaile();

    }

}
