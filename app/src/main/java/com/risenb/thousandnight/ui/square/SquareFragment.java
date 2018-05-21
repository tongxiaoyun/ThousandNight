package com.risenb.thousandnight.ui.square;

import android.content.Intent;
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
import com.risenb.thousandnight.pop.TakePop;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.square.fragment.AttentionFragment;
import com.risenb.thousandnight.ui.square.fragment.HotFragment;
import com.risenb.thousandnight.ui.square.fragment.NearbyFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 广场
 * Created by user on 2018/5/4.
 */

public class SquareFragment extends BaseFragment implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    /**
     * 内容
     */
    @BindView(R.id.vp_square)
    ViewPager vp_square;

    /**
     * 指示器
     */
    @BindView(R.id.v_square_indicator)
    View v_square_indicator;

    /**
     * rg
     */
    @BindView(R.id.rg_square)
    RadioGroup rg_square;

    private Fragment[] fragments = new Fragment[]{new HotFragment(), new AttentionFragment(), new NearbyFragment()};
    private LinearLayout.LayoutParams lp;
    private int tabWidth;
    private int indicatorWidth;

    private TakePop takePop;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_square, container, false);
    }

    @Override
    protected void setControlBasis() {
        initViewPager();
        initIndicator();
        takePop = new TakePop(rg_square, getActivity(), R.layout.pop_take);
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
        tabWidth = (out.widthPixels - DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm360)) / 3;
        indicatorWidth = DisplayUtil.getDimen(getActivity().getApplicationContext(), R.dimen.dm055);
        lp = (LinearLayout.LayoutParams) v_square_indicator.getLayoutParams();
        lp.leftMargin = (tabWidth - indicatorWidth) / 2;
        v_square_indicator.setLayoutParams(lp);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        vp_square.setAdapter(myPagerAdapter);
        vp_square.addOnPageChangeListener(this);
        rg_square.setOnCheckedChangeListener(this);
    }

    /**
     * 拍摄
     */
    @OnClick(R.id.iv_square_take)
    void take() {
        takePop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePop.dismiss();
                Intent intent = new Intent(getActivity(), SquarePublishUI.class);
                startActivity(intent);
            }
        });
        takePop.showAtLocation();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        lp.leftMargin = (int) ((tabWidth - indicatorWidth) / 2 + (position + positionOffset) * tabWidth);
        v_square_indicator.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) rg_square.getChildAt(position);
        child.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_square_hot:
                vp_square.setCurrentItem(0);
                break;
            case R.id.rb_square_attention:
                vp_square.setCurrentItem(1);
                break;
            case R.id.rb_square_nearby:
                vp_square.setCurrentItem(2);
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