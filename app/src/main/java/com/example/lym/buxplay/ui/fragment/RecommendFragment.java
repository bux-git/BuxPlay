package com.example.lym.buxplay.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lym.buxplay.R;
import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.di.component.AppComponent;
import com.example.lym.buxplay.di.component.DaggerRecommendComponent;
import com.example.lym.buxplay.di.module.RecommendModule;
import com.example.lym.buxplay.presenter.RecommendPresenter;
import com.example.lym.buxplay.presenter.contract.RecommendContract;
import com.example.lym.buxplay.ui.adapter.RecommendAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @Description：推荐
 * @author：Bux on 2017/12/18 16:31
 * @email: 471025316@qq.com
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {
    private static final String TAG = "RecommendFragment";

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Inject
    ProgressDialog mDialog;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_recommed_layout;
    }

    @Override
    protected void init() {

        mPresenter.requestData();
    }

    @Override
    public void setUpComponent(AppComponent upComponent) {
        DaggerRecommendComponent.builder()
                .appComponent(upComponent)
                .recommendModule(new RecommendModule(this))
                .build()
                .inject(this);
    }



    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void dimissLoading() {
        mDialog.dismiss();
    }

    @Override
    public void showResult(List<AppInfo> infos) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new RecommendAdapter(infos, getActivity()));
    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(), "无数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
