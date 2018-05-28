package com.risenb.thousandnight.ui.mine.organizeattest;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 机构认证中
 * Created by user on 2018/5/25.
 */

public class AttestingUI extends BaseUI {

    @BindView(R.id.iv_organize_attesting)
    ImageView iv_organize_attesting;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_attesting;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构认证");
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        iv_organize_attesting.startAnimation(animation);
    }

    @Override
    protected void prepareData() {

    }
}
