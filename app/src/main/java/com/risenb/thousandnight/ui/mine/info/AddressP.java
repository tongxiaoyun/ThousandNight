package com.risenb.thousandnight.ui.mine.info;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.ProviceBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/20.
 */

public class AddressP extends PresenterBase {

    private AddressFace face;

    public AddressP(AddressFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void getPlaces() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().getPlaces(new HttpBack<ProviceBean>() {
            @Override
            public void onSuccess(ArrayList<ProviceBean> result) {
                dismissProgressDialog();
                face.setAddress(result);
            }

            @Override
            public void onSuccess(ProviceBean result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }
        });
    }

    public interface AddressFace {
        void setAddress(ArrayList<ProviceBean> result);
    }

}
