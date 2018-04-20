package com.example.lym.buxplay.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lym.buxplay.PlayApplication;
import com.example.lym.buxplay.di.component.AppComponent;
import com.example.lym.buxplay.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description：
 * @author：bux on 2018/4/3 10:51
 * @email: 471025316@qq.com
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    Unbinder mUnbinder;
    PlayApplication mApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mUnbinder = ButterKnife.bind(this);

        mApplication = (PlayApplication) getApplication();
        setUpAppComponent(mApplication.getAppComponent());
        init();
    }


    /**
     * 设置布局ID
     *
     * @return
     */
    protected abstract int setLayoutId();

    /**
     * 设置AppComponent
     *
     * @param appComponent
     */
    public abstract void setUpAppComponent(AppComponent appComponent);

    /**
     * 初始化操作
     */
    protected abstract void init();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }


}
