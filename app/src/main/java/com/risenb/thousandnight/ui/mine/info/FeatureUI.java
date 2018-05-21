package com.risenb.thousandnight.ui.mine.info;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineFeatureAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 特长
 * Created by user on 2018/5/9.
 */

public class FeatureUI extends BaseUI {

    @BindView(R.id.rv_feature)
    RecyclerView rv_feature;

    private MineFeatureAdapter<Object> mineFeatureAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_feature;
    }

    @Override
    protected void setControlBasis() {
        setTitle("特长");
        rightVisible("确定");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_feature.setLayoutManager(linearLayoutManager);
        mineFeatureAdapter = new MineFeatureAdapter<>();
        mineFeatureAdapter.setActivity(this);
        rv_feature.setAdapter(mineFeatureAdapter);
    }

}
