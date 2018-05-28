package com.risenb.thousandnight.network;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.risenb.expand.network.MyOkHttp;
import com.risenb.expand.network.response.IResponseHandler;
import com.risenb.expand.utils.Log;
import com.risenb.thousandnight.beans.BaseBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Gson类型的回调接口
 * Created by tsy on 16/8/15.
 */
public abstract class ImageResponseHandler implements IResponseHandler {


    public ImageResponseHandler() {
    }



    @Override
    public final void onSuccess(final Response response) {
        ResponseBody responseBody = response.body();
        String responseBodyStr = "";

        try {
            responseBodyStr = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("onResponse fail read response body");
            MyOkHttp.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), "fail read response body");
                }
            });
            return;
        } finally {
            responseBody.close();
        }

        final String finalResponseBodyStr = responseBodyStr;

        try {
            BaseBean baseBean = JSONObject.parseObject(finalResponseBodyStr, BaseBean.class);
            final List<String> gsonResponse = JSONArray.parseArray(baseBean.getData(), String.class);
            MyOkHttp.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onSuccess(response.code(), (ArrayList<String>) gsonResponse);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("onResponse fail parse gson, body=" + finalResponseBodyStr);
            MyOkHttp.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onFailure(response.code(), "fail parse gson, body=" + finalResponseBodyStr);
                }
            });

        }
    }

    public abstract void onSuccess(int statusCode, ArrayList<String> response);

    @Override
    public void onProgress(long currentBytes, long totalBytes) {

    }
}
