package com.bwie.jd.adapter;

import android.support.annotation.Nullable;

import com.bwie.jd.R;
import com.bwie.jd.entity.Cartsentity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class OneItemAdapter extends BaseQuickAdapter<Cartsentity.DataBean.TuijianBean.ListBeanX,BaseViewHolder> {
    public OneItemAdapter(int layoutResId, @Nullable List<Cartsentity.DataBean.TuijianBean.ListBeanX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Cartsentity.DataBean.TuijianBean.ListBeanX item) {

        helper.setText(R.id.item_title,item.getTitle());
        helper.setText(R.id.item_price,item.getBargainPrice());


    }
}
