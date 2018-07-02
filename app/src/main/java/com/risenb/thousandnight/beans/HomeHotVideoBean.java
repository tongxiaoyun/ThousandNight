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
public class HomeHotVideoBean {
    private String totalPage;//":1,
    private ArrayList<VideoListBean> list;//

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public ArrayList<VideoListBean> getList() {
        return list;
    }

    public void setList(ArrayList<VideoListBean> list) {
        this.list = list;
    }
}
