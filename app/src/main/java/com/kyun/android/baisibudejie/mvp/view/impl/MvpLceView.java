package com.kyun.android.baisibudejie.mvp.view.impl;

import com.kyun.android.baisibudejie.mvp.view.MvpView;

//请求数据，刷新UI界面监听(标准)--loading页
public  interface MvpLceView<M> extends MvpView {
    //显示加载中的视图(监听加载类型:下拉刷新或者上拉加载
    public void showLoading(boolean pullToRefresh);

    //显示ContentView
    public void showContent();

    //加载错误
    public void showError(Exception e, boolean pullToRefresh);

    //绑定数据
    public void showData(M data);
}
