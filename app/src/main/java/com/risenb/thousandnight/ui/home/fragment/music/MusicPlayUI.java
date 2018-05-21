package com.risenb.thousandnight.ui.home.fragment.music;

import android.widget.ImageView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 音乐播放
 * Created by user on 2018/5/17.
 */

public class MusicPlayUI extends BaseUI {

    @BindView(R.id.iv_music_play_img)
    ImageView iv_music_play_img;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_music_play;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我们不一样");
    }

    @Override
    protected void prepareData() {

    }
}
