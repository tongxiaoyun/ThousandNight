package com.risenb.thousandnight.ui.found.news.fragment;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.NewsBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/6/30.
 */

public class NewsChildP extends PresenterBase {

    private NewsChildFace face;

    public NewsChildP(NewsChildFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void newsList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().newsList(face.getType(), face.getKeyword(), String.valueOf(face.getPageNo()), face.getPageSize(), new HttpBack<NewsBean>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onSuccess(ArrayList<NewsBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setResult(result);
                } else {
                    face.addResult(result);
                }
            }

            @Override
            public void onSuccess(NewsBean result) {

            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }

        });
    }

    public interface NewsChildFace {

        int getPageNo();

        String getPageSize();

        String getType();

        String getKeyword();

        void setResult(ArrayList<NewsBean> result);

        void addResult(ArrayList<NewsBean> result);

    }

}
