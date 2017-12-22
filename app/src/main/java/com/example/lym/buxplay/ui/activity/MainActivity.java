package com.example.lym.buxplay.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lym.buxplay.R;
import com.example.lym.buxplay.ui.adapter.ViewPagerAdapter;
import com.example.lym.buxplay.ui.adapter.bean.FragmentInfo;
import com.example.lym.buxplay.ui.fragment.CategoryFragment;
import com.example.lym.buxplay.ui.fragment.GamesFragment;
import com.example.lym.buxplay.ui.fragment.RecommendFragment;
import com.example.lym.buxplay.ui.fragment.TopListFragment;
import com.example.lym.buxplay.ui.widget.TabView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.navigation)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initTooBar();
        initDrawerLayout();
        initTabLayout();
    }

    private void initTabLayout() {
        List<FragmentInfo> fragmentInfos = initFragments();
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentInfos));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        int textColor= Color.GRAY;
        int iconSize=22;
        int titleSize=10;
        int selsectedColor =getResources().getColor(R.color.colorAccent);

        for (int i = 0; i < fragmentInfos.size(); i++) {
            FragmentInfo info = fragmentInfos.get(i);
            mTabLayout.addTab(  mTabLayout.newTab().setCustomView(new TabView(this,info.getImgStr(),info.getTitle(),textColor,selsectedColor,iconSize,titleSize)));
        }

    }

    private void initTooBar() {
        mToolbar.inflateMenu(R.menu.toobar_menu);
    }


    private void initDrawerLayout() {
        View headView = mNavigationView.getHeaderView(0);
        headView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "headerview click", Toast.LENGTH_SHORT).show();
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_account:
                        break;
                    case R.id.action_setting:
                        break;
                    default:
                }
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_string, R.string.close_string);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    private List<FragmentInfo> initFragments() {
        List<FragmentInfo> fragmentInfos = new ArrayList<>();
        fragmentInfos.add(new FragmentInfo(getString(R.string.recommend_title), RecommendFragment.class, getString(R.string.ic_recommend)));
        fragmentInfos.add(new FragmentInfo(getString(R.string.top_list_title), TopListFragment.class, getString(R.string.ic_top_list)));
        fragmentInfos.add(new FragmentInfo(getString(R.string.games_title), GamesFragment.class, getString(R.string.ic_games)));
        fragmentInfos.add(new FragmentInfo(getString(R.string.category_title), CategoryFragment.class, getString(R.string.ic_category)));
        return fragmentInfos;
    }
}
