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
public class MomentChildBean {
    private int authorty;//;//:动态权限 1:公开 2：私密 3：我关注的 4：关注我的
    private String commentNum;//:评论数
    private String content;//:内容
    private String createTime;//:创建时间
    private String createTimeStr;//:创建时间显示
    private String geocode;//:地理位置编码
    private String isDel;//:是否删除 1：否 2：是
    private String lat;//:维度
    private String likeNum;//:点赞数量
    private String lng;//:经度
    private String mediaPath;//:媒体url，多个以逗号分隔
    private String momentId;//:动态id
    private String userId;//:用户id
    private String ageStr;//:用户年龄显示
    private String nickName;//://用户昵称
    private String thumb;//:用户头像
    private String gender;//:用户性别 0：未填写 1：男 2：女

    public int getAuthorty() {
        return authorty;
    }

    public void setAuthorty(int authorty) {
        this.authorty = authorty;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getGeocode() {
        return geocode;
    }

    public void setGeocode(String geocode) {
        this.geocode = geocode;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public String getMomentId() {
        return momentId;
    }

    public void setMomentId(String momentId) {
        this.momentId = momentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAgeStr() {
        return ageStr;
    }

    public void setAgeStr(String ageStr) {
        this.ageStr = ageStr;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
