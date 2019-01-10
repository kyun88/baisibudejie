package com.kyun.android.baisibudejie.pro.newpost.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.kyun.android.baisibudejie.R;
import com.kyun.android.baisibudejie.pro.base.view.BaseFragment;
import com.kyun.android.baisibudejie.pro.essence.view.adapter.EssenceAdapter;
import com.kyun.android.baisibudejie.pro.essence.view.navigation.EssenceNavigationBuilder;
import com.kyun.android.baisibudejie.pro.newpost.view.navigation.NewpostNavigationBuilder;
import com.kyun.android.baisibudejie.utils.ToastUtil;

import java.util.Arrays;

public class NewpostFragment extends BaseFragment {

    private TabLayout tab_newpost;
    private ViewPager vp_newpost;

    @Override
    public int getContentView() {
        return R.layout.fragment_newpost;
    }

    @Override
    public void initContentView(View viewContent) {
        initToolBar(viewContent);
        this.tab_newpost = (TabLayout) viewContent.findViewById(R.id.tab_newpost);
        this.vp_newpost = (ViewPager) viewContent.findViewById(R.id.vp_newpost);
    }

    private void initToolBar(View viewContent) {
        NewpostNavigationBuilder builder = new NewpostNavigationBuilder(getContext());
        builder.setTitleIcon(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(getContext(),"审核");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {
        String[] titles = getResources().getStringArray(R.array.newpost_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        this.vp_newpost.setAdapter(adapter);
        this.tab_newpost.setupWithViewPager(this.vp_newpost);
    }
}
