package com.risenb.thousandnight.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.risenb.thousandnight.enums.EnumTAB;


/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/12
 * 描    述：
 * 修订历史：
 * ================================================
 */

public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return EnumTAB.values().length;
    }

    @Override
    public Fragment getItem(int position) {
        return EnumTAB.values()[position].getFragment();
    }

}
