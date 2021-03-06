package com.example.lym.buxplay.di.module;

import android.util.Log;

import com.example.lym.buxplay.PlayApplication;
import com.example.lym.buxplay.common.http.CommonParamsInterceptor;
import com.example.lym.buxplay.common.http.util.SSLSocketClient;
import com.example.lym.buxplay.data.http.ApiService;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @description：
 * @author：bux on 2018/4/2 17:56
 * @email: 471025316@qq.com
 */

@Module
public class HttpModule {
    private static final String TAG = "HttpModule";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Gson gson, PlayApplication context) {
        //log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        CommonParamsInterceptor commonParamsInterceptor=new CommonParamsInterceptor(context,gson);

        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                // HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如APP版本，token信息
//                .addInterceptor(new HeadInterceptor())
                .addInterceptor(commonParamsInterceptor)
                .addInterceptor(logging)
                // 连接超时时间设置
                .connectTimeout(30, TimeUnit.SECONDS)
                // 读取超时时间设置
                .readTimeout(30, TimeUnit.SECONDS)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();

    }

    @Provides
    @Singleton
    Retrofit provodeRetrofit(OkHttpClient okHttpClient) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);

        return builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        Log.d(TAG, "provideApiService: " + retrofit);
        return retrofit.create(ApiService.class);
    }


}
