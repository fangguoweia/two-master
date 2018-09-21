package com.bwie.jd.contract;

import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.entity.Classifyentity;
import com.bwie.jd.entity.Loginentity;
import com.bwie.jd.model.CartsM;
import com.bwie.jd.model.ClassifyM;
import com.bwie.jd.model.LoginM;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.base.mvp.IBaseModel;
import com.example.kson.base.base.mvp.IBaseView;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public interface LoginContract {


    abstract class LoginP extends BasePresenter<ILoginModel,ILoginView> {

        @Override
        public ILoginModel getmModel() {
            return new LoginM();
        }
        public abstract void logindata(HashMap<String,String> map);

    }



    /**
     * model层接口
     */
    interface ILoginModel extends IBaseModel {

        Observable<Loginentity> logindata(HashMap<String, String> map);

    }

    /**
     * view层接口
     */
    interface ILoginView extends IBaseView {

        void success(Loginentity Loginentity);
        void fail(String msg);

    }
}
