package com.bwie.jd.contract;

import com.bwie.jd.entity.Classifyentity;
import com.bwie.jd.entity.Productentity;
import com.bwie.jd.model.ClassifyM;
import com.bwie.jd.model.ProductM;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.base.mvp.IBaseModel;
import com.example.kson.base.base.mvp.IBaseView;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public interface Classifycontract {


    abstract class Classify extends BasePresenter<IClassifyModel,IClassifyView>{

        @Override
        public IClassifyModel getmModel() {
            return new ClassifyM();
        }
        public abstract void classifydata(HashMap<String,String> map);

    }



    /**
     * model层接口
     */
    interface IClassifyModel extends IBaseModel {

        Observable<Classifyentity> classifydata(HashMap<String, String> map);

    }

    /**
     * view层接口
     */
    interface IClassifyView extends IBaseView {

        void success(Classifyentity classifyentity);
        void fail(String msg);

    }

}
