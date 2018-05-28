package com.risenb.thousandnight.network;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：tongxiaoyun
 * 版    本：1.0
 * 创建日期：2018/4/4
 * 描    述：
 * 修订历史：
 * ================================================
 */
public interface HttpBack<T> {
    void onSuccess(ArrayList<T> result);

    void onSuccess(T result);

    void onSuccess(String data);

    void onFailure(String error_code, String error_msg);
}
