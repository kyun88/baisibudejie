package com.kyun.android.baisibudejie.pro.essence.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.BaseFragment;
import com.kyun.android.baisibudejie.pro.essence.view.adapter.EssenceAdapter;
import com.kyun.android.baisibudejie.pro.essence.view.navigation.EssenceNavigationBuilder;
import com.kyun.android.baisibudejie.utils.ToastUtil;

import java.util.Arrays;

public class EssenceFragment extends BaseFragment {

    private TabLayout tab_essence;
    private ViewPager vp_essence;

    @Override
    public int getContentView() {
        return R.layout.fragment_essence;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        this.tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    private void initToolBar(View viewContent) {
        EssenceNavigationBuilder builder = new EssenceNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_essence_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"！！！");
                    }
                })
                .setRightIcon(R.drawable.main_essence_btn_more_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"@ @ @");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {
        String[] titles = getResources().getStringArray(R.array.essence_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_essence.setAdapter(adapter);
        this.tab_essence.setupWithViewPager(this.vp_essence);
    }
}
