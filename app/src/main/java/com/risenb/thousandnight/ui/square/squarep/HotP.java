package com.risenb.thousandnight.ui.square.squarep;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.MomentBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/6/30.
 */

public class HotP extends PresenterBase {

    private HotFace face;

    public HotP(HotFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void momentList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().momentList(face.getTargetId(), face.getType(), face.getLat(), face.getLng(), String.valueOf(face.getPageNo()), face.getPageSize(), new HttpBack<MomentBean>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onSuccess(ArrayList<MomentBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setResult(result);
                } else {
                    face.addResult(result);
                }
            }

            @Override
            public void onSuccess(MomentBean result) {

            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }

        });
    }

    public interface HotFace {

        int getPageNo();

        String getPageSize();

        String getType();

        String getLat();

        String getLng();

        String getTargetId();

        void setResult(ArrayList<MomentBean> result);

        void addResult(ArrayList<MomentBean> result);

    }

}
