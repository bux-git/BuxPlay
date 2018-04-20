package com.example.lym.buxplay.di.component;

import com.example.lym.buxplay.PlayApplication;
import com.example.lym.buxplay.data.http.ApiService;
import com.example.lym.buxplay.di.module.AppModule;
import com.example.lym.buxplay.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @description：
 * @author：bux on 2018/4/2 16:43
 * @email: 471025316@qq.com
 */

@Component(modules = {AppModule.class, HttpModule.class})
@Singleton
public interface AppComponent {

    ApiService getApiService();

    PlayApplication getApplication();

}
