package com.kyun.android.baisibudejie.pro.base.view;

import com.kyun.android.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.kyun.android.baisibudejie.mvp.view.impl.MvpActivity;

//MvpActivity——是MVP框架的
//BaseActivity——项目的activity
public abstract class BaseActivity<P extends MvpBasePresenter> extends MvpActivity<P>{

}
