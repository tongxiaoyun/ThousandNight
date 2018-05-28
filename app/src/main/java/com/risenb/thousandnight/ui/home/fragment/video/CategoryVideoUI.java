package com.risenb.thousandnight.ui.home.fragment.video;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.risenb.expand.utils.DisplayUtil;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseUI;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/26
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CategoryVideoUI extends BaseUI implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_video)
    RadioGroup rg_video;

    @BindView(R.id.vp_video)
    ViewPager vp_video;

    /**
     * 指示器
     */
    @BindView(R.id.v_video_indicator)
    View v_video_indicator;
    private LinearLayout.LayoutParams lp;
    private int indicatorWidth;
    private int screenWidth;
    private int tabWidth;
    private int tabHeight;
    private ArrayList<String> tabs;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_category_video;
    }

    @Override
    protected void setControlBasis() {
        setTitle("视频");
        initIndicator();
        initPager();
    }

    @Override
    protected void prepareData() {

    }

    private void initIndicator() {
        lp = (LinearLayout.LayoutParams) v_video_indicator.getLayoutParams();
        indicatorWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm055);
        DisplayMetrics out = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(out);
        screenWidth = out.widthPixels / 2;
        tabWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm140);
        tabHeight = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm082);
    }

    private void initPager() {
        tabs = new ArrayList<>();
        tabs.add("全部");
        tabs.add("分类1");
        tabs.add("分类2");
        tabs.add("特殊分类");
        tabs.add("分类3");
        tabs.add("分类4");
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        RadioButton rb = null;
        rg_video.setOnCheckedChangeListener(this);
        for (int i = 0; i < tabs.size(); i++) {
            rb = (RadioButton) inflater.inflate(R.layout.item_text, null);
            rb.setText(tabs.get(i));
            rb.setId(0x8433333 + i);
            if (i == 0) {
                rb.setChecked(true);
            }
            fragments.add(new VideoChildFragment());
            rg_video.addView(rb, tabWidth, tabHeight);
        }
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp_video.setOffscreenPageLimit(tabs.size());
        vp_video.setAdapter(myPagerAdapter);
        vp_video.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_video_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        vp_video.setCurrentItem(checkedId - 0x8433333);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            try {
                super.finishUpdate(container);
            } catch (NullPointerException nullPointerException) {
                System.out.println("Catch the NullPointerException in FragmentPagerAdapter.finishUpdate");
            }
        }
    }

}
