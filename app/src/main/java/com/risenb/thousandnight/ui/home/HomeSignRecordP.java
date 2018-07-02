package com.risenb.thousandnight.ui.home;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.HomeSignBean;
import com.risenb.thousandnight.beans.SignBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 2018/5/30.
 */

public class HomeSignRecordP extends PresenterBase {

    private HomeSignRecordFace face;

    public HomeSignRecordP(HomeSignRecordFace face, FragmentActivity activity) {
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

    public void signRecord() {
        String dataStr = new SimpleDateFormat("yyyy-MM").format(new Date());
        showProgressDialog();
        NetworkUtils.getNetworkUtils().signRecord(dataStr, new HttpBack<SignBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<SignBean> result) {
                dismissProgressDialog();
                face.setSignList(result);
            }

            @Override
            public void onSuccess(SignBean result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public interface HomeSignRecordFace {
        void setSign(HomeSignBean result);

        void setSignList(ArrayList<SignBean> result);

        void signSuccess();
    }

}
