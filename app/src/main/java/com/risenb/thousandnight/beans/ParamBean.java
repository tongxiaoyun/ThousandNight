package com.risenb.thousandnight.beans;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/7/1
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ParamBean {
    private String paramId;//：分类ID
    private String name;//：分类名称
    private String commendImg;//：图片

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommendImg() {
        return commendImg;
    }

    public void setCommendImg(String commendImg) {
        this.commendImg = commendImg;
    }
}
