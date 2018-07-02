package com.risenb.thousandnight.ui.home;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.beans.HomeSignBean;
import com.risenb.thousandnight.beans.UserBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;
import com.risenb.thousandnight.utils.RegexUtils;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/30.
 */

public class HomeP extends PresenterBase {

    private HomeFace face;

    public HomeP(HomeFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void signInfo() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().signInfo(new HttpBack<HomeSignBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<HomeSignBean> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(HomeSignBean result) {
                dismissProgressDialog();
                face.setSign(result);
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public void sign() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().sign(new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
                face.signSuccess();
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


    public interface HomeFace {
        void setSign(HomeSignBean result);

        void signSuccess();
    }

}
