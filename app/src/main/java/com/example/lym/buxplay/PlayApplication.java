package com.example.lym.buxplay;

import android.app.Application;
import android.content.Context;

import com.example.lym.buxplay.common.typeface.BIcons;
import com.example.lym.buxplay.di.component.AppComponent;
import com.example.lym.buxplay.di.component.DaggerAppComponent;
import com.example.lym.buxplay.di.module.AppModule;
import com.example.lym.buxplay.di.module.HttpModule;
import com.mikepenz.iconics.Iconics;

/**
 * @Description：
 * @author：Bux on 2017/12/22 11:41
 * @email: 471025316@qq.com
 */

public class PlayApplication extends Application {


    AppComponent mAppComponent;


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static PlayApplication get(Context context) {
        return (PlayApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //only required if you add a custom or generic font on your own
        Iconics.init(getApplicationContext());
        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new BIcons());

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }

}
