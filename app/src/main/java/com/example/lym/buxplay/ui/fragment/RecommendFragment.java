package com.example.lym.buxplay.ui.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.eftimoff.androipathview.PathView;
import com.example.lym.buxplay.R;

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
        PathView pathView = view.findViewById(R.id.path_view);

        pathView.getPathAnimator()
                .delay(100)
                .duration(500)
                .listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {
                        Log.d(TAG, "onAnimationStart: ");
                    }
                })
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        Log.d(TAG, "onAnimationEnd: ");
                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();
        ;

        pathView.setFillAfter(true);
        pathView.useNaturalColors();

        TextView tvIcon = view.findViewById(R.id.tv_gouwuche);
        Typeface iconfont = Typeface.createFromAsset(getActivity().getAssets(), "iconfont.ttf");
        tvIcon.setTypeface(iconfont);
    }
}
