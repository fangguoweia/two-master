package com.bwie.jd.frament;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.jd.R;
import com.bwie.jd.adapter.FenleiAdapter;
import com.bwie.jd.adapter.ShowAdapter;
import com.bwie.jd.base.BaseLazyFragment;
import com.bwie.jd.contract.Cartscontract;
import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.persenter.CartsP;
import com.bwie.jd.ui.WebViewActivity;
import com.bwie.jd.weigth.MyTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.donkingliang.banner.CustomBanner;
import com.gyf.barlibrary.ImmersionBar;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.Transformer;

import butterknife.BindView;

/**
 * Created by 第一缕阳光 on 2018/8/29.
 */

public class OneFragment extends BaseLazyFragment implements Cartscontract.CartsView, View.OnClickListener {

    private  Toolbar mToolbar;
    private CustomBanner mBanner;
    private RecyclerView one_recyclerview;
    private CartsP cartsP;
    private ArrayList<String> images;
    private MarqueeView marqueeView;
    private ImmersionBar mImmersionBar;

    private TwinklingRefreshLayout refreshLayout;
    private int bannerHeight;
 //   private  Toolbar toolbar_et;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), mToolbar);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.one;
    }



    @Override
    protected void initData() {


          /* 调用api */
    }

    @Override
    protected void initView() {
        super.initView();

        one_recyclerview = findActivityViewById(R.id.one_recyclerview);
        refreshLayout = findActivityViewById(R.id.one_SmartRefreshLayout);
        mToolbar = findActivityViewById(R.id.toolbar);
     //   toolbar_et = findActivityViewById(R.id.toobar_et);
        cartsP = new CartsP(this);
        HashMap<String, String> map = new HashMap<>();
        cartsP.ShowData(map);
        /*初始化banner 图片集合*/
        images = new ArrayList<>();
       // toolbar_et.setOnClickListener(this);


    }

    @Override
    public void succes(final Cartsentity cartsentity) {

        /* 数据展示*/
        List<Cartsentity.DataBean.TuijianBean.ListBeanX> list = cartsentity.getData().getTuijian().getList();
        one_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ShowAdapter showadapter = new ShowAdapter(R.layout.one_item_1, list);
        one_recyclerview.setAdapter(showadapter);

        showadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String url = cartsentity.getData().getTuijian().getList().get(position).getDetailUrl();
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("webview", url);
                intent.putExtra("pid",cartsentity.getData().getTuijian().getList().get(position).getPid());
                startActivity(intent);
            }
        });


        /*加载banner 图片*/
        for (int i = 0; i < cartsentity.getData().getBanner().size(); i++) {
            String icon = cartsentity.getData().getBanner().get(i).getIcon();
            images.add(icon);
        }


        /* 头布局 banner*/
        View headview = getLayoutInflater().inflate(R.layout.one_banner, (ViewGroup) one_recyclerview.getParent(), false);
        mBanner = headview.findViewById(R.id.banner);
      
        showadapter.addHeaderView(headview);
         /*banner 方法*/

        ViewGroup.LayoutParams bannerParams = mBanner.getLayoutParams();
        ViewGroup.LayoutParams titleBarParams = mToolbar.getLayoutParams();
        bannerHeight = bannerParams.height - titleBarParams.height - ImmersionBar.getStatusBarHeight(getActivity());
        /* 头布局 分类*/
        View fenleiView = getLayoutInflater().inflate(R.layout.fenlei, (ViewGroup) one_recyclerview.getParent(), false);
        RecyclerView one_fenlei_recyclerview = fenleiView.findViewById(R.id.one_fenlei_recyclerview);
        showadapter.addHeaderView(fenleiView);
         /* 头布局 跑马灯*/
        View msView = getLayoutInflater().inflate(R.layout.ms, (ViewGroup) one_recyclerview.getParent(), false);
        marqueeView = msView.findViewById(R.id.marqueeView);
        showadapter.addHeaderView(msView);

        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);

        setBean(images);
        /*跑马灯点击事件*/
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(getActivity(), textView.getText() + "", Toast.LENGTH_SHORT).show();
            }
        });


        /*分类的 操作*/
        one_fenlei_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.HORIZONTAL, false));
        FenleiAdapter fenleiAdapter = new FenleiAdapter(R.layout.one_item, cartsentity.getData().getFenlei());
        one_fenlei_recyclerview.setAdapter(fenleiAdapter);
       /*分类的 点击监听*/
        fenleiAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                // TODO: 2018/8/30 点击分类跳转没做
            }
        });





        one_recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy <= bannerHeight) {
                    float alpha = (float) totalDy / bannerHeight;
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getActivity(), R.color.colorPrimary), alpha));
                } else {
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(getActivity(), R.color.colorPrimary), 1));
                }
            }
        });


       // RefreshListenerAdapter
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                        mToolbar.setVisibility(View.VISIBLE);
                    }
                }, 2000);
            }

            @Override
            public void onPullingDown(TwinklingRefreshLayout refreshLayout, float fraction) {
                mToolbar.setVisibility(View.GONE);
            }
            @Override
            public void onPullDownReleasing(TwinklingRefreshLayout refreshLayout, float fraction) {
                if (Math.abs(fraction - 1.0f) > 0) {
                    mToolbar.setVisibility(View.VISIBLE);
                } else {
                    mToolbar.setVisibility(View.GONE);
                }
            }

        });



    }

    @Override
    public void failure(String msg) {

    }

    private void setBean(final ArrayList<String> beans) {
        mBanner.setPages(new CustomBanner.ViewCreator<String>() {
            @Override
            public View createView(Context context, int position) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }

            @Override
            public void updateUI(Context context, View view, int position, String entity) {
                Glide.with(context).load(entity).into((ImageView) view);
            }
        }, beans)
//
                .startTurning(2000);


    }



    @Override
    public void onClick(View v) {

    }
}

