package com.bwie.jd.contract;

import com.bwie.jd.entity.Rightentity;
import com.bwie.jd.model.RightM;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.base.mvp.IBaseModel;
import com.example.kson.base.base.mvp.IBaseView;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public interface Rightcontract {


    abstract class rightP extends BasePresenter<IrightModel,IrightView>{

        @Override
        public IrightModel getmModel() {
            return new RightM();
        }
        public abstract void rightdata(HashMap<String,String> map);

    }



    /**
     * model层接口
     */
    interface IrightModel extends IBaseModel {

        Observable<Rightentity> rightdata(HashMap<String, String> map);

    }

    /**
     * view层接口
     */
    interface IrightView extends IBaseView {

        void rightsuccess(Rightentity rightentity);
        void fail(String msg);

    }

}
