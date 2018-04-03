package com.example.lym.buxplay.data.http;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.PageBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @Description：
 * @author：Bux on 2018/1/10 11:05
 * @email: 471025316@qq.com
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);

    @FormUrlEncoded
    @POST
    public Call<String> getUserFollowList(@Url String url,@FieldMap Map<String, String> map);

}