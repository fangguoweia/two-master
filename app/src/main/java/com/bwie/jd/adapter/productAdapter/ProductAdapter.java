package com.bwie.jd.adapter.productAdapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.bwie.jd.R;
import com.bwie.jd.entity.Productentity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by 第一缕阳光 on 2018/9/6.
 */

public class ProductAdapter extends BaseQuickAdapter<Productentity.DataBean,BaseViewHolder> {

    private Context mcontext;
    private List<Productentity.DataBean> bean;
    private int a= -1;

    public List<Productentity.DataBean> getBean() {
        return bean;
    }

    public ProductAdapter(int layoutResId, @Nullable List<Productentity.DataBean> data) {
        super(layoutResId, data);
        EventBus.getDefault().register(this);
        bean= data;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void shua(String ma) {

        notifyDataSetChanged();

    }



    @Override
    protected void convert(BaseViewHolder helper, Productentity.DataBean item) {

        final int positions = helper.getLayoutPosition();
        final Productentity.DataBean list = this.bean.get(positions);
        /* */
        helper.setChecked(R.id.z_box, list.getIschekbox());
        helper.setText(R.id.z_text, list.getSellerName());
        /* */
        RecyclerView z_recyclerview = helper.getView(R.id.z_recyclerview);
        final CheckBox z_box = helper.getView(R.id.z_box);
        /* 适配器 */
        z_recyclerview.setLayoutManager(new LinearLayoutManager(mcontext));
        final Show2adapter show2adapter = new Show2adapter(R.layout.three_z_item, list.getList());
        z_recyclerview.setAdapter(show2adapter);


          /* 判断 商家的checkbox 应不应该选中*/
        for (int i = 0; i < list.getList().size(); i++) {

            if (!list.getList().get(i).isIscheckbox()) {
                helper.setChecked(R.id.z_box, false);
                break;
            } else {
                helper.setChecked(R.id.z_box, true);
            }
        }

           /*
        * 商家点击全选 反选
        * */
        z_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (z_box.isChecked()) {

                    list.setIschekbox(true);

                    for (int i = 0; i < list.getList().size(); i++) {
                        list.getList().get(i).setIscheckbox(true);
                    }
                } else {
                    list.setIschekbox(false);
                    for (int i = 0; i < list.getList().size(); i++) {
                        list.getList().get(i).setIscheckbox(false);
                    }

                }
               // notifyDataSetChanged();
                shua();

            }
        });


        //点击加减
        show2adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            /*每次点击都赋值 确保数据准确*/
                int num = list.getList().get(position).getNum();
                switch (view.getId()) {
                    case R.id.zu_btn_del:
                        if (num == 1) {
                            return;
                        } else {
                            num--;
                            list.getList().get(position).setTotalNum(num);
                            /*我们页面展示的num*/
                            list.getList().get(position).setNum(num);
                        }


                        shua();
                  //      notifydata();
                        break;

                    case R.id.zu_btn_add:
                        num++;
                        list.getList().get(position).setTotalNum(num);
                        list.getList().get(position).setNum(num);
                    //    notifydata();

                        shua();

                        break;

                }
            }
        });

    }

    public void shua(){
        String mas ="";
        EventBus.getDefault().post(mas);
    }

}
