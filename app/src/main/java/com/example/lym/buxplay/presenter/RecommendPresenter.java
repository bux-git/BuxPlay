package com.example.lym.buxplay.presenter;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.bean.PageBean;
import com.example.lym.buxplay.data.RecommendModel;
import com.example.lym.buxplay.presenter.contract.RecommendContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:30
 * @email: 471025316@qq.com
 */

public class RecommendPresenter implements RecommendContract.Presenter {
    private static final String TAG = "RecommendPresenter";

    private RecommendModel mModel;
    private RecommendContract.View mView;

    public RecommendPresenter(RecommendContract.View view,RecommendModel model) {
        mView = view;
        mModel=model;
    }

    @Override
    public void requestData() {
        mView.showLoading();
        mModel.getApps("{\"page\":0}", new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
              List<AppInfo> appInfos= response.body().getDatas();
              if(appInfos==null||appInfos.size()==0){
                  mView.showNoData();
              }else{
                  mView.showResult(appInfos);
              }
              mView.dimissLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.showError(t.getMessage());
                mView.dimissLoading();
            }
        });
    }


}
