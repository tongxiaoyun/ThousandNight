package com.risenb.thousandnight.ui.home.fragment;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.CourseListBean;
import com.risenb.thousandnight.beans.HomeHotVideoBean;
import com.risenb.thousandnight.beans.HomeSignBean;
import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/5/30.
 */

public class ChosenP extends PresenterBase {

    private ChosenFace face;

    public ChosenP(ChosenFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void videoListHot() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().videoListHot(new HttpBack<HomeHotVideoBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<HomeHotVideoBean> result) {
                dismissProgressDialog();

            }

            @Override
            public void onSuccess(HomeHotVideoBean result) {
                dismissProgressDialog();
                face.setHotVideo(result.getList());
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public void musicSheetList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().musicSheetList("", "", "1", new HttpBack<MusicSheetBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<MusicSheetBean> result) {
                dismissProgressDialog();
                face.setHotMusic(result);

            }

            @Override
            public void onSuccess(MusicSheetBean result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public void selectedList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().selectedList("1", "4", new HttpBack<CourseListBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<CourseListBean> result) {
                dismissProgressDialog();
                face.setCourse(result);
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


    public interface ChosenFace {
        void setHotVideo(ArrayList<VideoListBean> result);

        void setHotMusic(ArrayList<MusicSheetBean> result);

        void setCourse(ArrayList<CourseListBean> result);
    }

}
