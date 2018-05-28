package com.risenb.thousandnight.ui.mine.home.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.Image2Adapter;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 活动
 * Created by user on 2018/5/28.
 */

public class CampaignFragment extends BaseFragment {

    @BindView(R.id.xrv_home_campaign)
    XRecyclerView xrv_home_campaign;

    private Image2Adapter<Object> image2Adapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_mine_home_campaign, container, false);
    }

    @Override
    protected void setControlBasis() {
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        xrv_home_campaign.setLayoutManager(gridLayoutManager);
        image2Adapter = new Image2Adapter<>();
        image2Adapter.setActivity(getActivity());
        xrv_home_campaign.setAdapter(image2Adapter);
    }
}
