package com.example.lym.buxplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.example.lym.buxplay.R;
import com.example.lym.buxplay.common.Constant;
import com.example.lym.buxplay.data.ACache;

/**
 * @description：
 * @author：bux on 2018/4/3 15:07
 * @email: 471025316@qq.com
 */

public class WelComeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        PathView pathView = findViewById(R.id.pathView);

        pathView.useNaturalColors();
        pathView.setFillAfter(true);
        pathView.getPathAnimator()
                .delay(100)
                .duration(3000)
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        jump();
                    }
                })
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();

    }

    private void jump() {
        ACache aCache = ACache.get(this);
        String isFirst = aCache.getAsString(Constant.IS_FIRST);
        if(TextUtils.isEmpty(isFirst)){
            startActivity(new Intent(this,GuidActivity.class));
            aCache.put(Constant.IS_FIRST,Constant.IS_FIRST);
        }else{
            startActivity(new Intent(this,MainActivity.class));

        }

        finish();
    }
}
