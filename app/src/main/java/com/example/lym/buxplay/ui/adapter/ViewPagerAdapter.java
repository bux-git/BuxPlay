package com.example.lym.buxplay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lym.buxplay.ui.adapter.bean.FragmentInfo;

import java.util.List;

/**
 * @Description：
 * @author：Bux on 2017/12/18 16:23
 * @email: 471025316@qq.com
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<FragmentInfo> mFragmentInfoList;

    public ViewPagerAdapter(FragmentManager fm, List<FragmentInfo> fragmentInfos) {
        super(fm);
        mFragmentInfoList = fragmentInfos;
    }


    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragmentInfoList.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentInfoList.size();
    }


}
