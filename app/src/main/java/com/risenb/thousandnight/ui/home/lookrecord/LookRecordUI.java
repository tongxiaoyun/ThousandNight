package com.risenb.thousandnight.ui.home.lookrecord;

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
import com.risenb.thousandnight.ui.home.lookrecord.fragment.CourseFragment;
import com.risenb.thousandnight.ui.home.lookrecord.fragment.VideoFragment;

import butterknife.BindView;

/**
 * 观看记录
 * Created by user on 2018/5/17.
 */

public class LookRecordUI extends BaseUI implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    /**
     * 内容
     */
    @BindView(R.id.vp_look_record)
    ViewPager vp_look_record;

    /**
     * 指示器
     */
    @BindView(R.id.v_look_record_indicator)
    View v_look_record_indicator;

    /**
     * rg
     */
    @BindView(R.id.rg_look_record)
    RadioGroup rg_look_record;

    private Fragment[] fragments = new Fragment[]{new CourseFragment(), new VideoFragment()};
    private LinearLayout.LayoutParams lp;
    private int tabWidth;
    private int indicatorWidth;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_home_look_record;
    }

    @Override
    protected void setControlBasis() {
        setTitle("观看记录");
        rightVisible(R.drawable.home_delete);
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
//        indicatorWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm375);
        indicatorWidth = tabWidth;
        lp = (LinearLayout.LayoutParams) v_look_record_indicator.getLayoutParams();
        lp.leftMargin = (tabWidth - indicatorWidth) / 2;
        v_look_record_indicator.setLayoutParams(lp);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp_look_record.setAdapter(myPagerAdapter);
        vp_look_record.addOnPageChangeListener(this);
        rg_look_record.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_look_record_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) rg_look_record.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_look_record_course:
                vp_look_record.setCurrentItem(0);
                break;
            case R.id.rb_look_record_video:
                vp_look_record.setCurrentItem(1);
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
