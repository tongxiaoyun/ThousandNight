package com.risenb.thousandnight.ui.square;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.SquareReportAdapter;
import com.risenb.thousandnight.ui.BaseUI;

import butterknife.BindView;

/**
 * 举报操作
 * Created by user on 2018/5/11.
 */

public class SquareReportUI extends BaseUI {

    @BindView(R.id.rv_square_report)
    RecyclerView rv_square_report;

    private SquareReportAdapter<Object> squareReportAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_square_report;
    }

    @Override
    protected void setControlBasis() {
        setTitle("举报操作");
        initAdapter();
    }

    @Override
    protected void prepareData() {

    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_square_report.setLayoutManager(linearLayoutManager);
        squareReportAdapter = new SquareReportAdapter<>();
        squareReportAdapter.setActivity(this);
        rv_square_report.setAdapter(squareReportAdapter);
    }

}
