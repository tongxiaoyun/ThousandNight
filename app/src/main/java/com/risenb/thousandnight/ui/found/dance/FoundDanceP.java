package com.risenb.thousandnight.ui.found.dance;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.DanceHallBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/3.
 */

public class FoundDanceP extends PresenterBase {

    private FoundDanceFace face;

    public FoundDanceP(FoundDanceFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void positionList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().dancehallList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getLongitude(), face.getLatitude(), face.getProvinceId(), face.getDanceFirst(),
                face.getDancePartenerType(), new HttpBack<DanceHallBean>() {
                    @Override
                    public void onSuccess(String data) {

                    }

                    @Override
                    public void onSuccess(ArrayList<DanceHallBean> result) {
                        dismissProgressDialog();
                        if (face.getPageNo() == 1) {
                            face.setResult(result);
                        } else {
                            face.addResult(result);
                        }
                    }

                    @Override
                    public void onSuccess(DanceHallBean result) {

                    }

                    @Override
                    public void onFailure(String error_code, String error_msg) {
                        dismissProgressDialog();
                        makeText(error_msg);
                    }

                });
    }

    public interface FoundDanceFace {

        int getPageNo();

        String getPageSize();

        String getLongitude();

        String getLatitude();

        String getProvinceId();

        String getDanceFirst();

        String getDancePartenerType();

        void setResult(ArrayList<DanceHallBean> result);

        void addResult(ArrayList<DanceHallBean> result);

    }

}
