package com.bwie.jd.ui;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwie.jd.R;
import com.bwie.jd.frament.FourFragment;
import com.bwie.jd.frament.OneFragment;
import com.bwie.jd.frament.ThreeFragment;
import com.bwie.jd.frament.TwoFragment;
import com.example.kson.base.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gyf.barlibrary.ImmersionBar;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity {
   private   BottomTabBar btb;

    @Override
    protected void initData() {

        btb =  findViewById(R.id.btb);
        btb.init(getSupportFragmentManager())
                .addTabItem("首页", R.drawable.syc, OneFragment.class)
                .addTabItem("发现", R.drawable.fxc, TwoFragment.class)
                .addTabItem("推荐", R.drawable.flc, ThreeFragment.class)
                .addTabItem("我的", R.drawable.myc, FourFragment.class);

    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).init();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }





}
