package com.bwie.jd.contract;

import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.model.CartsM;

import java.util.HashMap;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public interface Cartscontract {

    //view层

    interface CartsView{

        void succes(Cartsentity cartsentity);

        void failure(String msg);

    }



    interface  IShowModel{

        void ShowData(HashMap<String,String> params, CartsM.onShowResponse loginResponse);

    }

    interface IShowPresenter{

        void ShowData(HashMap<String,String> params);



    }
}
