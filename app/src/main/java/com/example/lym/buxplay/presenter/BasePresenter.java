package com.example.lym.buxplay.presenter;

import com.example.lym.buxplay.ui.BaseView;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:16
 * @email: 471025316@qq.com
 */

public class BasePresenter<M,V extends BaseView> {

    M mModel;
    V mView;

    BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }
}
