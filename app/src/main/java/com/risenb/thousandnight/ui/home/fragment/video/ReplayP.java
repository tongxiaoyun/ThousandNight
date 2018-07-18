package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.risenb.thousandnight.beans.CommentBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/18.
 */

public class ReplayP extends PresenterBase {

    private ReplayFace face;

    public ReplayP(ReplayFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void commentList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().videoCommentList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getVideoId(), new HttpBack<CommentBean>() {
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
        NetworkUtils.getNetworkUtils().addCommentVideo(face.getVideoId(), face.getCommentContent(), new HttpBack<Object>() {
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


    public interface ReplayFace {

        int getPageNo();

        String getPageSize();

        String getVideoId();

        void setResule(ArrayList<CommentBean> result);

        void addResult(ArrayList<CommentBean> result);

        String getCommentContent();

        void commentSuccess();

    }

}
