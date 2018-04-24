package com.example.lym.buxplay.presenter;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.common.rx.RxHttpResponseCompat;
import com.example.lym.buxplay.common.rx.subscriber.ProgressSubscriber;
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

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }


    public void requestData() {

        mModel.getApps("{\"page\":0}")
                .compose(RxHttpResponseCompat.<List<AppInfo>>compatResult())
                .subscribe(new ProgressSubscriber<List<AppInfo>>(mContext, mView) {
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
