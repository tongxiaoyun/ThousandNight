package com.risenb.thousandnight.ui.found;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.risenb.expand.xrecyclerview.XRecyclerView;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.FoundAdapter;
import com.risenb.thousandnight.ui.BaseFragment;

import butterknife.BindView;

/**
 * 发现
 * Created by user on 2018/5/4.
 */

public class FoundFragment extends BaseFragment {

    @BindView(R.id.xrv_found)
    XRecyclerView xrv_found;

    private FoundAdapter<Object> foundAdapter;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_found, container, false);
    }

    @Override
    protected void setControlBasis() {
        setTitle("发现");
        backGone();
        rightVisible(R.drawable.found_search);
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv_found.setLayoutManager(linearLayoutManager);
        foundAdapter = new FoundAdapter<>();
        foundAdapter.setActivity(getActivity());
        foundAdapter.setmHeaderCount(1);
        xrv_found.setAdapter(foundAdapter);
    }

}
