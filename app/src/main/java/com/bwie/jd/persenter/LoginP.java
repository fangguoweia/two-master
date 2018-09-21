package com.bwie.jd.persenter;

import com.bwie.jd.contract.LoginContract;
import com.bwie.jd.entity.Loginentity;

import java.util.HashMap;

import io.reactivex.functions.Consumer;

/**
 * Created by 第一缕阳光 on 2018/9/6.
 */

public class LoginP extends LoginContract.LoginP {
    @Override
    public void logindata(HashMap<String, String> map) {

        mModel.logindata(map).subscribe(new Consumer<Loginentity>() {
            @Override
            public void accept(Loginentity loginentity) throws Exception {

                mView.success(loginentity);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }
}
