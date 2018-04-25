package com.example.lym.buxplay.presenter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.common.exception.BaseException;
import com.example.lym.buxplay.common.rx.RxHttpResponseCompat;
import com.example.lym.buxplay.common.rx.subscriber.ProgressSubscriber;
import com.example.lym.buxplay.data.RecommendModel;
import com.example.lym.buxplay.presenter.contract.RecommendContract;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:30
 * @email: 471025316@qq.com
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {
    private static final String TAG = "RecommendPresenter";

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }


    @SuppressLint("CheckResult")
    public void requestData() {

        RxPermissions rxPermissions = new RxPermissions((Activity) mContext);
        rxPermissions.request(Manifest.permission.READ_PHONE_STATE)
                .flatMap(new Function<Boolean, ObservableSource<List<AppInfo>>>() {
                    @Override
                    public ObservableSource<List<AppInfo>> apply(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            return mModel.getApps("{\"page\":0}")
                                    .compose(RxHttpResponseCompat.<List<AppInfo>>compatResult());
                        } else {
                            return Observable.error(new BaseException(999, "权限未通过"));
                        }
                    }
                }).subscribe(new ProgressSubscriber<List<AppInfo>>(mContext, mView) {
            @Override
            public void onNext(List<AppInfo> appInfos) {
                if (appInfos == null || appInfos.size() == 0) {
                    mView.showNoData();
                } else {
                    mView.showResult(appInfos);
                }
            }
        });


    }


}
