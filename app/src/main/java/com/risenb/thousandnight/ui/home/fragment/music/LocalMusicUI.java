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
public class LocalMusicUI extends BaseUI {

    @BindView(R.id.rv_local_music)
    RecyclerView rv_local_music;
    private LocalMusicAdapter<Object> localMusicAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_local_music;
    }

    @Override
    protected void setControlBasis() {
        setTitle("本地音乐");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_local_music.setLayoutManager(linearLayoutManager);
        localMusicAdapter = new LocalMusicAdapter<>();
        localMusicAdapter.setActivity(getActivity());
        rv_local_music.setAdapter(localMusicAdapter);
    }
}
