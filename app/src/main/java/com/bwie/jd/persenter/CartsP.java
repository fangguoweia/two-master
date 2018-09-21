package com.bwie.jd.persenter;

import com.bwie.jd.contract.Cartscontract;
import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.model.CartsM;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class CartsP implements Cartscontract.IShowPresenter {

    private    WeakReference<Cartscontract.CartsView> weakReference;
    private CartsM cartsM;
    private Cartscontract.CartsView cartsView;

    public CartsP(Cartscontract.CartsView cartsView) {
        this.cartsM = new CartsM();
        Attach(cartsView);

    }

    public void Attach(Cartscontract.CartsView cartsView){
        weakReference = new WeakReference<>(cartsView);
        this.cartsView= weakReference.get();
    }


    @Override
    public void ShowData(HashMap<String, String> params) {

        cartsM.ShowData(params, new CartsM.onShowResponse() {
            @Override
            public void success(Cartsentity cartsentity) {

                cartsView.succes(cartsentity);
            }

            @Override
            public void failure(String msg) {

            }
        });


    }

    public void detach(){

        if (weakReference!=null){

            weakReference.clear();

            weakReference = null;

        }

    }
}
