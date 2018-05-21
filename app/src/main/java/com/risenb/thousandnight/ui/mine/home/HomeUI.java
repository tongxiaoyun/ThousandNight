package com.risenb.thousandnight.ui.mine.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.risenb.expand.utils.DisplayUtil;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.mine.home.fragment.HomeDynamicFragment;

import butterknife.BindView;

/**
 * 我的主页
 * Created by user on 2018/5/9.
 */

public class HomeUI extends BaseUI implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    /**
     * 内容
     */
    @BindView(R.id.vp_home)
    ViewPager vp_home;

    /**
     * 指示器
     */
    @BindView(R.id.v_home_indicator)
    View v_home_indicator;

    /**
     * rg
     */
    @BindView(R.id.rg_home)
    RadioGroup rg_home;

    private Fragment[] fragments = new Fragment[]{new HomeDynamicFragment(), new HomeDynamicFragment()};
    private LinearLayout.LayoutParams lp;
    private int tabWidth;
    private int indicatorWidth;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_home;
    }

    @Override
    protected void setControlBasis() {
        setTitle("airsee的主页");
        initViewPager();
        initIndicator();
    }

    @Override
    protected void prepareData() {

    }

    /**
     * 初始化指示器
     */
    private void initIndicator() {
        DisplayMetrics out = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(out);
        tabWidth = out.widthPixels / 2;
        indicatorWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm139);
        lp = (LinearLayout.LayoutParams) v_home_indicator.getLayoutParams();
        lp.leftMargin = (tabWidth - indicatorWidth) / 2;
        v_home_indicator.setLayoutParams(lp);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp_home.setAdapter(myPagerAdapter);
        vp_home.addOnPageChangeListener(this);
        rg_home.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_home_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) rg_home.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home_1:
                vp_home.setCurrentItem(0);
                break;
            case R.id.rb_home_2:
                vp_home.setCurrentItem(1);
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

    }

}
