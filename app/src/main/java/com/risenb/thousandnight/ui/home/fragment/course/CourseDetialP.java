package com.risenb.thousandnight.ui.home.fragment.course;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.CourseDetialBean;
import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/30.
 */

public class CourseDetialP extends PresenterBase {

    private CourseDetialFace face;

    public CourseDetialP(CourseDetialFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void courseDetail() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().courseDetail(face.getCourseId(), new HttpBack<CourseDetialBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<CourseDetialBean> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(CourseDetialBean result) {
                dismissProgressDialog();
                face.setCourse(result);
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public void commentList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().courseCommentList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getCourseId(), new HttpBack<CommentBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<CommentBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setResule(result);
                } else {
                    face.addResult(result);
                }
            }

            @Override
            public void onSuccess(CommentBean result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public interface CourseDetialFace {

        String getCourseId();

        void setCourse(CourseDetialBean result);

        int getPageNo();

        String getPageSize();

        void setResule(ArrayList<CommentBean> result);

        void addResult(ArrayList<CommentBean> result);


    }

}
