package com.example.lym.buxplay.data;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.PageBean;
import com.example.lym.buxplay.data.http.ApiService;

import retrofit2.Callback;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:26
 * @email: 471025316@qq.com
 */

public class RecommendModel {


    private ApiService mService;

    public RecommendModel(ApiService service) {
        mService = service;
    }

    public void getApps(String params, Callback<PageBean<AppInfo>> callback) {

        mService.getApps(params)
                .enqueue(callback);
    }

}
