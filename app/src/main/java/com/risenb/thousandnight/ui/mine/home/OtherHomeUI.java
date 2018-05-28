package com.risenb.thousandnight.ui.mine.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.risenb.expand.utils.DisplayUtil;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;
import com.risenb.thousandnight.ui.mine.home.fragment.DynamicFragment;
import com.risenb.thousandnight.ui.mine.home.fragment.CampaignFragment;
import com.risenb.thousandnight.ui.mine.home.fragment.LiveVideoFragment;
import com.risenb.thousandnight.ui.mine.home.fragment.OrganizeIntroFragment;
import com.risenb.thousandnight.ui.mine.home.fragment.TeacherIntroFragment;

import butterknife.BindView;

/**
 * 他人主页   教师主页    机构主页
 * Created by user on 2018/5/28.
 */

public class OtherHomeUI extends BaseUI implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

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

    @BindView(R.id.rg_home_other)
    RadioGroup rg_home_other;

    @BindView(R.id.iv_home_type)
    ImageView iv_home_type;

    private Fragment[] fragments = new Fragment[]{new OrganizeIntroFragment(), new DynamicFragment(),
            new CampaignFragment(), new LiveVideoFragment()};
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
        rg_home.setVisibility(View.GONE);
        rg_home_other.setVisibility(View.VISIBLE);
        iv_home_type.setImageResource(R.drawable.mine_teacher);
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
        rg_home_other.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_home_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) rg_home_other.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home_other_1:
                vp_home.setCurrentItem(0);
                break;
            case R.id.rb_home_other_2:
                vp_home.setCurrentItem(1);
                break;
            case R.id.rb_home_other_3:
                vp_home.setCurrentItem(2);
                break;
            case R.id.rb_home_other_4:
                vp_home.setCurrentItem(3);
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
