package com.risenb.thousandnight.ui.home.fragment.music;

import android.support.v4.app.FragmentActivity;

import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.network.HttpBack;
import com.risenb.thousandnight.network.NetworkUtils;
import com.risenb.thousandnight.ui.PresenterBase;

import java.util.ArrayList;

/**
 * Created by user on 2018/7/17.
 */

public class MusicSecondP extends PresenterBase {

    private MusicSecondFace face;

    public MusicSecondP(MusicSecondFace face, FragmentActivity activity) {
        this.face = face;
        setActivity(activity);
    }

    public void musicSheetList() {
        showProgressDialog();
        NetworkUtils.getNetworkUtils().musicSheetList(String.valueOf(face.getPageNo()), face.getPageSize(), face.getIsRecommend(), new HttpBack<MusicSheetBean>() {
            @Override
            public void onSuccess(String data) {
                dismissProgressDialog();
            }

            @Override
            public void onSuccess(ArrayList<MusicSheetBean> result) {
                dismissProgressDialog();
                if (face.getPageNo() == 1) {
                    face.setResult(result);
                } else {
                    face.addResult(result);
                }
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


    public interface MusicSecondFace {

        int getPageNo();

        String getPageSize();

        String getIsRecommend();

        void setResult(ArrayList<MusicSheetBean> result);

        void addResult(ArrayList<MusicSheetBean> result);
    }
}
