package com.risenb.thousandnight.ui.mine.recruit;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/2.
 */

public class DeliverDetailP extends PresenterBase {

    private DeliverDetailFace face;

    public DeliverDetailP(DeliverDetailFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void positionDetail() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().positionDetail(face.getPositionId(), new HttpBack<PositonBean>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onSuccess(ArrayList<PositonBean> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(PositonBean result) {
                dismissProgressDialog();
                face.setResult(result);
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }

        });
    }

    public interface DeliverDetailFace {

        String getPositionId();

        void setResult(PositonBean result);

    }

}
