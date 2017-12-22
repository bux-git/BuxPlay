package com.example.lym.buxplay;

import android.app.Application;

import com.example.lym.buxplay.typeface.BIcons;
import com.mikepenz.iconics.Iconics;

/**
 * @Description：
 * @author：Bux on 2017/12/22 11:41
 * @email: 471025316@qq.com
 */

public class PlayApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //only required if you add a custom or generic font on your own
        Iconics.init(getApplicationContext());
        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new BIcons());
    }

}
