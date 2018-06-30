package com.risenb.thousandnight.ui.home.fragment.course;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.risenb.expand.utils.DisplayUtil;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.BannerBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.homep.BannerP;
import com.risenb.thousandnight.views.banner.MZBannerView;
import com.risenb.thousandnight.views.banner.holder.MZHolderCreator;
import com.risenb.thousandnight.views.banner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 课程
 * Created by user on 2018/5/10.
 */

public class CourseFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, BannerP.BannerFace {

    /**
     * banner
     */
    @BindView(R.id.mzb_home)
    MZBannerView mzb_home;

    @BindView(R.id.rg_course)
    RadioGroup rg_course;

    /**
     * 指示器
     */
    @BindView(R.id.v_course_indicator)
    View v_course_indicator;

    @BindView(R.id.vp_course)
    ViewPager vp_course;

    private BannerP bannerP;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private int tabWidth;
    private int tabHeight;
    private MyPagerAdapter myPagerAdapter;
    private LinearLayout.LayoutParams lp;
    private int indicatorWidth;
    private int screenWidth;

    private ArrayList<BannerBean> banners;
    private List<String> tabs;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_home_course, container, false);
    }

    @Override
    protected void setControlBasis() {
        bannerP = new BannerP(this, getActivity());
        initIndicator();
        initPager();
    }

    @Override
    protected void prepareData() {
        bannerP.getBanner();
    }

    private void initIndicator() {
        lp = (LinearLayout.LayoutParams) v_course_indicator.getLayoutParams();
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
        tabs.add("拉丁舞");
        tabs.add("芭蕾舞");
        tabs.add("古典舞");
        tabs.add("现代舞");
        tabs.add("爵士舞");
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        RadioButton rb = null;
        rg_course.setOnCheckedChangeListener(this);
        for (int i = 0; i < tabs.size(); i++) {
            rb = (RadioButton) inflater.inflate(R.layout.item_text, null);
            rb.setText(tabs.get(i));
            rb.setId(0x8333333 + i);
            if (i == 0) {
                rb.setChecked(true);
            }
            fragments.add(new CourseChildFragment());
            rg_course.addView(rb, tabWidth, tabHeight);
        }
        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        vp_course.setOffscreenPageLimit(tabs.size());
        vp_course.setAdapter(myPagerAdapter);
        vp_course.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_course_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        vp_course.setCurrentItem(checkedId - 0x8333333);
    }

    @Override
    public String getBannerType() {
        return "1";
    }

    @Override
    public void setBanner(ArrayList<BannerBean> result) {
        banners = result;
        mzb_home.setPages(banners, new MZHolderCreator<ViewPagerHolder>() {
            @Override
            public ViewPagerHolder createViewHolder() {
                return new ViewPagerHolder();
            }
        });
        mzb_home.start();
    }

    public static final class ViewPagerHolder implements MZViewHolder<BannerBean> {

        private ImageView iv_home_banner;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.include_home_banner, null);
            iv_home_banner = (ImageView) view.findViewById(R.id.iv_home_banner);
            return view;
        }

        @Override
        public void onBind(Context context, int position, BannerBean data) {
            Glide.with(context).load(data.getImageUrl()).error(R.drawable.default_banner).placeholder(R.drawable.default_banner).into(iv_home_banner);

        }
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


    @OnClick(R.id.tv_home_course_menu_1)
    void toMenu1() {
        Intent intent = new Intent(getActivity(), ChoiceCourseUI.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_home_course_menu_2)
    void toMenu2() {
        Intent intent = new Intent(getActivity(), ChoiceCourseUI.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_home_course_menu_3)
    void toMenu3() {
        Intent intent = new Intent(getActivity(), ChoiceCourseUI.class);
        startActivity(intent);
    }

}
