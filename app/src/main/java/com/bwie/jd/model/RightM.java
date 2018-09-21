package com.bwie.jd.model;

import com.bwie.jd.common.Contants;
import com.bwie.jd.common.RightApi;
import com.bwie.jd.contract.Rightcontract;
import com.bwie.jd.entity.Rightentity;
import com.example.kson.base.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 第一缕阳光 on 2018/9/6.
 */

public class RightM implements Rightcontract.IrightModel {


    @Override
    public Observable<Rightentity> rightdata(HashMap<String, String> map) {
        Observable<Rightentity> on = RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, RightApi.class)
                .RightData(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());


        return on;

    }
}
