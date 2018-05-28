package com.risenb.thousandnight.ui.mine.home.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineOrganizeIntroAdapter;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.mine.recruit.RecruitUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 机构简介
 * Created by user on 2018/5/28.
 */

public class OrganizeIntroFragment extends BaseFragment {

    @BindView(R.id.mrv_organize_intro)
    MyRecyclerView mrv_organize_intro;

    private MineOrganizeIntroAdapter<Object> mineOrganizeIntroAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_mine_organize_intro, container, false);
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mrv_organize_intro.setLayoutManager(linearLayoutManager);
        mineOrganizeIntroAdapter = new MineOrganizeIntroAdapter<>();
        mineOrganizeIntroAdapter.setActivity(getActivity());
        mrv_organize_intro.setAdapter(mineOrganizeIntroAdapter);
    }

    @OnClick(R.id.ll_organize_intro_recruit)
    void recruit() {
        Intent intent = new Intent(getActivity(), RecruitUI.class);
        intent.putExtra("ui", "招聘");
        startActivity(intent);
    }

}
