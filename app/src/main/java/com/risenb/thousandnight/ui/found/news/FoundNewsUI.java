package com.risenb.thousandnight.ui.found.news;

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
import com.risenb.thousandnight.ui.found.news.fragment.NewsChildFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 千夜新闻
 * Created by user on 2018/5/15.
 */

public class FoundNewsUI extends BaseUI implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_found_news)
    RadioGroup rg_found_news;

    /**
     * 指示器
     */
    @BindView(R.id.v_found_news_indicator)
    View v_found_news_indicator;

    @BindView(R.id.vp_found_news)
    ViewPager vp_found_news;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private int tabWidth;
    private int tabHeight;
    private MyPagerAdapter myPagerAdapter;
    private LinearLayout.LayoutParams lp;
    private int indicatorWidth;
    private int screenWidth;

    private List<String> tabs;

    @Override
    protected void back() {
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.ui_found_news;
    }

    @Override
    protected void setControlBasis() {
        initIndicator();
        initPager();
    }

    @Override
    protected void prepareData() {

    }

    private void initIndicator() {
        lp = (LinearLayout.LayoutParams) v_found_news_indicator.getLayoutParams();
        indicatorWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm055);
        DisplayMetrics out = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(out);
        screenWidth = out.widthPixels / 2;
        tabWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm140);
        tabHeight = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm082);
    }

    private void initPager() {
        tabs = new ArrayList<>();
        tabs.add("分类1");
        tabs.add("分类2");
        tabs.add("分类3");
        tabs.add("分类4");
        tabs.add("分类5");
        tabs.add("分类6");
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        RadioButton rb = null;
        rg_found_news.setOnCheckedChangeListener(this);
        for (int i = 0; i < tabs.size(); i++) {
            rb = (RadioButton) inflater.inflate(R.layout.item_text, null);
            rb.setText(tabs.get(i));
            rb.setId(0x8333333 + i);
            if (i == 0) {
                rb.setChecked(true);
            }
            fragments.add(new NewsChildFragment());
            rg_found_news.addView(rb, tabWidth, tabHeight);
        }
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp_found_news.setOffscreenPageLimit(tabs.size());
        vp_found_news.setAdapter(myPagerAdapter);
        vp_found_news.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_found_news_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        vp_found_news.setCurrentItem(checkedId - 0x8333333);
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
