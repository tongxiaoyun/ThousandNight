package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.HomeHotVideoBean;
import com.risenb.thousandnight.beans.VideoListBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/17.
 */

public class VideoChildP extends PresenterBase {

    private VideoChildFace face;

    public VideoChildP(VideoChildFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void videoList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().videoList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getIsHot(), face.getParamId(), face.getParentId(), face.getOrderField(), face.getOrderDirection(), new HttpBack<HomeHotVideoBean>() {
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
                if (face.getPageNo() == 1) {
                    face.setResule(result.getList());
                } else {
                    face.addResult(result.getList());
                }
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }

    public void videoCollect(String videoId, String type) {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().addOrCancleLikeVideo(videoId, type, new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
                face.collectSuccess();
            }

            @Override
            public void onSuccess(ArrayList<Object> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(Object result) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                makeText(error_msg);
                dismissProgressDialog();
            }
        });
    }


    public interface VideoChildFace {

        int getPageNo();

        String getPageSize();

        String getIsHot();

        String getParamId();

        String getParentId();

        String getOrderField();

        String getOrderDirection();

        void setResule(ArrayList<VideoListBean> result);

        void addResult(ArrayList<VideoListBean> result);

        void collectSuccess();

    }
}
