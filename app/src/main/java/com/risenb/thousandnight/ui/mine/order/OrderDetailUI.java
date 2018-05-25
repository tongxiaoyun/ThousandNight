package com.risenb.thousandnight.ui.mine.order;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.MineOrderChildAdapter;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.views.MyRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 订单详情
 * Created by user on 2018/5/21.
 */

public class OrderDetailUI extends BaseUI {

    @BindView(R.id.mrv_order_detail)
    MyRecyclerView mrv_order_detail;

    @BindView(R.id.ll_order_detail_pay1)
    LinearLayout ll_order_detail_pay1;

    @BindView(R.id.ll_order_detail_pay2)
    LinearLayout ll_order_detail_pay2;

    private MineOrderChildAdapter<Object> mineOrderChildAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_order_detail;
    }

    @Override
    protected void setControlBasis() {
        setTitle("订单详情");
        initAdapter();
        if ("1".equals(getIntent().getStringExtra("pay"))){
            ll_order_detail_pay1.setVisibility(View.VISIBLE);
            ll_order_detail_pay2.setVisibility(View.GONE);
        } else if ("2".equals(getIntent().getStringExtra("pay"))){
            ll_order_detail_pay1.setVisibility(View.GONE);
            ll_order_detail_pay2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_order_detail.setLayoutManager(linearLayoutManager);
        mineOrderChildAdapter = new MineOrderChildAdapter<>();
        mineOrderChildAdapter.setActivity(this);
        mineOrderChildAdapter.setUI("detail");
        mrv_order_detail.setAdapter(mineOrderChildAdapter);
    }

    @OnClick(R.id.tv_order_detail_weixin)
    void detail(){
        Intent intent = new Intent(OrderDetailUI.this, OrderDetailUI.class);
        intent.putExtra("pay", "2");
        startActivity(intent);
    }

    /**
     * 立即评论
     */
    @OnClick(R.id.tv_order_detail_comment)
    void comment(){
        Intent intent = new Intent(OrderDetailUI.this, OrderCommentUI.class);
        startActivity(intent);
    }

}
