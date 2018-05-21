package com.risenb.thousandnight.ui.square.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 附近
 * Created by user on 2018/5/11.
 */

public class NearbyFragment extends BaseFragment {

    @BindView(R.id.xrv_common)
    XRecyclerView xrv_common;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_common_fragment, container, false);
    }

    @Override
    protected void setControlBasis() {

    }

    @Override
    protected void prepareData() {

    }

}
