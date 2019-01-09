package com.kyun.android.baisibudejie.pro.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyun.android.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.kyun.android.baisibudejie.mvp.view.impl.MvpFragment;

public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment<P> {
    //自己的Fragment需要缓存视图
    private View viewContent; //缓存视图

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if( viewContent == null) {
            viewContent = inflater.inflate(getContentView(),container,false);
            initContentView(viewContent);
        }
        //判断Fragment对应的Activity否存在这个视图
        ViewGroup parent =(ViewGroup) viewContent.getParent();
        if(parent != null) {
            //如果存在，移除并重新添加,这样方式就可以缓存视图
            parent.removeView(viewContent);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public abstract int getContentView();

    public abstract void initContentView(View viewContent);
}
