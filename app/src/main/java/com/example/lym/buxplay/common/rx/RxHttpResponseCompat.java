package com.example.lym.buxplay.common.rx;

import com.example.lym.buxplay.bean.BaseBean;
import com.example.lym.buxplay.common.exception.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
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


    public static <T> ObservableTransformer<BaseBean<T>, T> compatResult() {

        return new ObservableTransformer<BaseBean<T>, T>() {

            @Override
            public ObservableSource<T> apply(Observable<BaseBean<T>> upstream) {

                return upstream.flatMap(new Function<BaseBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseBean<T> tBaseBean) throws Exception {
                        //成功
                        if (tBaseBean.isSuccess()) {
                            return Observable.just(tBaseBean.getDatas());
                        } else {//失败
                            return Observable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));
                        }
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

            }
        };

    }
}
