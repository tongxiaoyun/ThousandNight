package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/17.
 */

public class ChoiceCourseP extends PresenterBase {

    private ChoiceCourseFace face;

    public ChoiceCourseP(ChoiceCourseFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void selectedList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().selectedList(String.valueOf(face.getPageNo()), face.getPageSize(), new HttpBack<CourseListBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<CourseListBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setResult(result);
                } else {
                    face.addResult(result);
                }
            }

            @Override
            public void onSuccess(CourseListBean result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public interface ChoiceCourseFace {

        int getPageNo();

        String getPageSize();

        void setResult(ArrayList<CourseListBean> result);

        void addResult(ArrayList<CourseListBean> result);
    }

}
