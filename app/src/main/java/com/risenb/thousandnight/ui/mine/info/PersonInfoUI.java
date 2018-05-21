package com.risenb.thousandnight.ui.mine.info;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 资料
 * Created by user on 2018/5/7.
 */

public class PersonInfoUI extends BaseUI {

    @BindView(R.id.tfl_personinfo_feature)
    TagFlowLayout tfl_personinfo_feature;

    private List<String> features = new ArrayList<String>();

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_personinfo;
    }

    @Override
    protected void setControlBasis() {
        setTitle("编辑资料");
        rightVisible("保存");
    }

    @Override
    protected void prepareData() {
        features.add("科班出身");
        features.add("漂亮");
        features.add("活泼");
        tfl_personinfo_feature.setAdapter(new TagAdapter<String>(features) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv_hot_word = (TextView) LayoutInflater.from(PersonInfoUI.this).inflate(R.layout.item_mine_personinfo,
                        tfl_personinfo_feature, false);
                tv_hot_word.setText(s);
                return tv_hot_word;
            }
        });
    }

    /**
     * 特长
     */
    @OnClick(R.id.ll_personinfo_feature)
    void getFeature() {
        Intent intent = new Intent(PersonInfoUI.this, FeatureUI.class);
        startActivity(intent);
    }

}
