package com.risenb.thousandnight.ui.home.fragment.music;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.pop.MusicPlayPopUtils;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.utils.GlideRoundTransform;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 音乐播放
 * Created by user on 2018/5/17.
 */

public class MusicPlayUI extends BaseUI {

    @BindView(R.id.iv_music_play_img)
    ImageView iv_music_play_img;

    @BindView(R.id.iv_music_play_cover)
    ImageView iv_music_play_cover;
    private MusicPlayPopUtils musicPlayPopUtils;

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
        Glide.with(getActivity())
                .load("http://img4.imgtn.bdimg.com/it/u=254618362,2906926008&fm=200&gp=0.jpg")
                .dontAnimate()
                // 设置高斯模糊
                .bitmapTransform(new BlurTransformation(this, 14, 3))
                .into(iv_music_play_img);

        Glide.with(getActivity())
                .load("http://img4.imgtn.bdimg.com/it/u=254618362,2906926008&fm=200&gp=0.jpg")
                .dontAnimate()
                // 设置高斯模糊
                .bitmapTransform(new GlideRoundTransform(getActivity()))
                .into(iv_music_play_cover);

        Animation circle_anim = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_round_rotate);
        LinearInterpolator interpolator = new LinearInterpolator();  //设置匀速旋转，在xml文件中设置会出现卡顿
        circle_anim.setInterpolator(interpolator);
        if (circle_anim != null) {
            iv_music_play_cover.startAnimation(circle_anim);  //开始动画
        }
    }

    @Override
    protected void prepareData() {
        initPop();
    }


    private void initPop(){
        musicPlayPopUtils = new MusicPlayPopUtils(iv_music_play_img,getActivity(),R.layout.pop_music_play);
    }

    @OnClick(R.id.iv_music_play_show)
    void show(){
        musicPlayPopUtils.showAtLocation();
    }
}
