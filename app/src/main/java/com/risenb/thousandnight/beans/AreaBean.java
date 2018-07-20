package com.risenb.thousandnight.beans;


import com.contrarywind.interfaces.IPickerViewData;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/4/6
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class AreaBean implements IPickerViewData {
    private String acode;//":"140101",
    private String aid;//":220,

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    private String aname;//":"市辖区"

    @Override
    public String getPickerViewText() {
        return aname;
    }
}
