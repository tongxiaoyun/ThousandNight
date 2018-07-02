package com.risenb.thousandnight.ui.found.recruit;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.PositonBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/2.
 */

public class FoundRecruitP extends PresenterBase {

    private FoundRecruitFace face;

    public FoundRecruitP(FoundRecruitFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void positionList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().positionList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getProvinceId(), face.getCityId(), face.getAreaId(), face.getPositionType(),
                face.getWorkYears(), face.getPositionGrade(), face.getSalaryType(), face.getSalaryBegin(), face.getSalaryEnd(), new HttpBack<PositonBean>() {
                    @Override
                    public void onSuccess(String data) {

                    }

                    @Override
                    public void onSuccess(ArrayList<PositonBean> result) {
                        dismissProgressDialog();
                        if (face.getPageNo() == 1) {
                            face.setResult(result);
                        } else {
                            face.addResult(result);
                        }
                    }

                    @Override
                    public void onSuccess(PositonBean result) {

                    }

                    @Override
                    public void onFailure(String error_code, String error_msg) {
                        dismissProgressDialog();
                        makeText(error_msg);
                    }

                });
    }

    public interface FoundRecruitFace {

        int getPageNo();

        String getPageSize();

        String getProvinceId();

        String getCityId();

        String getAreaId();

        String getPositionType();

        String getWorkYears();

        String getPositionGrade();

        String getSalaryType();

        String getSalaryBegin();

        String getSalaryEnd();

        void setResult(ArrayList<PositonBean> result);

        void addResult(ArrayList<PositonBean> result);

    }

}
