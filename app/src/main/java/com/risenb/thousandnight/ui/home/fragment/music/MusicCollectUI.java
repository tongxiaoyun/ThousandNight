package com.risenb.thousandnight.ui.home.fragment.music;

import android.support.v7.widget.LinearLayoutManager;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MusicCollectAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/23
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MusicCollectUI extends BaseUI {

    @BindView(R.id.xrv_music_collect)
    XRecyclerView xrv_music_collect;
    private MusicCollectAdapter<Object> musicCollectAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_music_collect;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我的收藏");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_music_collect.setLayoutManager(linearLayoutManager);
        musicCollectAdapter = new MusicCollectAdapter<>();
        musicCollectAdapter.setActivity(getActivity());
        xrv_music_collect.setAdapter(musicCollectAdapter);
    }
}
