package com.example.lym.buxplay.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lym.buxplay.R;
import com.example.lym.buxplay.typeface.BIcons;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;

/**
 * @Description：推荐
 * @author：Bux on 2017/12/18 16:31
 * @email: 471025316@qq.com
 */

public class RecommendFragment extends Fragment {
    private static final String TAG = "RecommendFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommed_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Drawable drawable=new IconicsDrawable(getActivity())
                .icon(BIcons.Icon.bux_games)
                .color(Color.RED)
                .sizeDp(24);
        ImageView imgView= view.findViewById(R.id.iv_img);
        imgView.setImageDrawable(drawable);


        TextView textView = view.findViewById(R.id.tv_gouwuche);

        new Iconics.IconicsBuilder().ctx(getActivity())
                .style(new ForegroundColorSpan(Color.GREEN), new BackgroundColorSpan(Color.BLACK), new RelativeSizeSpan(2f))
                .styleFor(BIcons.Icon.bux_toplist, new BackgroundColorSpan(Color.RED))
                .on(textView)
                .build();

    }
}
