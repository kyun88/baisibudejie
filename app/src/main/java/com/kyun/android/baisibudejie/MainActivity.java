package com.kyun.android.baisibudejie;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.kyun.android.baisibudejie.pro.attention.view.AttentionFragment;
import com.kyun.android.baisibudejie.pro.essence.view.EssenceFragment;
import com.kyun.android.baisibudejie.pro.mine.view.MineFragment;
import com.kyun.android.baisibudejie.pro.newpost.view.NewpostFragment;
import com.kyun.android.baisibudejie.pro.publish.view.PublishFragment;
import com.kyun.android.baisibudejie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private List<TabItem> tabItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabData();
        initTabHost();
    }

    //初始化Tab数据
    private void initTabData() {
        tabItemList = new ArrayList<>();
        //添加精华Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal
                ,R.drawable.main_bottom_essence_press,R.string.main_essence_text, EssenceFragment.class));
        //添加新帖Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal
                ,R.drawable.main_bottom_newpost_press,R.string.main_newpost_text, NewpostFragment.class));
        //添加发布Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal
                ,R.drawable.main_bottom_public_press,0, PublishFragment.class));
        //添加关注Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal
                ,R.drawable.main_bottom_attention_press,R.string.main_attention_text, AttentionFragment.class));
        //添加我的Tab
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal
                ,R.drawable.main_bottom_mine_press,R.string.main_mine_text, MineFragment.class));
    }

    //初始化初页选项卡视图
    private void initTabHost() {
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost =(FragmentTabHost) findViewById(android.R.id.tabhost);
        //绑定TabHost(绑定我们的body)
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        //去掉分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            //绑定Fragment(将Fragment添加到FragmentTabHost组件上面)
            //newTabSpec:代表Tab名字
            //setIndicator:图片(采用布局文件--Tab样式自己做）
            TabHost.TabSpec tabSpec = fragmentTabHost
                    .newTabSpec(tabItem.getTitleString())
                    .setIndicator(tabItem.getView());
            //添加Fragment
            //tabSpec:选项卡
            //getFragmentClass ：具体的Fragment
            //getBundle：给具体的Fragment传参数
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),tabItem.getBundle());
            //给Tab按钮设置背景
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.main_bottom_bg));
            //监听点击Tab
            fragmentTabHost.setOnTabChangedListener(this);
            //默认选择第一个Tab
            if ( i== 0) {
                tabItem.setChecked(true);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        ToastUtil.showToast(this,tabId);
        //重置Tab样式
        for (int i = 0; i < tabItemList.size(); i++) {
            TabItem tabItem = tabItemList.get(i);
            if (tabId.equals(tabItem.getTitleString())) {
                //选中则设置为选中状态
                tabItem.setChecked(true);
            } else {
                //没有选择的tab样式为正常
                tabItem.setChecked(false);
            }
        }
    }

    //代表每一个Tab
    class TabItem {
        //正常情况下显示的图片
        private int imageNormal;

        private int imagePress;
        //tab的名字
        private int title;
        private String titleString;
        private Class<? extends Fragment> fragmentClass;
        private View view;
        private ImageView imageView;
        private TextView textView;
        private Bundle bundle;

        public TabItem(int imageNormal,int imagePress, int title, Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass =fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public int getTitle() {
            return title;
        }

        public String getTitleString() {
            if(title == 0) {
                return "";
            }
            if (TextUtils.isEmpty(titleString)) {
                titleString = getString(title);
            }
            return titleString;
        }

        public Bundle getBundle() {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putString("title", getTitleString());
            }
            return bundle;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        //切换Tab方法--改变Tab样式
        public void setChecked(boolean isChecked) {
            if ( imageView != null) {
                if(isChecked) {
                    imageView.setImageResource(imagePress);
                }else {
                    imageView.setImageResource(imageNormal);
                }
            }
            if (textView != null && title != 0) {
                if (isChecked) {
                    textView.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
                } else {
                    textView.setTextColor(getResources().getColor(R.color.main_bottom_text_normal));
                }
            }

        }

        public View getView() {
            if(this.view == null) {
                this.view = getLayoutInflater().inflate(R.layout.view_tab_indicator,null);
                this.imageView =(ImageView)this.view.findViewById(R.id.iv_tab);
                this.textView = (TextView)this.view.findViewById(R.id.tv_tab);
                //判断资源是否存在，不在就隐藏
                if (this.title == 0) {
                    this.textView.setVisibility(View.GONE);
                }else {
                    this.textView.setVisibility(View.VISIBLE);
                    this.textView.setText(getTitleString());
                }
                this.imageView.setImageResource(imageNormal);
            }
            return this.view;
        }
    }
}
