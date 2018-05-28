package com.risenb.thousandnight.beans;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class UserCenterBean {
    private int isFocus;//":是否关注  -1：自己无法关注 0：未关注 1：已经关注

    private User userInfo;


    public int getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(int isFocus) {
        this.isFocus = isFocus;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }
}
