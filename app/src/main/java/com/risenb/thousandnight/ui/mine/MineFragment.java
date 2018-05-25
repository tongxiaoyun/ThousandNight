package com.risenb.thousandnight.ui.mine;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.BaseFragment;
import com.risenb.thousandnight.ui.mine.attention.AttentionUI;
import com.risenb.thousandnight.ui.mine.campaign.CampaignUI;
import com.risenb.thousandnight.ui.mine.coin.CoinUI;
import com.risenb.thousandnight.ui.mine.course.CourseUI;
import com.risenb.thousandnight.ui.mine.dancepartner.DancePartnerUI;
import com.risenb.thousandnight.ui.mine.dynamic.DynamicUI;
import com.risenb.thousandnight.ui.mine.home.HomeUI;
import com.risenb.thousandnight.ui.mine.info.PersonInfoUI;
import com.risenb.thousandnight.ui.mine.invite.InviteFriendUI;
import com.risenb.thousandnight.ui.mine.livevideo.LiveVideoUI;
import com.risenb.thousandnight.ui.mine.nearbyfriend.NearbyFriendUI;
import com.risenb.thousandnight.ui.mine.order.OrderUI;
import com.risenb.thousandnight.ui.mine.organizeattest.OrganizeAttestUI;
import com.risenb.thousandnight.ui.mine.recruit.RecruitUI;
import com.risenb.thousandnight.ui.mine.setting.SettingUI;
import com.risenb.thousandnight.ui.mine.vip.VipUI;
import com.risenb.thousandnight.views.SScrollView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 * Created by user on 2018/5/4.
 */

public class MineFragment extends BaseFragment implements SScrollView.OnScrollerView {

    @BindView(R.id.ssv_mine)
    SScrollView ssv_mine;

    @BindView(R.id.ll_mine_top)
    LinearLayout ll_mine_top;

    @BindView(R.id.rl_mine_title)
    RelativeLayout rl_mine_title;

    private int topHeight;

    @Override
    protected void loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.ui_mine, container, false);
    }

    @Override
    protected void setControlBasis() {
        backGone();
        init();
    }

    @Override
    protected void prepareData() {

    }

    @OnClick({R.id.iv_mine_edit, R.id.iv_mine_icon, R.id.tv_mine_nickname, R.id.ll_mine_age,
            R.id.tv_mine_signature, R.id.tv_mine_home, R.id.tv_mine_sign, R.id.ll_mine_coin,
            R.id.rl_mine_menu_1, R.id.rl_mine_menu_2, R.id.rl_mine_menu_3, R.id.rl_mine_menu_4,
            R.id.rl_mine_menu_5, R.id.rl_mine_menu_6, R.id.rl_mine_menu_7, R.id.rl_mine_menu_8,
            R.id.rl_mine_menu_9, R.id.rl_mine_menu_10, R.id.rl_mine_menu_11, R.id.rl_mine_menu_12,
            R.id.ll_mine_attention, R.id.ll_mine_fans})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {

            //个人信息
            case R.id.iv_mine_edit:
            case R.id.iv_mine_icon:
            case R.id.tv_mine_nickname:
            case R.id.ll_mine_age:
            case R.id.tv_mine_signature:
                intent = new Intent(getActivity(), PersonInfoUI.class);
                startActivity(intent);
                break;
            //设置
            //我的主页
            case R.id.tv_mine_home:
                intent = new Intent(getActivity(), HomeUI.class);
                startActivity(intent);
                break;
            //签到
            case R.id.tv_mine_sign:
                intent = new Intent(getActivity(), SettingUI.class);
                startActivity(intent);
                break;
            //千夜币
            case R.id.ll_mine_coin:
                intent = new Intent(getActivity(), CoinUI.class);
                startActivity(intent);
                break;
            //附近的舞友
            case R.id.rl_mine_menu_1:
                intent = new Intent(getActivity(), NearbyFriendUI.class);
                startActivity(intent);
                break;
            //会员中心
            case R.id.rl_mine_menu_2:
                intent = new Intent(getActivity(), VipUI.class);
                startActivity(intent);
                break;
            //我的课程
            case R.id.rl_mine_menu_3:
                intent = new Intent(getActivity(), CourseUI.class);
                startActivity(intent);
                break;
            //我的订单
            case R.id.rl_mine_menu_4:
                intent = new Intent(getActivity(), OrderUI.class);
                startActivity(intent);
                break;
            //机构认证
            case R.id.rl_mine_menu_5:
                intent = new Intent(getActivity(), OrganizeAttestUI.class);
                startActivity(intent);
                break;
            //我的动态
            case R.id.rl_mine_menu_6:
                intent = new Intent(getActivity(), DynamicUI.class);
                startActivity(intent);
                break;
            //我的活动
            case R.id.rl_mine_menu_7:
                intent = new Intent(getActivity(), CampaignUI.class);
                startActivity(intent);
                break;
            //舞伴寻找记录
            case R.id.rl_mine_menu_8:
                intent = new Intent(getActivity(), DancePartnerUI.class);
                startActivity(intent);
                break;
            //我的直播
            case R.id.rl_mine_menu_9:
                intent = new Intent(getActivity(), LiveVideoUI.class);
                startActivity(intent);
                break;
            //我的招聘
            case R.id.rl_mine_menu_10:
                intent = new Intent(getActivity(), RecruitUI.class);
                intent.putExtra("ui", "招聘");
                startActivity(intent);
                break;
            //我的投递
            case R.id.rl_mine_menu_11:
                intent = new Intent(getActivity(), RecruitUI.class);
                intent.putExtra("ui", "投递");
                startActivity(intent);
                break;
            //邀请好友
            case R.id.rl_mine_menu_12:
                intent = new Intent(getActivity(), InviteFriendUI.class);
                startActivity(intent);
                break;
            //关注
            case R.id.ll_mine_attention:
                intent = new Intent(getActivity(), AttentionUI.class);
                intent.putExtra("ui", "我关注的");
                startActivity(intent);
                break;
            //粉丝
            case R.id.ll_mine_fans:
                intent = new Intent(getActivity(), AttentionUI.class);
                intent.putExtra("ui", "我的粉丝");
                startActivity(intent);
                break;
        }
    }

    private void init() {
        ViewTreeObserver vto = ll_mine_top.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ll_mine_top.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                topHeight = ll_mine_top.getHeight();
            }
        });
        ssv_mine.setOnScrollerView(this);
    }

    @Override
    public void onScrollChanged(SScrollView homeScrollView, int X, int Y, int oldX, int oldY) {
        if (Y <= 0) {
            rl_mine_title.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));
        } else if (Y > 0 && Y <= topHeight) {
            float scale = (float) Y / topHeight;
            float alpha = (255 * scale);
            rl_mine_title.setBackgroundColor(Color.argb((int) alpha, 136, 68, 229));
        } else {
            rl_mine_title.setBackgroundColor(Color.argb((int) 255, 136, 68, 229));
        }
    }

}