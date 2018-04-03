package com.example.lym.buxplay.di.component;

import com.example.lym.buxplay.di.FragmentScoped;
import com.example.lym.buxplay.di.module.RecommendModule;
import com.example.lym.buxplay.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * @description：
 * @author：bux on 2018/3/19 11:57
 * @email: 471025316@qq.com
 */
@Component(modules = RecommendModule.class,dependencies = AppComponent.class)
@FragmentScoped
public interface RecommendComponent {

    void inject(RecommendFragment recommendFragment);
}
