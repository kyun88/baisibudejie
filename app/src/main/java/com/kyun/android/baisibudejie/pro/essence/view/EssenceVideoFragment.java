package com.kyun.android.baisibudejie.pro.essence.view;

import android.view.View;
import android.widget.TextView;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.BaseFragment;
import com.kyun.android.baisibudejie.pro.essence.view.adapter.EssenceAdapter;

import java.util.Arrays;


public class EssenceVideoFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;

    public void setType(int mType) {
        this.mType = mType;
    }
    public void setTitle(String title){
        this.mTitle = title;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    public void initContentView(View contentView) {
        TextView textView = (TextView)contentView.findViewById(R.id.tv_content);
       textView.setText(this.mTitle);
    }

    @Override
    public void initData() {

    }
}
