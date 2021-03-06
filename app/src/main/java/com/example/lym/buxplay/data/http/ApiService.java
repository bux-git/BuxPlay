package com.example.lym.buxplay.data.http;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Description：
 * @author：Bux on 2018/1/10 11:05
 * @email: 471025316@qq.com
 */

public interface ApiService {
     static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    @GET("featured")
    Observable<BaseBean<List<AppInfo>>> getApps(@Query("p") String jsonParam);


}
