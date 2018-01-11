package com.example.lym.buxplay.data;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.PageBean;
import com.example.lym.buxplay.http.ApiService;
import com.example.lym.buxplay.http.HttpManager;

import retrofit2.Callback;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:26
 * @email: 471025316@qq.com
 */

public class RecommendModel {

    public void getApps(String params, Callback<PageBean<AppInfo>> callback) {
        HttpManager manager = new HttpManager();
        manager.getRetrofit(manager.getOkHttpClient())
                .create(ApiService.class)
                .getApps(params)
                .enqueue(callback);
    }
}
