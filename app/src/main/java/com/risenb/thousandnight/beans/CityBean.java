package com.risenb.thousandnight.beans;


import com.contrarywind.interfaces.IPickerViewData;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/4/6
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class CityBean implements IPickerViewData {
    private ArrayList<AreaBean> areas;//":Array[11],
    private String ccode;//":"140100",
    private String cid;//":533,
    private String cname;//":"太原市"

    public ArrayList<AreaBean> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<AreaBean> areas) {
        this.areas = areas;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String getPickerViewText() {
        return cname;
    }
}
