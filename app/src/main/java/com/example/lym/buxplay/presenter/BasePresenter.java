package com.example.lym.buxplay.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.lym.buxplay.ui.base.BaseView;

/**
 * @Description：
 * @author：Bux on 2018/1/10 15:16
 * @email: 471025316@qq.com
 */

public class BasePresenter<M,V extends BaseView> {

    M mModel;
    V mView;
    Context mContext;

    BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
        initContext();
    }

    private void initContext() {
        if(mView instanceof Fragment){
            mContext=((Fragment)mView).getActivity();
        }else{
            mContext = ((Activity) mView);
        }
    }


}
