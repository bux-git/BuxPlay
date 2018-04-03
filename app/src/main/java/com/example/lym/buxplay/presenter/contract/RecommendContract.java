package com.example.lym.buxplay.presenter.contract;

import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.presenter.BasePresenter;
import com.example.lym.buxplay.ui.BaseView;

import java.util.List;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:12
 * @email: 471025316@qq.com
 */

public interface RecommendContract {

    interface View extends BaseView {
        void showResult(List<AppInfo> infos);

        void showNoData();

        void showError(String msg);
    }

    interface Presenter extends BasePresenter {

        void requestData();

    }
}
