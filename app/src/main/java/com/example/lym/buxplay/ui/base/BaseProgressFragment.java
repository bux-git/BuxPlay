package com.example.lym.buxplay.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lym.buxplay.PlayApplication;
import com.example.lym.buxplay.R;
import com.example.lym.buxplay.di.component.AppComponent;
import com.example.lym.buxplay.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description：
 * @author：bux on 2018/4/20 15:58
 * @email: 471025316@qq.com
 */
public abstract class BaseProgressFragment<T extends BasePresenter,F> extends Fragment implements BaseView<F> {


    FrameLayout mRootView;
    View mProgress;
    FrameLayout mContentView;
    View mEmptyView;
    TextView mTvTips;
    Button mBtnReload;

    private Unbinder mUnbinder;

    PlayApplication mApplication;

    @Inject
    public T mPresenter;


    protected abstract void setUpComponent(AppComponent upComponent);

    protected abstract void init();

    protected abstract int setLayoutId();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = (FrameLayout) inflater.inflate(R.layout.fragment_progress, container, false);
        mProgress = mRootView.findViewById(R.id.view_progress);
        mContentView = mRootView.findViewById(R.id.view_content);
        mEmptyView = mRootView.findViewById(R.id.view_empty);
        mTvTips = mRootView.findViewById(R.id.text_tip);
        mBtnReload = mRootView.findViewById(R.id.btn_reload);

        mBtnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reLoad();
            }
        });

        return mRootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mApplication = (PlayApplication) getActivity().getApplicationContext();
        setRealContentView();
        setUpComponent(mApplication.getAppComponent());
        init();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }

    /**
     * 重新加载
     */
    protected void reLoad() {

    }

    private void setRealContentView() {
        LayoutInflater.from(getActivity()).inflate(setLayoutId(), mContentView, true);
        mUnbinder = ButterKnife.bind(this, mContentView);

    }

    @Override
    public void showContentView() {
        showView(R.id.view_content);
    }

    @Override
    public void showEmptyView() {
        showView(R.id.view_empty);
    }

    @Override
    public void showProgressView() {
        showView(R.id.view_progress);
    }

    @Override
    public void showError(String msg) {
        mTvTips.setText(msg);
        showEmptyView();
    }


    public void showView(int viewId) {
        for (int i = 0; i < mRootView.getChildCount(); i++) {
            View childView = mRootView.getChildAt(i);
            if (childView.getId() == viewId) {
                childView.setVisibility(View.VISIBLE);
            } else {
                childView.setVisibility(View.GONE);
            }
        }
    }


}
