package com.bwie.jd.persenter;

import android.util.Log;

import com.bwie.jd.contract.Classifycontract;
import com.bwie.jd.contract.Rightcontract;
import com.bwie.jd.entity.Classifyentity;
import com.bwie.jd.entity.Rightentity;

import java.util.HashMap;

import io.reactivex.functions.Consumer;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class RightP extends Rightcontract.rightP{

    @Override
    public void rightdata(HashMap<String, String> map) {
        mModel.rightdata(map).subscribe(new Consumer<Rightentity>() {
            @Override
            public void accept(Rightentity rightentity) throws Exception {

                mView.rightsuccess(rightentity);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }
}
