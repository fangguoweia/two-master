package com.bwie.jd.frament;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.jd.R;
import com.bwie.jd.adapter.productAdapter.ProductAdapter;
import com.bwie.jd.contract.Productcontract;
import com.bwie.jd.entity.Productentity;
import com.bwie.jd.persenter.ProductP;
import com.example.kson.base.base.mvp.BaseMvpFrament;
import com.example.kson.base.base.mvp.BasePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 第一缕阳光 on 2018/8/29.
 */

public class ThreeFragment extends BaseMvpFrament<Productcontract.IProductModel, Productcontract.ProductP> implements Productcontract.IProductView {

    @BindView(R.id.f_recyclerView)
    RecyclerView fRecyclerView;
    @BindView(R.id.f_checkbox)
    CheckBox fCheckbox;
    @BindView(R.id.qx_tv)
    TextView qxTv;
    @BindView(R.id.f_price)
    TextView fPrice;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    Unbinder unbinder;
    private    ProductAdapter adapter;


    @Override
    protected void initData() {
        super.initData();
        refreshLayout.setRefreshHeader(new BezierRadarHeader(getActivity()).setEnableHorizontalDrag(true));
//设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        EventBus.getDefault().register(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", "17421");
        presenter.upload(map);

    }

    @Override
    public BasePresenter initPresenter() {
        return new ProductP();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.three;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void shub(String mas) {
        adapter.notifyDataSetChanged();
        totalPrice();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void shua(String ma) {
        adapter.notifyDataSetChanged();

        StringBuilder stringBuilder = new StringBuilder();
        if (adapter != null) {
            for (int i = 0; i < adapter.getBean().size(); i++) {

                stringBuilder.append(adapter.getBean().get(i).getIschekbox());

                for (int i1 = 0; i1 < adapter.getBean().get(i).getList().size(); i1++) {

                    stringBuilder.append(adapter.getBean().get(i).getList().get(i1).isIscheckbox());

                }
            }
        }
        if (stringBuilder.toString().contains("false")) {
            fCheckbox.setChecked(false);
        } else {
            fCheckbox.setChecked(true);
        }

        totalPrice();


    }

    private void totalPrice() {
        double totalprice = 0 ;
/*循环嵌套*/
        for (int i = 0; i <adapter.getBean().size(); i++) {
            for (int i1 = 0; i1 < adapter.getBean().get(i).getList().size(); i1++) {
                if (adapter.getBean().get(i).getList().get(i1).isIscheckbox()){
                    Productentity.DataBean.ListBean listBean = adapter.getBean().get(i).getList().get(i1);
                    totalprice+= listBean.getTotalNum()*listBean.getBargainPrice();
                }
            }
        }
        fPrice.setText("总价：¥"+totalprice);
    }



    @Override
    public void success(Productentity productentity) {


        Log.i("productentity",productentity+"");

        final List<Productentity.DataBean> data = productentity.getData();
        fRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         adapter = new ProductAdapter(R.layout.three_item, data);
        fRecyclerView.setAdapter(adapter);

        fCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fCheckbox.isChecked()){
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setIschekbox(true);
                        for (int i1 = 0; i1 < data.get(i).getList().size(); i1++) {
                            data.get(i).getList().get(i1).setIscheckbox(true);
                        }
                    }
                }else {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setIschekbox(false);
                        for (int i1 = 0; i1 < data.get(i).getList().size(); i1++) {
                            data.get(i).getList().get(i1).setIscheckbox(false);
                        }
                    }

                }
                /*  */
                totalPrice();
                adapter.notifyDataSetChanged();
            }
        });





    }

    //EventBus
  /*  @Subscribe(threadMode = ThreadMode.MAIN)
    public void showData(Productentity productentity){

        Log.i("bbb",productentity+"");

    }*/

    @Override
    public void fail(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}