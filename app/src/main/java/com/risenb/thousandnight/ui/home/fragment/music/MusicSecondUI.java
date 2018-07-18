package com.risenb.thousandnight.ui.home.fragment.music;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.expand.xrecyclerview.adapter.BaseRecyclerAdapter;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.HomeMusicAdapter;
import com.risenb.thousandnight.beans.MusicSheetBean;
import com.risenb.thousandnight.ui.BaseUI;

import java.util.ArrayList;

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
public class MusicSecondUI extends BaseUI implements XRecyclerView.LoadingListener, MusicSecondP.MusicSecondFace {

    @BindView(R.id.rv_music_second)
    XRecyclerView rv_music_second;

    private HomeMusicAdapter<MusicSheetBean> homeMusicAdapter;
    private int page = 1;

    private MusicSecondP musicSecondP;
    private String isRecommend = "";

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
        isRecommend = getIntent().getStringExtra("isRecommend");
        musicSecondP = new MusicSecondP(this, getActivity());
    }

    @Override
    protected void prepareData() {
        musicSecondP.musicSheetList();
    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 3);
        rv_music_second.setLayoutManager(linearLayoutManager);
        homeMusicAdapter = new HomeMusicAdapter<>();
        homeMusicAdapter.setActivity(getActivity());
        rv_music_second.setAdapter(homeMusicAdapter);
        rv_music_second.setLoadingListener(this);
        homeMusicAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(getActivity(), SongSheetUI.class);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onRefresh() {
        page = 1;
        musicSecondP.musicSheetList();
    }

    @Override
    public void onLoadMore() {
        page++;
        musicSecondP.musicSheetList();
    }

    @Override
    public int getPageNo() {
        return page;
    }

    @Override
    public String getPageSize() {
        return "18";
    }

    @Override
    public String getIsRecommend() {
        if ("1".equals(isRecommend)){
            return "1";
        } else {
            return "";
        }
    }

    @Override
    public void setResult(ArrayList<MusicSheetBean> result) {
        homeMusicAdapter.setList(result);
        rv_music_second.refreshComplete();
    }

    @Override
    public void addResult(ArrayList<MusicSheetBean> result) {
        homeMusicAdapter.addList(result);
        rv_music_second.loadMoreComplete();
    }
}
