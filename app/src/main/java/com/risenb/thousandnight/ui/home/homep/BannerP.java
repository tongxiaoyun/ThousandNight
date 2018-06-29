package com.risenb.thousandnight.ui.home.homep;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/6/28.
 */

public class BannerP extends PresenterBase {

    private BannerFace face;

    public BannerP(BannerFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void getBanner() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().banner(face.getType(), new HttpBack<BannerBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<BannerBean> result) {
                dismissProgressDialog();
                face.setBanner(result);
            }

            @Override
            public void onSuccess(BannerBean result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public interface BannerFace {

        String getType();

        void setBanner(ArrayList<BannerBean> result);
    }

}
