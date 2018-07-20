package com.risenb.thousandnight.ui.found.dance;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.beans.DanceHallBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/20.
 */

public class DanceDetailP extends PresenterBase {

    private DanceDetailFace face;

    public DanceDetailP(DanceDetailFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void danceDetail() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().dancehallDetail(face.getDanceHallId(), face.getLongtitude(), face.getLatitude(), new HttpBack<DanceHallBean>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onSuccess(ArrayList<DanceHallBean> result) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(DanceHallBean result) {
                dismissProgressDialog();
                face.setResult(result);
            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }

        });
    }

    public void commentList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().dancehallCommentList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getDanceHallId(), new HttpBack<CommentBean>() {
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

    public void addComment() {
        if (TextUtils.isEmpty(face.getCommentContent())){
            makeText("评论内容不能为空");
            return;
        }
        showProgressDialog();
        NetworkUtils.getNetworkUtils().addFindDancerComment(face.getDanceHallId(), face.getCommentContent(), new HttpBack<Object>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
                face.commentSuccess();
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

    public interface DanceDetailFace {

        String getDanceHallId();

        String getLongtitude();

        String getLatitude();

        void setResult(DanceHallBean result);

        int getPageNo();

        String getPageSize();

        void setResule(ArrayList<CommentBean> result);

        void addResult(ArrayList<CommentBean> result);

        String getCommentContent();

        void commentSuccess();

    }

}
