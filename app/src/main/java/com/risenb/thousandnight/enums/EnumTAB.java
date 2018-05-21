package com.risenb.thousandnight.enums;

import android.support.v4.app.Fragment;
import android.widget.RadioButton;

import com.risenb.thousandnight.R;
import com.risenb.thousandnight.ui.found.FoundFragment;
import com.risenb.thousandnight.ui.home.HomeFragment;
import com.risenb.thousandnight.ui.chat.ChatFragment;
import com.risenb.thousandnight.ui.mine.MineFragment;
import com.risenb.thousandnight.ui.square.SquareFragment;


public enum EnumTAB {


    TAB1(R.id.rb_tab_1, R.drawable.tab_1, "首页", new HomeFragment()), //
    TAB2(R.id.rb_tab_2, R.drawable.tab_2, "发现", new FoundFragment()), //
    TAB3(R.id.rb_tab_3, R.drawable.tab_3, "广场", new SquareFragment()), //
    TAB4(R.id.rb_tab_4, R.drawable.tab_4, "消息", new ChatFragment()), //
    TAB5(R.id.rb_tab_5, R.drawable.tab_5, "我的", new MineFragment()); //

    private int id;
    private int drawable;
    private String title;
    private Fragment fragment;
    private RadioButton radioButton;

    EnumTAB(int id, int drawable, String title, Fragment fragment) {
        this.id = id;
        this.drawable = drawable;
        this.title = title;
        this.fragment = fragment;
    }

    public int getId() {
        return id;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setRadioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

}
