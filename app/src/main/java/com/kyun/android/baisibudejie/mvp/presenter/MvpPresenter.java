package com.kyun.android.baisibudejie.mvp.presenter;

import com.kyun.android.baisibudejie.mvp.view.MvpView;

public interface MvpPresenter<V extends MvpView> {
    public void attachView(V view);
    public void detachView();
}
