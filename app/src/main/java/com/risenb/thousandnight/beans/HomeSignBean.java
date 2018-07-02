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
public class HomeSignBean {
    private boolean isSign;//":false,
    private String currDateStr;//":"2018-07-01",
    private String continueSignDays;//":0

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    public String getCurrDateStr() {
        return currDateStr;
    }

    public void setCurrDateStr(String currDateStr) {
        this.currDateStr = currDateStr;
    }

    public String getContinueSignDays() {
        return continueSignDays;
    }

    public void setContinueSignDays(String continueSignDays) {
        this.continueSignDays = continueSignDays;
    }
}
