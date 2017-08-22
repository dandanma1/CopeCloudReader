package com.example.copecloudreader;

import android.databinding.DataBindingUtil;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.copecloudreader.databinding.ActivityMainBinding;
import com.example.copecloudreader.http.rx.RxBus;
import com.example.copecloudreader.http.rx.RxBusBaseMessage;
import com.example.copecloudreader.http.rx.RxCodeConstants;
import com.example.copecloudreader.utils.CommonUtils;
import com.example.copecloudreader.view.statusbar.StatusBarUtil;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private FrameLayout llTitleMenu;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private ViewPager vpContent;


    // 一定需要对应的bean
    private ActivityMainBinding mBinding;
    private ImageView llTitleGank;
    private ImageView llTitleOne;
    private ImageView llTitleDou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initStatusView();
        initId();
        initRxBus();
//这部分代码设置后有什么影响，不添加的时候也是一样
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this,drawerLayout,
                CommonUtils.getColor(R.color.colorTheme));
    }



    private void initId() {
        llTitleMenu = mBinding.include.llTitleMenu;
        toolbar = mBinding.include.toolbar;
        fab = mBinding.include.fab;
        fab.setVisibility(View.GONE);
        navView = mBinding.navView;
        drawerLayout = mBinding.drawerLayout;
        vpContent = mBinding.include.vpContent;

        llTitleGank = mBinding.include.ivTitleGank;
        llTitleOne = mBinding.include.ivTitleOne;
        llTitleDou = mBinding.include.ivTitleDou;
    }

    private void initStatusView() {
        ViewGroup.LayoutParams layoutParams = mBinding.include.viewStatus.getLayoutParams();
        layoutParams.height = StatusBarUtil.getStatusBarHeight(this);
        mBinding.include.viewStatus.setLayoutParams(layoutParams);

    }
    /**
     * 每日推荐点击"新电影热映榜"跳转
     */
    private void initRxBus() {
        RxBus.getDefault().toObservable(RxCodeConstants.JUMP_TYPE_TO_ONE, RxBusBaseMessage.class)
                .subscribe(new Action1<RxBusBaseMessage>() {
                    @Override
                    public void call(RxBusBaseMessage integer) {
                        mBinding.include.vpContent.setCurrentItem(1);
                    }
                });
    }
}
