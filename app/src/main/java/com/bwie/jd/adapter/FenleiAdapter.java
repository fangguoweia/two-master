package com.bwie.jd.adapter;

import android.support.annotation.Nullable;

import com.bwie.jd.R;
import com.bwie.jd.entity.Cartsentity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class FenleiAdapter extends BaseQuickAdapter<Cartsentity.DataBean.FenleiBean,BaseViewHolder> {

    public FenleiAdapter(int layoutResId, @Nullable List<Cartsentity.DataBean.FenleiBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Cartsentity.DataBean.FenleiBean item) {

        SimpleDraweeView item_fenlei_smip = helper.getView(R.id.item_fenlei_smip);

        item_fenlei_smip.setImageURI(item.getIcon());






    }
}
