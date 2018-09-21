package com.bwie.jd.contract;

import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.entity.Productentity;
import com.bwie.jd.model.CartsM;
import com.bwie.jd.model.ProductM;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.base.mvp.IBaseModel;
import com.example.kson.base.base.mvp.IBaseView;

import java.io.File;
import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public interface Productcontract {


    abstract class ProductP extends BasePresenter<IProductModel,IProductView>{

        @Override
        public IProductModel getmModel() {
            return new ProductM();
        }


       public abstract void upload(HashMap<String,String> map);
    }

    /**
     * model层接口
     */
    interface IProductModel extends IBaseModel {

        Observable<Productentity> upload( HashMap<String,String> map);

    }

    /**
     * view层接口
     */
    interface IProductView extends IBaseView {

        void success(Productentity productentity);
        void fail(String msg);

    }

}
