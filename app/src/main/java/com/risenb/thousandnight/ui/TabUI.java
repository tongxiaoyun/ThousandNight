package com.risenb.thousandnight.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.risenb.expand.utils.DisplayUtil;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.adapter.TabAdapter;
import com.risenb.thousandnight.enums.EnumTAB;
import com.risenb.thousandnight.enums.EnumUtils;
import com.risenb.thousandnight.views.MyViewPager;

import butterknife.BindView;

/**
 * 描述：导航
 *
 * @author wanjian
 */
public class TabUI extends BaseUI implements OnClickListener {
    private static TabUI tabUI;

    @BindView(R.id.mvp_tab)
    MyViewPager vp_tab;

    @Override
    protected void back() {
        exit();
    }

    @Override
    protected void setControlBasis() {
        tabUI = this;
        Drawable drawable;

        int right = DisplayUtil.getDimen(R.dimen.dm040);
        int bottom = DisplayUtil.getDimen(R.dimen.dm040);
        EnumTAB[] enumArr = EnumTAB.values();
        for (int i = 0; i < enumArr.length; i++) {

            enumArr[i].setRadioButton((RadioButton) findViewById(enumArr[i].getId()));
            enumArr[i].getRadioButton().setOnClickListener(this);
            enumArr[i].getRadioButton().setText(enumArr[i].getTitle());
            drawable = getResources().getDrawable(enumArr[i].getDrawable());
            drawable.setBounds(0, 0, right, bottom);
            enumArr[i].getRadioButton().setCompoundDrawables(null, drawable, null, null);
        }
        setSwipeBackEnable(false);
        vp_tab.setOffscreenPageLimit(5);

    }

    @Override
    protected void prepareData() {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        vp_tab.setAdapter(tabAdapter);
        vp_tab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                EnumTAB[] enumArr = EnumTAB.values();
                for (int i = 0; i < enumArr.length; i++) {
                    enumArr[i].getRadioButton().setChecked(i == position);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    @Override
    protected int getLayout() {
        return R.layout.ui_tab;
    }


    @Override
    public void onClick(View v) {

        EnumTAB[] enumArr = EnumTAB.values();
        for (int i = 0; i < enumArr.length; i++) {
            if (enumArr[i].getId() == v.getId()) {
                setCurrentTabByTag(enumArr[i]);
                break;
            }
        }
    }

    public void setCurrentTabByTag(EnumTAB enumTab) {
        EnumTAB[] enumArr = EnumTAB.values();
        for (int i = 0; i < enumArr.length; i++) {
            enumArr[i].getRadioButton().setChecked(enumArr[i] == enumTab);
        }
        vp_tab.setCurrentItem(EnumUtils.getEnumUtils().getIdx(enumTab), false);
    }

    public static TabUI getTabUI() {
        return tabUI;
    }

    public void setCurrentTab(int index) {
        EnumTAB[] enumArr = EnumTAB.values();
        vp_tab.setCurrentItem(index);
        enumArr[index].getRadioButton().setChecked(true);
    }


    public Context getContext() {
        return this;
    }


}