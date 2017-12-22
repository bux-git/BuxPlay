package com.example.lym.buxplay.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.example.lym.buxplay.R;
import com.mikepenz.iconics.view.IconicsTextView;

/**
 * @Description：
 * @author：Bux on 2017/12/21 17:08
 * @email: 471025316@qq.com
 */

public class TabView extends LinearLayout {

    private IconicsTextView mTvIcons;
    private IconicsTextView mTvTitle;
    private int mSelectedColor;
    private int mColor;


    public TabView(Context context, String icons, String title, int color,int selectedColor, int iconSize, int titleSize) {
        super(context);
        this.mSelectedColor=selectedColor;
        this.mColor=color;
        initView(context, icons, title, color, iconSize, titleSize);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void initView(Context context, String icons, String title, int color, int iconSize, int titleSize) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        inflate(context, R.layout.tab_view_layout, this);

        mTvIcons = findViewById(R.id.tv_icon);
        mTvTitle = findViewById(R.id.tv_tab);

        mTvIcons.setTextColor(color);
        mTvIcons.setTextSize(iconSize);

        mTvTitle.setTextColor(color);
        mTvTitle.setTextSize(titleSize);

        mTvIcons.setText(icons);
        mTvTitle.setText(title);


    }


    public void setTabData(int color) {
        mTvIcons.setTextColor(color);
        mTvTitle.setTextColor(color);
    }

    public IconicsTextView getTvIcons() {
        return mTvIcons;
    }

    public void setTvIcons(IconicsTextView tvIcons) {
        mTvIcons = tvIcons;
    }

    public IconicsTextView getTvTitle() {
        return mTvTitle;
    }

    public void setTvTitle(IconicsTextView tvTitle) {
        mTvTitle = tvTitle;
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        int color;
        if(selected) {
            color=mSelectedColor;
        }else{
            color=mColor;
        }
        mTvIcons.setTextColor(color);
        mTvTitle.setTextColor(color);
    }
}
