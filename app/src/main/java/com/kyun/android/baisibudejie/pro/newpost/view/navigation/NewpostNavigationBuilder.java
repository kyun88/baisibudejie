package com.kyun.android.baisibudejie.pro.newpost.view.navigation;

import android.content.Context;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.navigation.NavigationBuilderAdapter;


public class NewpostNavigationBuilder extends NavigationBuilderAdapter {

    public NewpostNavigationBuilder(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_newpost_layout;
    }
}
