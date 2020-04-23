package com.qykj.txplayer.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dueeeke.videoplayer.player.AndroidMediaPlayerFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hn.tsplayer.TsPlayerFactory;
import com.qykj.txplayer.R;
import com.qykj.txplayer.fragment.main.ApiFragment;
import com.qykj.txplayer.fragment.main.ExtensionFragment;
import com.qykj.txplayer.fragment.main.ListFragment;
import com.qykj.txplayer.fragment.main.PipFragment;
import com.qykj.txplayer.util.Tag;
import com.qykj.txplayer.util.Utils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private List<Fragment> mFragments = new ArrayList<>();
    public static int mCurrentIndex;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean enableBack() {
        return false;
    }

    @Override
    protected void initView() {
        super.initView();

        AndPermission.with(this)
                .runtime()
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .start();

        //检测当前是用的哪个播放器
        Object factory = Utils.getCurrentPlayerFactory();
        if (factory instanceof TsPlayerFactory) {
            setTitle("(腾讯)");
        } else if (factory instanceof AndroidMediaPlayerFactory) {
            setTitle("(系统)");
        } else {
            setTitle("(未知)");
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        mFragments.add(new ApiFragment());
        mFragments.add(new ListFragment());
        mFragments.add(new ExtensionFragment());
        mFragments.add(new PipFragment());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_content, mFragments.get(0))
                .commitAllowingStateLoss();

        mCurrentIndex = 0;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int index;
        int itemId = menuItem.getItemId();
        switch (itemId) {
            default:
            case R.id.tab_api:
                index = 0;
                break;
            case R.id.tab_list:
                index = 1;
                break;
            case R.id.tab_extension:
                index = 2;
                break;
            case R.id.tab_pip:
                index = 3;
                break;
        }

        if (mCurrentIndex != index) {
            //切换tab，释放正在播放的播放器
            if (mCurrentIndex == 1) {
                //注意不能移除
                getVideoViewManager().releaseByTag(Tag.LIST);
                getVideoViewManager().releaseByTag(Tag.SEAMLESS, false);
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment fragment = mFragments.get(index);
            Fragment curFragment = mFragments.get(mCurrentIndex);
            if (fragment.isAdded()) {
                transaction.hide(curFragment).show(fragment);
            } else {
                transaction.add(R.id.layout_content, fragment).hide(curFragment);
            }
            transaction.commitAllowingStateLoss();
            mCurrentIndex = index;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (getVideoViewManager().onBackPress(Tag.LIST)) {
            return;
        }
        if (getVideoViewManager().onBackPress(Tag.SEAMLESS)) {
            return;
        }
        super.onBackPressed();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

    }
}
