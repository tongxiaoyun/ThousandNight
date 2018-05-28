package com.risenb.thousandnight.ui.mine.organizeattest;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.Image2Adapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 机构简介已维护
 * Created by user on 2018/5/25.
 */

public class OrganizeMaintenanceUI extends BaseUI {

    @BindView(R.id.mrv_organize_maintenance)
    MyRecyclerView mrv_organize_maintenance;

    private Image2Adapter<Object> image2Adapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_organize_maintenance;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构简介");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mrv_organize_maintenance.setLayoutManager(linearLayoutManager);
        image2Adapter = new Image2Adapter<>();
        image2Adapter.setActivity(this);
        mrv_organize_maintenance.setAdapter(image2Adapter);
    }

    /**
     * 编辑
     */
    @OnClick(R.id.tv_maintenance_edit)
    void edit() {
        Intent intent = new Intent(OrganizeMaintenanceUI.this, OrganizeInfoEditUI.class);
        startActivity(intent);
    }

}
