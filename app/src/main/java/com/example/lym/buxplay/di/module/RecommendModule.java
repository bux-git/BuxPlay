package com.example.lym.buxplay.di.module;

import android.util.Log;

import com.example.lym.buxplay.data.RecommendModel;
import com.example.lym.buxplay.data.http.ApiService;
import com.example.lym.buxplay.presenter.contract.RecommendContract;

import dagger.Module;
import dagger.Provides;

/**
 * @description：
 * @author：bux on 2018/3/19 11:53
 * @email: 471025316@qq.com
 */

@Module
public class RecommendModule {
    private static final String TAG = "RecommendModule";

    private RecommendContract.View mView;

    public RecommendModule(RecommendContract.View view) {
        mView = view;
    }

    @Provides
    RecommendContract.View providesView() {
        return mView;
    }

    @Provides
    RecommendModel providesModel(ApiService apiService){
        Log.d(TAG, "providesModel: "+apiService.hashCode());
        return new RecommendModel(apiService);
    }



}
