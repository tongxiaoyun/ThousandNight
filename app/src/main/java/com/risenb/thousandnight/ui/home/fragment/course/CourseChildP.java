package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.ClassBean;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/30.
 */

public class CourseChildP extends PresenterBase {

    private CourseFace face;

    public CourseChildP(CourseFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void classifyList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().courseList(face.getParamId(), face.getTeacherId(), face.getOrderField(), face.getOrderDirection(), String.valueOf(face.getPageNo()), face.getPageSize(), new HttpBack<CourseListBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<CourseListBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setList(result);
                } else {
                    face.addList(result);
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


    public interface CourseFace {

        String getParamId();

        String getTeacherId();

        String getOrderField();

        String getOrderDirection();

        int getPageNo();

        String getPageSize();

        void setList(ArrayList<CourseListBean> result);

        void addList(ArrayList<CourseListBean> result);
    }

}
