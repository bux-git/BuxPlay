package com.example.lym.buxplay.common.http;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.lym.buxplay.common.Constant;
import com.example.lym.buxplay.common.util.DensityUtil;
import com.example.lym.buxplay.common.util.DeviceUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @description：
 * @author：bux on 2018/4/23 11:54
 * @email: 471025316@qq.com
 */
public class CommonParamsInterceptor implements Interceptor {

    private Context mContext;
    private Gson mGson;

    public CommonParamsInterceptor(Context context, Gson gson) {
        mContext = context;
        mGson = gson;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request oldRequest = chain.request();
        Request newRequest = null;
        if ("GET".equals(oldRequest.method())) {

            // p={"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....}}&page=2&abc=bac

            HttpUrl httpUrl = oldRequest.url();

            HashMap<String, Object> rootMap = new HashMap<>();
            //获取公共参数
            rootMap.put(Constant.PUBLIC_PARAMS, getCommonMap());
            Set<String> paramsNames = httpUrl.queryParameterNames();

            for (String key : paramsNames) {
                if (Constant.PARAM.equals(key)) {
                    String oldParamJson = httpUrl.queryParameter(Constant.PARAM);
                    if (oldParamJson == null) {
                        continue;
                    }
                    HashMap<String, Object> oldParamMap = mGson.fromJson(oldParamJson, HashMap.class);
                    //将已经组合得JSON重新写入rootMap中
                    for (Map.Entry<String, Object> entry : oldParamMap.entrySet()) {
                        rootMap.put(entry.getKey(), entry.getValue());
                    }

                } else {
                    rootMap.put(key, httpUrl.queryParameter(key));
                }
            }

            String paramsJson = mGson.toJson(rootMap);

            //重新组装
            //p={"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....},abc=bac}

            String url = httpUrl.toString();
            int index = url.indexOf("?");
            if (index > 0) {
                url = url.substring(0, index);
            }

            url = url + "?" + Constant.PARAM + "=" + paramsJson;

            newRequest = oldRequest.newBuilder().url(url).build();

        }


        Response networkResponse = chain.proceed(newRequest);
        Response.Builder responseBuilder = networkResponse.newBuilder()
                .request(oldRequest);

        return responseBuilder.build();
    }

    private HashMap<String, String> getCommonMap() {
        //设置公共参数
        HashMap<String, String> commonMap = new HashMap<>();
        // commonMap.put(Constant.IMEI, DeviceUtils.getIMEI(mContext));
        commonMap.put(Constant.MODEL, DeviceUtils.getModel());
        commonMap.put(Constant.LANGUAGE, DeviceUtils.getLanguage());
        commonMap.put(Constant.DENSITY_SCALE_FACTOR, DeviceUtils.getDensity(mContext));
        commonMap.put(Constant.RESOLUTION, DensityUtil.getScreenW(mContext) + "*" + DensityUtil.getScreenH(mContext));
        commonMap.put(Constant.os, DeviceUtils.getBuildVersionIncremental());
        commonMap.put(Constant.SDK, String.valueOf(DeviceUtils.getBuildVersionSDK()));


        return commonMap;
    }
}
