package com.kyun.android.baisibudejie.pro.attention.view.navigation;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.navigation.NavigationBuilderAdapter;


public class AttentionNavigationBuilder extends NavigationBuilderAdapter {

    private ViewPager viewPager;

    public AttentionNavigationBuilder(Context context){
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.toolbar_attention_layout;
    }

    public AttentionNavigationBuilder setUpWithViewPager(ViewPager viewPager){
        this.viewPager = viewPager;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        TabLayout tab_attention = (TabLayout) findViewById(R.id.tab_attention);
        tab_attention.setupWithViewPager(viewPager);
    }
}
