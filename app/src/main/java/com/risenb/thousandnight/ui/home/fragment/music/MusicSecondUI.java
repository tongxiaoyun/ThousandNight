package com.risenb.thousandnight.ui.home.fragment.music;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeMusicAdapter;
import com.risenb.thousandnight.adapter.SecondMusicAdapter;
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
public class MusicSecondUI extends BaseUI {

    @BindView(R.id.rv_music_second)
    XRecyclerView rv_music_second;
    private SecondMusicAdapter<Object> homeMusicAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_music_second;
    }

    @Override
    protected void setControlBasis() {
        setTitle(getIntent().getStringExtra("title"));
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 3);
        rv_music_second.setLayoutManager(linearLayoutManager);
        homeMusicAdapter = new SecondMusicAdapter<>();
        homeMusicAdapter.setActivity(getActivity());
        rv_music_second.setAdapter(homeMusicAdapter);
        homeMusicAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), SongSheetUI.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
