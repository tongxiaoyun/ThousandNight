package com.risenb.thousandnight.beans;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/3/13
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class BannerBean {

    private String bannerId;//":轮播图id
    private String createTime;//":
    private String creator;//":
    private String dataId;//":
    private String imageUrl;//":图片地址
    private String isDel;//":
    private String isShow;//":
    private String jumpArea;//":
    private String jumpType;//":跳转类型  1：外链 2：无跳转
    private String link;//":外链地址
    private String sort;//":
    private String type;//":类型1：首页 2：广场 3：新闻

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getJumpArea() {
        return jumpArea;
    }

    public void setJumpArea(String jumpArea) {
        this.jumpArea = jumpArea;
    }

    public String getJumpType() {
        return jumpType;
    }

    public void setJumpType(String jumpType) {
        this.jumpType = jumpType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
