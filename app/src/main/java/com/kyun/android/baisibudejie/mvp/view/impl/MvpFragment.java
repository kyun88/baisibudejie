package com.kyun.android.baisibudejie.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kyun.android.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.kyun.android.baisibudejie.mvp.view.MvpView;

public abstract class MvpFragment<P extends MvpBasePresenter> extends Fragment implements MvpView{

    protected P presenter;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //绑定视图
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    public abstract P bindPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if ( presenter != null) {
            presenter.detachView();
        }
    }
}
