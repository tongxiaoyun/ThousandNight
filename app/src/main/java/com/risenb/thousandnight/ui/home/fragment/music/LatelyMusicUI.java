package com.risenb.thousandnight.ui.home.fragment.music;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.LocalMusicAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/22
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class LatelyMusicUI extends BaseUI {

    @BindView(R.id.rv_lately_music)
    RecyclerView rv_lately_music;
    private LocalMusicAdapter<Object> localMusicAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_lately_music;
    }

    @Override
    protected void setControlBasis() {
        setTitle("最近播放的");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_lately_music.setLayoutManager(linearLayoutManager);
        localMusicAdapter = new LocalMusicAdapter<>();
        localMusicAdapter.setActivity(getActivity());
        rv_lately_music.setAdapter(localMusicAdapter);
    }
}
