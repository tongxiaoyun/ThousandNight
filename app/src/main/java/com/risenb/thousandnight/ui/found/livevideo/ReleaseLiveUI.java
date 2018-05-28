package com.risenb.thousandnight.ui.found.livevideo;

import android.content.Intent;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/27
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ReleaseLiveUI extends BaseUI {
    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_release_live;
    }

    @Override
    protected void setControlBasis() {
        setTitle("发布直播");
        backGone();
        leftVisible("取消");
    }

    @Override
    protected void prepareData() {

    }

    @OnClick(R.id.ll_left)
    void  left(){
        back();
    }

    @OnClick(R.id.tv_release_live_confirm)
    void confirm(){
        Intent intent = new Intent(getActivity(),LivePlayUI.class);
        startActivity(intent);
    }
}
