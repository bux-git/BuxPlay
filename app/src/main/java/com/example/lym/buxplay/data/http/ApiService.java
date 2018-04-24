package com.example.lym.buxplay.data.http;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.BaseBean;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Description：
 * @author：Bux on 2018/1/10 11:05
 * @email: 471025316@qq.com
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    public Flowable<BaseBean<List<AppInfo>>> getApps(@Query("p") String jsonParam);


    @POST("featured")
    public Flowable<BaseBean> postBody(@Body BaseBean baseBean);


    @FormUrlEncoded
    @POST("featured")
    public Flowable<BaseBean> postForm(@Field("p") String p,@Field("b") String b);

    @POST("featured")
    public Flowable<BaseBean> postMultipart(@Body    MultipartBody multipartBody);
}
