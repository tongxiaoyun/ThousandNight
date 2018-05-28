package com.risenb.thousandnight.beans;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/5/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CommentBean {
    private String author;//"://动态作者id
    private String commentId;//"://评论id
    private String content;//"://评论内容
    private String createTime;//"://评论时间
    private String createTimeStr;//"://评论时间显示
    private String isDel;//"://是否删除 1:否 2：是
    private String momentId;//"://动态id
    private String nickName;//"://评论人昵称
    private String parentId;//"://父级id
    private String parentUserId;//"://父级用户id
    private String thumb;//"://评论人头像
    private String userId;//"://评论人id
    private ArrayList<MomentChildBean> childComment;//

    public ArrayList<MomentChildBean> getChildComment() {
        return childComment;
    }

    public void setChildComment(ArrayList<MomentChildBean> childComment) {
        this.childComment = childComment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getMomentId() {
        return momentId;
    }

    public void setMomentId(String momentId) {
        this.momentId = momentId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
