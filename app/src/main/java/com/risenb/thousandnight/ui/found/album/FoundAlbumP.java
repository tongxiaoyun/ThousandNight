package com.risenb.thousandnight.ui.found.album;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.AlbumBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/6/30.
 */

public class FoundAlbumP extends PresenterBase {

    private FoundAlbumFace face;

    public FoundAlbumP(FoundAlbumFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void albumList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().albumList(String.valueOf(face.getPageNo()), face.getPageSize(), new HttpBack<AlbumBean>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onSuccess(ArrayList<AlbumBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setResult(result);
                } else {
                    face.addResult(result);
                }
            }

            @Override
            public void onSuccess(AlbumBean result) {

            }

            @Override
            public void onFailure(String error_code, String error_msg) {
                dismissProgressDialog();
                makeText(error_msg);
            }

        });
    }

    public interface FoundAlbumFace {

        int getPageNo();

        String getPageSize();

        void setResult(ArrayList<AlbumBean> result);

        void addResult(ArrayList<AlbumBean> result);

    }
}
