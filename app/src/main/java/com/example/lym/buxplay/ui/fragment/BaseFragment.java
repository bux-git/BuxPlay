package com.example.lym.buxplay.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lym.buxplay.PlayApplication;
import com.example.lym.buxplay.di.component.AppComponent;
import com.example.lym.buxplay.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description：
 * @author：bux on 2018/4/3 11:11
 * @email: 471025316@qq.com
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    Unbinder mUnbinder;
    View mRootView;
    PlayApplication mApplication;

    @Inject
    T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        mApplication = (PlayApplication) getActivity().getApplicationContext();

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpComponent(mApplication.getAppComponent());
        init();
    }

    protected abstract int setLayoutId();

    public abstract void setUpComponent(AppComponent upComponent);

    protected abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }


}
