package com.example.lym.buxplay.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lym.buxplay.R;
import com.example.lym.buxplay.ui.activity.TestActivity;

/**
 * @Description：排行
 * @author：Bux on 2017/12/18 16:31
 * @email: 471025316@qq.com
 */

public class TopListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_top_list_layout,container,false);
               View top=view.findViewById(R.id.tv_top);
               top.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(getActivity(),TestActivity.class);
                       startActivity(intent);
                   }
               });
        return view;
    }

}
