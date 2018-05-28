package com.risenb.thousandnight.ui.mine.recruit;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.found.recruit.RecruitPostUI;

import butterknife.OnClick;

/**
 * 投递详情
 * Created by user on 2018/5/24.
 */

public class DeliverDetailUI extends BaseUI {

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_deliver_detail;
    }

    @Override
    protected void setControlBasis() {
        setTitle("拉丁舞教练");
    }

    @Override
    protected void prepareData() {

    }

    @OnClick(R.id.tv_deliver_detial_post)
    void toPost() {
        Intent intent = new Intent(getActivity(), RecruitPostUI.class);
        startActivity(intent);
    }
}
