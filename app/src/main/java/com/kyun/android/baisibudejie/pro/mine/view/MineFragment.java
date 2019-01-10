package com.kyun.android.baisibudejie.pro.mine.view;

import android.view.View;
import android.view.ViewGroup;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.BaseFragment;
import com.kyun.android.baisibudejie.pro.mine.view.navigation.MineNavigationBuilder;
import com.kyun.android.baisibudejie.utils.ToastUtil;


public class MineFragment extends BaseFragment {


    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
    }

    private void initToolBar(View viewContent){
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());

        builder.setModelRes(R.drawable.main_mine_night_model_selector)
                .setModelOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"切换模式");
                    }
                })
                .setTitle(R.string.main_mine_title_text)
                .setRightIcon(R.drawable.main_mine_setting_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"设置");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

}
