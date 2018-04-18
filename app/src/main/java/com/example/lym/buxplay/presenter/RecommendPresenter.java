package com.example.lym.buxplay.presenter;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.common.rx.RxErrorHandler;
import com.example.lym.buxplay.common.rx.subscriber.ErrorHandlerSubscriber;
import com.example.lym.buxplay.data.RecommendModel;
import com.example.lym.buxplay.presenter.contract.RecommendContract;

import java.util.List;

import javax.inject.Inject;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:30
 * @email: 471025316@qq.com
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendContract.View> {
    private static final String TAG = "RecommendPresenter";

    private RxErrorHandler mRxErrorHandler;


    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view, RxErrorHandler rxErrorHandler) {
        super(model, view);
        mRxErrorHandler = rxErrorHandler;
    }


    public void requestData() {
        mView.showLoading();
        mModel.getApps("{\"page1\":0}", new ErrorHandlerSubscriber<List<AppInfo>>(mRxErrorHandler) {
            @Override
            public void onNext(List<AppInfo> appInfos) {
                if (appInfos == null || appInfos.size() == 0) {
                    mView.showNoData();
                } else {
                    mView.showResult(appInfos);
                }
            }

            @Override
            public void onComplete() {
                mView.dimissLoading();
            }
        });


    }


}
