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
public class SignBean {
    private String signId;//":"",
    private String userId;//":"",
    private String createTime;//":1530429148000,"" +
    private String signIntegral;//":10

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSignIntegral() {
        return signIntegral;
    }

    public void setSignIntegral(String signIntegral) {
        this.signIntegral = signIntegral;
    }
}
