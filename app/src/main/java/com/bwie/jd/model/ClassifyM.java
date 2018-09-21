package com.bwie.jd.model;

import com.bwie.jd.contract.Classifycontract;
import com.bwie.jd.entity.Classifyentity;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by 第一缕阳光 on 2018/9/6.
 */

public class ClassifyM implements Classifycontract.IClassifyModel{

    @Override
    public Observable<Classifyentity> classifydata(HashMap<String, String> map) {
        return null;
    }
}
