package com.kyun.android.baisibudejie.pro.essence.view.navigation;

import android.content.Context;
import android.view.ViewGroup;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.navigation.NavigationBuilderAdapter;

public class EssenceNavigationBuilder extends NavigationBuilderAdapter {

    public EssenceNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_essence_layout;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        setImageViewStyle(R.id.iv_right,getRightIconRes(), getRightIconOnClickListener());
    }
}
