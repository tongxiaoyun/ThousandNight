package com.risenb.thousandnight.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.risenb.expand.utils.Log;
import com.risenb.thousandnight.beans.BaseBean;
import com.risenb.thousandnight.network.HttpBack;


import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/4/4
 * 描    述：json格式化工具
 * 修订历史：
 * ================================================
 */
public class JsonFormatUtils {

    public <T> void formatObject(BaseBean baseBean, HttpBack<T> httpBack, Class<T> type) {
        T t = JSONObject.parseObject(baseBean.getData(), type);
        httpBack.onSuccess(t);
    }

    public <T> void formatArray(BaseBean baseBean, HttpBack<T> httpBack, Class<T> type) {
        List<T> result = JSONArray.parseArray(baseBean.getData(), type);
        httpBack.onSuccess((ArrayList<T>) result);
    }

    public <T> void format(BaseBean baseBean, HttpBack<T> httpBack, Class<T> type) {
        Log.e(baseBean.toString());
        Log.e(baseBean.getData());
        if (baseBean.getStatus() == 0) {
            String data = baseBean.getData();
            if (TextUtils.isEmpty(data)) {
                httpBack.onSuccess(data);
            } else if (data.startsWith("{")) {
                formatObject(baseBean, httpBack, type);
            } else if (data.startsWith("[")) {
                formatArray(baseBean, httpBack, type);
            } else {
                httpBack.onSuccess(data);
            }

        } else {
            httpBack.onFailure(baseBean.getErrorCode(), baseBean.getErrorMsg());
        }

    }
}
