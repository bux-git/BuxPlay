package com.example.lym.buxplay.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.lym.buxplay.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

/**
 * @description：
 * @author：bux on 2018/4/3 17:12
 * @email: 471025316@qq.com
 */
public class GuidActivity extends AppIntro2 {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.guid_3), getString(R.string.description3), R.drawable.guide_1, Color.parseColor("#B95F6B")));
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.guid_1), getString(R.string.description1), R.drawable.guide_2, Color.parseColor("#B95F6B")));

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntro2Fragment.newInstance(getString(R.string.guid_2), getString(R.string.description2), R.drawable.guide_3, Color.parseColor("#B95F6B")));

        // OPTIONAL METHODS
        // Override bar/separator color.
        //setBarColor(Color.parseColor("#ffffff"));
       // setSeparatorColor(Color.parseColor("#ffffff"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        //设置切换动画
       // setFadeAnimation();
        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
       // setVibrate(true);
        //setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        jump();
    }



    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        jump();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

    private void jump() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
