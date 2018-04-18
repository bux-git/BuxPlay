package com.example.lym.buxplay.data;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.common.rx.RxHttpResponseCompat;
import com.example.lym.buxplay.data.http.ApiService;

import org.reactivestreams.Subscriber;

import java.util.List;


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

    public void getApps(String params, Subscriber<List<AppInfo>> subscriber) {

        mService.getApps(params)
                .compose(RxHttpResponseCompat.<List<AppInfo>>compatResult())
                .subscribe(subscriber);
    }

}
