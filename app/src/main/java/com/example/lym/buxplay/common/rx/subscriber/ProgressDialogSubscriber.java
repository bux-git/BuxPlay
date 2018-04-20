package com.example.lym.buxplay.common.rx.subscriber;

import android.content.Context;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.lym.buxplay.common.util.ProgressDialogHandler;

import org.reactivestreams.Subscription;

/**
 * @description：
 * @author：bux on 2018/4/19 11:48
 * @email: 471025316@qq.com
 */
public abstract class ProgressDialogSubscriber<T> extends ErrorHandlerSubscriber<T> implements  MaterialDialog.SingleButtonCallback {

    private ProgressDialogHandler mProgressDialog;
    private boolean isShow = true;

    private Subscription mSubscription;


    public ProgressDialogSubscriber(Context context, boolean isShow,boolean isShowCancel) {
        super(context);
        this.isShow = isShow;
        if (isShow) {
            mProgressDialog = new ProgressDialogHandler(context, isShowCancel, this);
        }
    }

    protected ProgressDialogSubscriber(Context context) {
        this(context, true,false);
    }

    @Override
    public void onSubscribe(Subscription s) {
        super.onSubscribe(s);
        mSubscription = s;
        if (isShow) {
            mProgressDialog.showProgressDialog();
        }
    }


    @Override
    public void onError(Throwable t) {
        super.onError(t);
        dismissDialog();
    }

    @Override
    public void onComplete() {
        dismissDialog();
    }

    private void dismissDialog() {
        if (isShow) {
            mProgressDialog.dismissProgressDialog();
        }
    }


    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
        if(mSubscription!=null) {
            mSubscription.cancel();
        }
    }
}
