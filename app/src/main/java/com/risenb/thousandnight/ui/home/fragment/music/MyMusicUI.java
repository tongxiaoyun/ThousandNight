package com.risenb.thousandnight.ui.home.fragment.music;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MyMusicAdapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/22
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MyMusicUI extends BaseUI {

    @BindView(R.id.mrv_my_music)
    MyRecyclerView mrv_my_music;
    private MyMusicAdapter<Object> myMusicAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_my_music;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我的音乐");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_my_music.setLayoutManager(linearLayoutManager);

        myMusicAdapter = new MyMusicAdapter<>();
        myMusicAdapter.setActivity(getActivity());
        mrv_my_music.setAdapter(myMusicAdapter);
    }


    @OnClick(R.id.tv_my_music_local)
    void toLocal() {
        Intent intent = new Intent(getActivity(), LocalMusicUI.class);
        startActivity(intent);
    }
    @OnClick(R.id.tv_my_music_late)
    void toLate() {
        Intent intent = new Intent(getActivity(), LatelyMusicUI.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_my_music_collect)
    void toCollect() {
        Intent intent = new Intent(getActivity(), MusicCollectUI.class);
        startActivity(intent);
    }
}
