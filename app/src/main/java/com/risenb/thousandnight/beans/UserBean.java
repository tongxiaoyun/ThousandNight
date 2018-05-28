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
public class UserBean {
    private String c;//":登录标识,
    private User user;//":{

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}