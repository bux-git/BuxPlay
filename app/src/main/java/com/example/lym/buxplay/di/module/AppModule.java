package com.example.lym.buxplay.di.module;

import com.example.lym.buxplay.PlayApplication;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @description：
 * @author：bux on 2018/4/2 16:11
 * @email: 471025316@qq.com
 */

@Module
public class AppModule {

    private PlayApplication mApplication;

    public AppModule(PlayApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    PlayApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }
}
