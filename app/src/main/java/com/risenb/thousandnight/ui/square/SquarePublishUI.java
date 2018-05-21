package com.risenb.thousandnight.ui.square;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.SquarePublishAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发布
 * Created by user on 2018/5/11.
 */

public class SquarePublishUI extends BaseUI {

    @BindView(R.id.rv_publish)
    RecyclerView rv_publish;

    private SquarePublishAdapter<Object> squarePublishAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_square_publish;
    }

    @Override
    protected void setControlBasis() {
        setTitle("发布");
        backGone();
        rightVisible("发布");
        leftVisible("取消");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_publish.setLayoutManager(gridLayoutManager);
        squarePublishAdapter = new SquarePublishAdapter<>();
        squarePublishAdapter.setActivity(this);
        rv_publish.setAdapter(squarePublishAdapter);
    }

    @OnClick(R.id.ll_left)
    void getBack() {
        finish();
    }

    /**
     * 隐私
     */
    @OnClick(R.id.ll_publish_secret)
    void secret() {
        Intent intent = new Intent(SquarePublishUI.this, SquareSecretUI.class);
        startActivity(intent);
    }

}
