package com.example.lym.buxplay.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lym.buxplay.R;
import com.example.lym.buxplay.bean.AppInfo;
import com.example.lym.buxplay.presenter.RecommendPresenter;
import com.example.lym.buxplay.presenter.contract.RecommendContract;
import com.example.lym.buxplay.ui.adapter.RecommendAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description：推荐
 * @author：Bux on 2017/12/18 16:31
 * @email: 471025316@qq.com
 */

public class RecommendFragment extends Fragment implements RecommendContract.View {
    private static final String TAG = "RecommendFragment";

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    ProgressDialog mDialog;
    RecommendContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommed_layout, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        mDialog = new ProgressDialog(getActivity());
        mPresenter = new RecommendPresenter(this);

        mPresenter.requestData();

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
