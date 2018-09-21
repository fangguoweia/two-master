package com.bwie.jd.adapter.classify;

import android.support.annotation.Nullable;

import com.bwie.jd.R;
import com.bwie.jd.entity.Classifyentity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 第一缕阳光 on 2018/9/7.
 */

public class LeftAdapter extends BaseQuickAdapter<Classifyentity.DataBean,BaseViewHolder> {

    public LeftAdapter(int layoutResId, @Nullable List<Classifyentity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Classifyentity.DataBean item) {

        helper.setText(R.id.left_item_tv,item.getName());

    }
}
