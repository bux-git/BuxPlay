package com.example.lym.buxplay.common.rx.subscriber;

import android.content.Context;

import com.example.lym.buxplay.common.exception.BaseException;
import com.example.lym.buxplay.common.rx.RxErrorHandler;

import org.reactivestreams.Subscription;

/**
 * @description：
 * @author：bux on 2018/4/18 16:26
 * @email: 471025316@qq.com
 */
public abstract class ErrorHandlerSubscriber<T> extends DefaultSubscriber<T> {


    RxErrorHandler mRxErrorHandler;

    ErrorHandlerSubscriber(Context context) {
        mRxErrorHandler = new RxErrorHandler(context);
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }


    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        BaseException exception = mRxErrorHandler.handlerError(t);
        mRxErrorHandler.showErrorMessage(exception);

    }


}
