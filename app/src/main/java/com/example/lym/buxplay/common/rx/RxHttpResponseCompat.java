package com.example.lym.buxplay.common.rx;

import android.annotation.SuppressLint;

import com.example.lym.buxplay.bean.BaseBean;
import com.example.lym.buxplay.common.exception.ApiException;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: bux on 2018/4/18 11:00
 * @email: 471025316@qq.com
 * @description:统一封装结果预处理
 */
public class RxHttpResponseCompat {

    private static int i;


    public static <T> FlowableTransformer<BaseBean<T>, T> compatResult() {

        return new FlowableTransformer<BaseBean<T>, T>() {
            @SuppressLint("CheckResult")
            @Override
            public Publisher<T> apply(Flowable<BaseBean<T>> upstream) {

                return upstream.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .flatMap(new Function<BaseBean<T>, Publisher<T>>() {
                            @Override
                            public Publisher<T> apply(BaseBean<T> tBaseBean) throws Exception {
                                //成功
                                if (tBaseBean.isSuccess()) {
                                    return Flowable.just(tBaseBean.getDatas());
                                } else {//失败
                                    return Flowable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));
                                }
                            }
                        });

            }
        };

    }
}
