package com.risenb.thousandnight.ui.home.fragment.music;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.LocalMusicAdapter;
import com.risenb.thousandnight.pop.AddSheetPopUtils;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/24
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class SongSheetUI extends BaseUI implements View.OnClickListener {

    @BindView(R.id.rv_local_music)
    RecyclerView rv_local_music;
    private LocalMusicAdapter<Object> localMusicAdapter;
    private AddSheetPopUtils addSheetPopUtils;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_song_sheet;
    }

    @Override
    protected void setControlBasis() {
        setTitle("歌单");
        initAdapter();
        addSheetPopUtils = new AddSheetPopUtils(rv_local_music,getActivity(),R.layout.pop_add_sheet);
        addSheetPopUtils.setOnClickListener(this);
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

    @OnClick(R.id.tv_song_sheet_add)
    void addSheet(){
        addSheetPopUtils.showAtLocation();
    }

    @OnClick(R.id.tv_song_sheet_collect)
    void toCollect(){
        Intent intent = new Intent(getActivity(), MusicCollectUI.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), AddSheetUI.class);
        startActivity(intent);
    }
}
