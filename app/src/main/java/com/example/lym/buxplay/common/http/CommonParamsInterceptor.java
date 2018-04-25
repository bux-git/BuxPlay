package com.example.lym.buxplay.common.http;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.lym.buxplay.common.Constant;
import com.example.lym.buxplay.common.util.DensityUtil;
import com.example.lym.buxplay.common.util.DeviceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * @description：添加公共参数将原来请求参数转换成接口规范参数格式并添加公共参数
 * @author：bux on 2018/4/23 11:54
 * @email: 471025316@qq.com
 */
public class CommonParamsInterceptor implements Interceptor {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

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
        String method = oldRequest.method();

        //获取公共参数
        HashMap<String, String> commomParamsMap = getCommonMap();
        //参数集合
        HashMap<String, Object> rootMap = new HashMap<>();

        if ("GET".equals(method)) {

            // p={"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....}}&page=2&abc=bac

            HttpUrl httpUrl = oldRequest.url();


            //获取公共参数
            rootMap.put(Constant.PUBLIC_PARAMS, commomParamsMap);
            Set<String> paramsNames = httpUrl.queryParameterNames();

            for (String key : paramsNames) {
                if (Constant.PARAM.equals(key)) {
                    String oldParamJson = httpUrl.queryParameter(Constant.PARAM);
                    if (oldParamJson == null) {
                        continue;
                    }
                    HashMap<String, Object> oldParamMap = mGson.fromJson(oldParamJson, new TypeToken<Map<String, Object>>() {
                    }.getType());
                    //将已经组合得参数重新写入rootMap中
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


        } else if ("POST".equals(method)) {

            /**
             * post 方式一共有三种body 对应三种请求参数方式
             * 1.post 直接post数据流 对应RequestBody
             * 2.form 提交 key=value&key2=value2 串方式 FormBody
             * 3.MultipartBody 提交多类型方式 图文混排 或者文件 混排等等 MultipartBody
             */
            RequestBody newRequestBody;
            RequestBody body = oldRequest.body();
            if (body instanceof FormBody) {
                FormBody formBody = (FormBody) body;

                for (int i = 0; i < formBody.size(); i++) {
                    rootMap.put(formBody.encodedName(i), formBody.encodedValue(i));
                }

                newRequestBody = RequestBody.create(JSON, insertParamsJson(commomParamsMap, rootMap));
            } else if (body instanceof MultipartBody) {
                //图文混排的方式直接加入公共参数
                MultipartBody mPartBody = (MultipartBody) body;

                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(mPartBody.contentType());

                for (int i = 0; i < mPartBody.parts().size(); i++) {
                    builder.addPart(mPartBody.part(i));
                }
                //添加功能参数
                builder.addPart(MultipartBody.Part.create(RequestBody.create(JSON, mGson.toJson(commomParamsMap))));
                newRequestBody = builder.build();

            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                String oldJsonParams = buffer.readUtf8();
                // 原始参数
                rootMap = mGson.fromJson(oldJsonParams, HashMap.class);
                newRequestBody = RequestBody.create(JSON, insertParamsJson(commomParamsMap, rootMap));
            }

            //构建新的请求
            newRequest = oldRequest
                    .newBuilder()
                    .post(newRequestBody)
                    .build();
        }


        //重新组装Response 使得日志拦截器可以输出修改后的参数
        Response networkResponse = chain.proceed(newRequest);
        Response.Builder responseBuilder = networkResponse.newBuilder()
                .request(oldRequest);

        return responseBuilder.build();
    }

    private String insertParamsJson(HashMap<String, String> commomParamsMap, HashMap<String, Object> rootMap) {
        // 重新组装 加入公共参数到json
        rootMap.put(Constant.PUBLIC_PARAMS, commomParamsMap);
        return mGson.toJson(rootMap);
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
