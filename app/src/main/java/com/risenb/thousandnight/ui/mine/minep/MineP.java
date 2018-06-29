package com.risenb.thousandnight.ui.mine.minep;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.User;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/6/27.
 */

public class MineP extends PresenterBase {

    private MineFace face;

    public MineP(MineFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void getUserInfo() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().home(new HttpBack<User>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<User> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(User result) {
                dismissProgressDialog();
                application.setUserBean(result);
                face.setUserInfo(result);
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public interface MineFace {
        void setUserInfo(User result);
    }

}
