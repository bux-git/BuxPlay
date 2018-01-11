package com.example.lym.buxplay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lym.buxplay.R;
import com.example.lym.buxplay.bean.AppInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description：
 * @author：Bux on 2018/1/10 11:43
 * @email: 471025316@qq.com
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendHolder> {

    List<AppInfo> mAppInfos;
    LayoutInflater mInflater;
    Context mContext;


    public RecommendAdapter(List<AppInfo> appInfos, Context context) {
        mAppInfos = appInfos;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public RecommendHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendHolder(mInflater.inflate(R.layout.template_recommend_item_laout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecommendHolder holder, int position) {
        AppInfo appInfo = mAppInfos.get(position);

        String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";

        Glide.with(mContext).load(baseImgUrl + appInfo.getIcon()).into(holder.mImgIcon);

        holder.mTextTitle.setText(appInfo.getDisplayName());
        holder.mTextSize.setText((appInfo.getApkSize() / 1024 / 1024) + " MB");
    }

    @Override
    public int getItemCount() {
        return mAppInfos == null ? 0 : mAppInfos.size();
    }

    class RecommendHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView mImgIcon;
        @BindView(R.id.text_title)
        TextView mTextTitle;
        @BindView(R.id.text_size)
        TextView mTextSize;
        @BindView(R.id.btn_dl)
        Button mBtnDl;

        public RecommendHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
