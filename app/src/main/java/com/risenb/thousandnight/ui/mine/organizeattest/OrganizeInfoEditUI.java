package com.risenb.thousandnight.ui.mine.organizeattest;

import android.support.v7.widget.GridLayoutManager;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineOrganizeInfoEditAdapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;

/**
 * 机构简介编辑
 * Created by user on 2018/5/28.
 */

public class OrganizeInfoEditUI extends BaseUI {

    @BindView(R.id.mrv_organize_info_edit)
    MyRecyclerView mrv_organize_info_edit;

    private MineOrganizeInfoEditAdapter<Object> organizeInfoEditAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_organize_info_edit;
    }

    @Override
    protected void setControlBasis() {
        setTitle("机构简介");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mrv_organize_info_edit.setLayoutManager(gridLayoutManager);
        organizeInfoEditAdapter = new MineOrganizeInfoEditAdapter<>();
        organizeInfoEditAdapter.setActivity(this);
        mrv_organize_info_edit.setAdapter(organizeInfoEditAdapter);
    }

}
