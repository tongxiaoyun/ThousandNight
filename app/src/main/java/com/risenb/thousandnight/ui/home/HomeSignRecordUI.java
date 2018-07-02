package com.risenb.thousandnight.ui.home;

import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.HomeSignBean;
import com.risenb.thousandnight.beans.SignBean;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.SignCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;

/**
 * 签到记录
 * Created by user on 2018/5/18.
 */

public class HomeSignRecordUI extends BaseUI implements HomeSignRecordP.HomeSignRecordFace {
    private HomeSignRecordP homeSignRecordP;

    @BindView(R.id.tv_home_sign_continue)
    TextView tv_home_sign_continue;

    @BindView(R.id.tv_home_sign_current)
    TextView tv_home_sign_current;

    @BindView(R.id.tv_home_sign_is)
    TextView tv_home_sign_is;

    @BindView(R.id.tv_home_sign_time)
    TextView tv_home_sign_time;

    @BindView(R.id.scv_sign)
    SignCalendarView scv_sign;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_sign_record;
    }

    @Override
    protected void setControlBasis() {
        setTitle("签到记录");
        homeSignRecordP = new HomeSignRecordP(this, getActivity());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String timeStr = sdf.format(new Date());
        tv_home_sign_current.setText(timeStr);
        tv_home_sign_time.setText(timeStr);
        homeSignRecordP.signInfo();
        homeSignRecordP.signRecord();
    }

    @Override
    protected void prepareData() {

    }

    @Override
    public void setSign(HomeSignBean result) {
        tv_home_sign_continue.setText(result.getContinueSignDays());
        if (result.isSign()) {
            tv_home_sign_is.setText("今日已签到");
        } else {
            tv_home_sign_is.setText("今日未签到");
        }
    }

    @Override
    public void setSignList(ArrayList<SignBean> result) {
        scv_sign.setSign(result);
    }

    @Override
    public void signSuccess() {

    }
}
