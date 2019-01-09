package com.kyun.android.baisibudejie.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kyun.android.baisibudejie.mvp.presenter.impl.MvpBasePresenter;
import com.kyun.android.baisibudejie.mvp.view.MvpView;

//将mvp架构集成到Activity
public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView {
    //MVP架构是动态的
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        //presenter中介关联view
        if (presenter != null) {
            presenter.attachView(this);
        }
    }
    //具体的实现由别人实现
    public abstract  P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，解除绑定
        presenter.detachView();
    }
}
