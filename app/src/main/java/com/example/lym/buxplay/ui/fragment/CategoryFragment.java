package com.example.lym.buxplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lym.buxplay.R;

/**
 * @Description：分类
 * @author：Bux on 2017/12/18 16:32
 * @email: 471025316@qq.com
 */

public class CategoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_layout,container,false);
    }

}
