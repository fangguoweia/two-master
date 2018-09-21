package com.bwie.jd.frament;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.jd.R;
import com.bwie.jd.adapter.classify.LeftAdapter;
import com.bwie.jd.common.ClassifyApi;
import com.bwie.jd.common.Contants;
import com.bwie.jd.contract.Classifycontract;
import com.bwie.jd.contract.Rightcontract;
import com.bwie.jd.entity.Classifyentity;
import com.bwie.jd.entity.Rightentity;
import com.bwie.jd.persenter.RightP;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.kson.base.base.mvp.BaseMvpFrament;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.net.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 第一缕阳光 on 2018/8/29.
 */

public class TwoFragment extends BaseMvpFrament<Rightcontract.IrightModel, Rightcontract.rightP> implements Rightcontract.IrightView {


    @BindView(R.id.left_rv)
    RecyclerView leftRv;
    @BindView(R.id.fl_text)
    TextView flText;
    @BindView(R.id.right_rv)
    RecyclerView rightRv;
    Unbinder unbinder;
    private LeftAdapter adapter;


    @Override
    protected int bindLayoutId() {
        return R.layout.two;
    }

    @Override
    public BasePresenter initPresenter() {
        return new RightP();
    }

    @Override
    protected void initData() {
        super.initData();

     RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, ClassifyApi.class).ClasssData()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Classifyentity>() {
                    @Override
                    public void accept(Classifyentity classifyentity) throws Exception {
                        final List<Classifyentity.DataBean> data = classifyentity.getData();
                        leftRv.setLayoutManager( new LinearLayoutManager(getActivity()));
                        adapter = new LeftAdapter(R.layout.left_item, data);
                        leftRv.setAdapter(adapter);

                        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                int cid = data.get(position).getCid();
                                HashMap<String, String> map = new HashMap<>();
                                map.put("cid", cid+"");
                                presenter.rightdata(map);
                            }
                        });


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {


                    }
                });


    }




    @Override
    public void rightsuccess(Rightentity rightentity) {
Log.i("aaa",rightentity+"");
       /* rightRv.setLayoutManager( new LinearLayoutManager(getActivity()));
        adapter = new LeftAdapter(R.layout.left_item, data);
        rightRv.setAdapter(adapter);*/

    }

    @Override
    public void fail(String msg) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}