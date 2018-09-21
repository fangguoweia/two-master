package com.bwie.jd.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.jd.R;
import com.bwie.jd.entity.Cartsentity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class ShowAdapter extends BaseQuickAdapter<Cartsentity.DataBean.TuijianBean.ListBeanX,BaseViewHolder> {
    private Context context;
    private List<Cartsentity.DataBean.TuijianBean.ListBeanX> data1;


    public ShowAdapter(int layoutResId, @Nullable List<Cartsentity.DataBean.TuijianBean.ListBeanX> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, Cartsentity.DataBean.TuijianBean.ListBeanX item) {



        helper.setText(R.id.item_price,item.getBargainPrice()+"");

        helper.setText(R.id.item_title,item.getTitle());


        String[] split = item.getImages().split("\\|");
        //gilde
        //Glide.with(mContext).load(split[0]).crossFade().into((ImageView) helper.getView(R.id.s_ima));
        SimpleDraweeView item_smip = helper.getView(R.id.item_smip);
        // Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/logo.png");
     //   SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        item_smip.setImageURI(split[0]);



    }
}
