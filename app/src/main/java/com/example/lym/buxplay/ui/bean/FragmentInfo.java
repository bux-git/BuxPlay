package com.example.lym.buxplay.ui.bean;

/**
 * @Description：
 * @author：Bux on 2017/12/18 16:27
 * @email: 471025316@qq.com
 */

public class FragmentInfo {

    private String title;
    private String imgStr;
    private Class fragment;

    public FragmentInfo(String title, Class fragment,String imgStr) {
        this.title = title;
        this.fragment = fragment;
        this.imgStr=imgStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    public String getImgStr() {
        return imgStr;
    }

    public void setImgStr(String imgStr) {
        this.imgStr = imgStr;
    }
}
