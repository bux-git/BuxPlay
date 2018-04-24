package com.example.lym.buxplay.data;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.BaseBean;
import com.example.lym.buxplay.data.http.ApiService;

import java.util.List;

import io.reactivex.Flowable;


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

    public Flowable<BaseBean<List<AppInfo>>> getApps(String params) {

        return mService.getApps(params);
    }


}
