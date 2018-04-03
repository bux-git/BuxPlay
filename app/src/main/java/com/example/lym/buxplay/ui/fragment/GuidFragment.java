package com.example.lym.buxplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lym.buxplay.R;

/**
 * @description：
 * @author：bux on 2018/4/3 17:13
 * @email: 471025316@qq.com
 */
public class GuidFragment extends Fragment {

    public static GuidFragment newInstance(String text) {
        GuidFragment fragment = new GuidFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guid, container, false);
        TextView text = view.findViewById(R.id.text);

        text.setText(getArguments().getString("text"));
        return view;
    }
}
