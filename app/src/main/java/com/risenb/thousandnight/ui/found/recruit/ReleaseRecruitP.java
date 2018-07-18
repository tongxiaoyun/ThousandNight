package com.risenb.thousandnight.ui.found.recruit;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/3.
 */

public class ReleaseRecruitP extends PresenterBase {

    private ReleaseRecruitFace face;

    public ReleaseRecruitP(ReleaseRecruitFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void addPosition() {
        if (TextUtils.isEmpty(face.getPositionName())) {
            makeText("职位名称不能为空");
            return;
        }
        if (TextUtils.isEmpty(face.getPositionType())) {
            makeText("请选择职位类型");
            return;
        }
        if (TextUtils.isEmpty(face.getWorkYears())) {
            makeText("请选择工作年限");
            return;
        }
        if (TextUtils.isEmpty(face.getPositionGrade())) {
            makeText("请选择职位等级");
            return;
        }
        if (TextUtils.isEmpty(face.getPositionType())) {
            makeText("请选择工作地点");
            return;
        }
        if (TextUtils.isEmpty(face.getSalaryType())) {
            makeText("请选择期望薪资");
            return;
        }
        if ("1".equals(face.getSalaryType())){
            if (TextUtils.isEmpty(face.getSalaryBegin())) {
                makeText("最低薪资不能为空");
                return;
            }
            if (TextUtils.isEmpty(face.getSalaryEnd())) {
                makeText("最高薪资不能为空");
                return;
            }
        }
        if (TextUtils.isEmpty(face.getPositionDesc())) {
            makeText("职位描述不能为空");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().addPosition(face.getPositionName(), face.getPositionType(), face.getTypeName(), face.getWorkYears(), face.getYearsName(), face.getPositionGrade(),
                face.getGradeName(), face.getProvinceId(), face.getProvinceName(), face.getCityId(), face.getCityName(), face.getAreaId(), face.getAreaName(), face.getSalaryType(),
                face.getSalaryBegin(), face.getSalaryEnd(), face.getPositionDesc(), new HttpBack<Object>() {
                    @Override
                    public void onSuccess(String data) {
                        dismissProgressDialog();
                        getActivity().finish();
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

    public interface ReleaseRecruitFace {

        String getPositionName();

        String getPositionType();

        String getTypeName();

        String getWorkYears();

        String getYearsName();

        String getPositionGrade();

        String getGradeName();

        String getProvinceId();

        String getProvinceName();

        String getCityId();

        String getCityName();

        String getAreaId();

        String getAreaName();

        String getSalaryType();

        String getSalaryBegin();

        String getSalaryEnd();

        String getPositionDesc();

    }

}
