package com.risenb.thousandnight.ui.mine.order;

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
import com.risenb.thousandnight.ui.mine.order.fragment.OrderChildFragment;

import butterknife.BindView;

/**
 * 我的订单
 * Created by user on 2018/5/21.
 */

public class OrderUI extends BaseUI implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    /**
     * 内容
     */
    @BindView(R.id.vp_order)
    ViewPager vp_order;

    /**
     * 指示器
     */
    @BindView(R.id.v_order_indicator)
    View v_order_indicator;

    /**
     * rg
     */
    @BindView(R.id.rg_order)
    RadioGroup rg_order;

    private Fragment[] fragments = new Fragment[]{new OrderChildFragment(), new OrderChildFragment(),
            new OrderChildFragment(), new OrderChildFragment()};
    private LinearLayout.LayoutParams lp;
    private int tabWidth;
    private int indicatorWidth;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_mine_order;
    }

    @Override
    protected void setControlBasis() {
        setTitle("我的订单");
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
        tabWidth = out.widthPixels / 4;
        indicatorWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm055);
        lp = (LinearLayout.LayoutParams) v_order_indicator.getLayoutParams();
        lp.leftMargin = (tabWidth - indicatorWidth) / 2;
        v_order_indicator.setLayoutParams(lp);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp_order.setAdapter(myPagerAdapter);
        vp_order.addOnPageChangeListener(this);
        rg_order.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_order_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) rg_order.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_order_1:
                vp_order.setCurrentItem(0);
                break;
            case R.id.rb_order_2:
                vp_order.setCurrentItem(1);
                break;
            case R.id.rb_order_3:
                vp_order.setCurrentItem(2);
                break;
            case R.id.rb_order_4:
                vp_order.setCurrentItem(3);
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
