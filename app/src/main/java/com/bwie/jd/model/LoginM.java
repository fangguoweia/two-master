package com.bwie.jd.model;

import com.bwie.jd.common.Contants;
import com.bwie.jd.common.LoginApi;
import com.bwie.jd.contract.LoginContract;
import com.bwie.jd.entity.Loginentity;
import com.bwie.jd.entity.Productentity;
import com.example.kson.base.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 第一缕阳光 on 2018/9/6.
 */

public class LoginM implements LoginContract.ILoginModel {
    @Override
    public Observable<Loginentity> logindata(HashMap<String, String> map) {
        Observable<Loginentity> on = RetrofitUtils.getInstance().createApi(Contants.BASE_LOGIN_URL, LoginApi.class)
                .ProductData(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return on;
    }
}
