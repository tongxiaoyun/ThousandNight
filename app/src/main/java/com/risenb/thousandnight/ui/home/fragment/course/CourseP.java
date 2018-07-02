package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.ClassBean;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.beans.HomeHotVideoBean;
import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/30.
 */

public class CourseP extends PresenterBase {

    private CourseFace face;

    public CourseP(CourseFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void classifyList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().classifyList("1", new HttpBack<ClassBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<ClassBean> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ClassBean result) {
                dismissProgressDialog();
                face.setClassResult(result);
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public interface CourseFace {

        void setClassResult(ClassBean result);
    }

}
