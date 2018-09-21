package com.bwie.jd.persenter;

import android.util.Log;

import com.bwie.jd.contract.Cartscontract;
import com.bwie.jd.contract.Productcontract;
import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.entity.Productentity;
import com.bwie.jd.model.CartsM;
import com.bwie.jd.model.ProductM;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import io.reactivex.functions.Consumer;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class ProductP extends Productcontract.ProductP {

    @Override
    public void upload(HashMap<String, String> map) {


        mModel.upload(map).subscribe(new Consumer<Productentity>() {
            @Override
            public void accept(Productentity productentity) throws Exception {


                mView.success(productentity);

                //EventBus
              //  EventBus.getDefault().post(productentity);



            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                // TODO: 2018/9/6  购物车数据获取失败没做
            }
        });
    }
}
