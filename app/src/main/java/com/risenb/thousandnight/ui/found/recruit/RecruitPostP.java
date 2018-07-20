package com.risenb.thousandnight.ui.found.recruit;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by user on 2018/7/20.
 */

public class RecruitPostP extends PresenterBase {

    private RecruitPostFace face;

    public RecruitPostP(RecruitPostFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void addPositoinDelivery() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().addPositoinDelivery(face.getPositionId(), face.getDeliveryInfo(), face.getVideo(), new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
                face.postSuccess();
            }

            @Override
            public void onSuccess(ArrayList<Object> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(Object result) {

            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }

        });
    }

    public interface RecruitPostFace {

        String getPositionId();

        String getDeliveryInfo();

        File getVideo();

        void postSuccess();

    }

}
