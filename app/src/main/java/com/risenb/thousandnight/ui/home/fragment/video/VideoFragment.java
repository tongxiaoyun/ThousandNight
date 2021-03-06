package com.risenb.thousandnight.ui.home.fragment.video;

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
import com.risenb.thousandnight.beans.ClassBean;
import com.risenb.thousandnight.beans.ParamBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.fragment.course.CourseP;
import com.risenb.thousandnight.ui.home.homep.BannerP;
import com.risenb.thousandnight.views.banner.MZBannerView;
import com.risenb.thousandnight.views.banner.holder.MZHolderCreator;
import com.risenb.thousandnight.views.banner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 视频
 * Created by user on 2018/5/10.
 */

public class VideoFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, BannerP.BannerFace, CourseP.CourseFace {

    /**
     * banner
     */
    @BindView(R.id.mzb_home)
    MZBannerView mzb_home;

    @BindView(R.id.rg_video)
    RadioGroup rg_video;

    /**
     * 指示器
     */
    @BindView(R.id.v_video_indicator)
    View v_video_indicator;

    @BindView(R.id.vp_video)
    ViewPager vp_video;

    private BannerP bannerP;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private int tabWidth;
    private int tabHeight;
    private MyPagerAdapter myPagerAdapter;
    private LinearLayout.LayoutParams lp;
    private int indicatorWidth;
    private int screenWidth;

    private ArrayList<BannerBean> banners;
    private CourseP courseP;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_home_video, container, false);
    }

    @Override
    protected void setControlBasis() {
        bannerP = new BannerP(this, getActivity());
        courseP = new CourseP(this, getActivity());
        initIndicator();
    }

    @Override
    protected void prepareData() {
        bannerP.getBanner();
        courseP.classifyList();
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

    private void initPager(ArrayList<ParamBean> list) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        RadioButton rb = null;
        ParamBean param = new ParamBean();
        param.setName("全部");
        param.setParamId("");
        list.add(0, param);
        rg_video.removeAllViews();
        rg_video.setOnCheckedChangeListener(this);
        for (int i = 0; i < list.size(); i++) {
            rb = (RadioButton) inflater.inflate(R.layout.item_text, null);
            rb.setText(list.get(i).getName());
            rb.setId(0x8333333 + i);
            if (i == 0) {
                rb.setChecked(true);
            }
            fragments.add(new VideoChildFragment(list.get(i).getParamId()));
            rg_video.addView(rb, tabWidth, tabHeight);
        }
        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        vp_video.setOffscreenPageLimit(list.size());
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
        RadioButton childAt = (RadioButton) rg_video.getChildAt(position);
        childAt.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        vp_video.setCurrentItem(checkedId - 0x8333333);
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

    @Override
    public String getClassifyType() {
        return "7";
    }

    @Override
    public void setClassResult(ClassBean result) {
        initPager(result.getGeneral());
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

    @OnClick(R.id.tv_home_video_menu1)
    void toMenu1() {
        Intent intent = new Intent(getActivity(), NewsVideoUI.class);
        intent.putExtra("title", "最新");
        intent.putExtra("isHot", "");
        startActivity(intent);
    }

    @OnClick(R.id.tv_home_video_menu2)
    void toMenu2() {
        Intent intent = new Intent(getActivity(), NewsVideoUI.class);
        intent.putExtra("title", "最热");
        intent.putExtra("isHot", "1");
        startActivity(intent);
    }

    @OnClick(R.id.tv_home_video_menu3)
    void toMenu3() {
        Intent intent = new Intent(getActivity(), NewsVideoUI.class);
        intent.putExtra("title", "精选");
        intent.putExtra("isHot", "");
        startActivity(intent);
    }

}
