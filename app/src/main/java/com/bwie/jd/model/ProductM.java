package com.bwie.jd.model;

import android.os.Handler;

import com.bwie.jd.common.Api;
import com.bwie.jd.common.Contants;
import com.bwie.jd.common.ProductApi;
import com.bwie.jd.contract.Cartscontract;
import com.bwie.jd.contract.Productcontract;
import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.entity.Productentity;
import com.bwie.jd.utils.OkHttpUtils;
import com.bwie.jd.utils.RequestCallback;
import com.example.kson.base.net.RetrofitUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class ProductM implements Productcontract.IProductModel{
    @Override
    public Observable<Productentity> upload(HashMap<String, String> map) {

        Observable<Productentity> on = RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, ProductApi.class).ProductData(map)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return on;
    }
}
