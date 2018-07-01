package com.risenb.thousandnight.ui.home;

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
import android.widget.TextView;

import com.risenb.expand.utils.DisplayUtil;
import com.risenb.thousandnight.R;
import com.risenb.thousandnight.beans.HomeSignBean;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.home.download.DownloadUI;
import com.risenb.thousandnight.ui.home.fragment.ChosenFragment;
import com.risenb.thousandnight.ui.home.fragment.course.CourseFragment;
import com.risenb.thousandnight.ui.home.fragment.music.MusicFragment;
import com.risenb.thousandnight.ui.home.fragment.video.VideoFragment;
import com.risenb.thousandnight.ui.home.lookrecord.LookRecordUI;
import com.risenb.thousandnight.ui.search.HomeSearchUI;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页
 * Created by user on 2018/5/4.
 */

public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, HomeP.HomeFace {

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

    /**
     * 签到
     */
    @BindView(R.id.iv_home_sign)
    ImageView iv_home_sign;


    @BindView(R.id.tv_home_sign_days)
    TextView tv_home_sign_days;

    @BindView(R.id.tv_home_sign)
    TextView tv_home_sign;

    @BindView(R.id.ll_home_sign)
    LinearLayout ll_home_sign;

    private Fragment[] fragments = new Fragment[]{new ChosenFragment(), new CourseFragment(),
            new MusicFragment(), new VideoFragment()};
    private LinearLayout.LayoutParams lp;
    private int tabWidth;
    private int indicatorWidth;
    private HomeP homeP;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_home, container, false);
    }

    @Override
    protected void setControlBasis() {
        homeP = new HomeP(this, getActivity());
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
        lp = (LinearLayout.LayoutParams) v_home_indicator.getLayoutParams();
        lp.leftMargin = (tabWidth - indicatorWidth) / 2;
        v_home_indicator.setLayoutParams(lp);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        vp_home.setAdapter(myPagerAdapter);
        vp_home.addOnPageChangeListener(this);
        rg_home.setOnCheckedChangeListener(this);
    }

    /**
     * 搜索
     */
    @OnClick(R.id.tv_home_search)
    void search() {
        Intent intent = new Intent(getActivity(), HomeSearchUI.class);
        startActivity(intent);
    }

    /**
     * 观看记录
     */
    @OnClick(R.id.iv_home_look_record)
    void lookRecord() {
        Intent intent = new Intent(getActivity(), LookRecordUI.class);
        startActivity(intent);
    }

    /**
     * 下载记录
     */
    @OnClick(R.id.iv_home_download_record)
    void downloadRecord() {
        Intent intent = new Intent(getActivity(), DownloadUI.class);
        startActivity(intent);
    }

    /**
     * 签到
     */
    @OnClick(R.id.iv_home_sign)
    void sign() {
        homeP.signInfo();
    }

    /**
     * 签到
     */
    @OnClick(R.id.tv_home_sign)
    void toSign() {
        homeP.sign();
    }

    @OnClick(R.id.ll_home_sign)
    void sign2() {
        iv_home_sign.setVisibility(View.VISIBLE);
        ll_home_sign.setVisibility(View.GONE);
    }

    /**
     * 签到记录
     */
    @OnClick(R.id.tv_home_sign_record)
    void signRecord() {
        Intent intent = new Intent(getActivity(), HomeSignRecordUI.class);
        startActivity(intent);
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
            case R.id.rb_home_chosen:
                vp_home.setCurrentItem(0);
                break;
            case R.id.rb_home_course:
                vp_home.setCurrentItem(1);
                break;
            case R.id.rb_home_music:
                vp_home.setCurrentItem(2);
                break;
            case R.id.rb_home_video:
                vp_home.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void setSign(HomeSignBean result) {
        if (iv_home_sign.getVisibility() == View.VISIBLE) {
            iv_home_sign.setVisibility(View.INVISIBLE);
            ll_home_sign.setVisibility(View.VISIBLE);
            tv_home_sign_days.setText(result.getContinueSignDays());
            if (result.isSign()) {
                tv_home_sign.setText("已签到");
                tv_home_sign.setClickable(false);
            } else {
                tv_home_sign.setText("立即签到");
                tv_home_sign.setClickable(true);
            }
        }
    }

    @Override
    public void signSuccess() {
        makeText("签到成功");
        iv_home_sign.setVisibility(View.VISIBLE);
        ll_home_sign.setVisibility(View.GONE);
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
