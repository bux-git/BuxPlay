package com.example.lym.buxplay.common.rx.subscriber;

import android.content.Context;

import com.example.lym.buxplay.common.exception.BaseException;
import com.example.lym.buxplay.ui.base.BaseView;

import org.reactivestreams.Subscription;

/**
 * @description：
 * @author：bux on 2018/4/19 11:48
 * @email: 471025316@qq.com
 */
public abstract class ProgressSubscriber<T> extends ErrorHandlerSubscriber<T> {

    private BaseView mBaseView;

    public ProgressSubscriber(Context context, BaseView baseView) {
        super(context);
        mBaseView = baseView;
    }


    @Override
    public void onSubscribe(Subscription s) {
        super.onSubscribe(s);
        mBaseView.showProgressView();
    }


    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        BaseException exception = mRxErrorHandler.handlerError(t);
        mBaseView.showError(exception.getDisplayMessage());
    }

    @Override
    public void onComplete() {
        mBaseView.showContentView();
    }


}
