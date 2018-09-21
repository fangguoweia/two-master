package com.example.kson.base.base.mvp;

import com.example.kson.base.base.BaseActivity;
import com.example.kson.base.base.BaseFragment;

public abstract class BaseMvpFrament<M extends IBaseModel,P extends BasePresenter> extends BaseFragment implements IBaseView{

    public M model;
    public P presenter;

    @Override
    protected void initData() {
        presenter = (P) initPresenter();
        if (presenter!=null){
            model = (M) presenter.getmModel();
            if (model!=null){
                presenter.attach(model,this);
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter!=null){
            presenter.detach();//解除绑定，回收资源，释放内存，提高性能
        }
    }
}
