package com.example.lym.buxplay.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lym.buxplay.R;
import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.di.component.AppComponent;
import com.example.lym.buxplay.di.component.DaggerRecommendComponent;
import com.example.lym.buxplay.di.module.RecommendModule;
import com.example.lym.buxplay.presenter.RecommendPresenter;
import com.example.lym.buxplay.presenter.contract.RecommendContract;
import com.example.lym.buxplay.ui.adapter.RecommendAdapter;
import com.example.lym.buxplay.ui.base.BaseProgressFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @Description：推荐
 * @author：Bux on 2017/12/18 16:31
 * @email: 471025316@qq.com
 */

public class RecommendFragment extends BaseProgressFragment<RecommendPresenter,List<AppInfo>> implements RecommendContract.View<List<AppInfo>> {
    private static final String TAG = "RecommendFragment";

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;



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
    protected void reLoad() {
        mPresenter.requestData();
    }

    @Override
    public void showResult(List<AppInfo> infos) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new RecommendAdapter(infos, getActivity()));
    }

    @Override
    public void showNoData() {
      showEmptyView();
    }

}
