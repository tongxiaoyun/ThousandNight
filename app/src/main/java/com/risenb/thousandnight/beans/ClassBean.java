package com.risenb.thousandnight.beans;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/7/1
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ClassBean {
    private ArrayList<ParamBean> recommend;//
    private ArrayList<ParamBean> general;//


    public ArrayList<ParamBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(ArrayList<ParamBean> recommend) {
        this.recommend = recommend;
    }

    public ArrayList<ParamBean> getGeneral() {
        return general;
    }

    public void setGeneral(ArrayList<ParamBean> general) {
        this.general = general;
    }
}
