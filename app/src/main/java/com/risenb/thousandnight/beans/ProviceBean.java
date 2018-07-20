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
public class ProviceBean implements IPickerViewData {
    private ArrayList<CityBean> citys;//":Array[1],
    private String pcode;//":"110000",
    private String pid;//":78,
    private String pname;//":"北京市"

    public ArrayList<CityBean> getCitys() {
        return citys;
    }

    public void setCitys(ArrayList<CityBean> citys) {
        this.citys = citys;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String getPickerViewText() {
        return pname;
    }
}
