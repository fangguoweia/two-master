package com.bwie.jd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.jd.R;
import com.bwie.jd.contract.LoginContract;
import com.bwie.jd.entity.Loginentity;
import com.bwie.jd.persenter.LoginP;
import com.example.kson.base.base.mvp.BaseMvpActivity;
import com.example.kson.base.base.mvp.BasePresenter;
import com.example.kson.base.net.EncryptUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActvity extends BaseMvpActivity<LoginContract.ILoginModel, LoginContract.LoginP> implements LoginContract.ILoginView, View.OnClickListener {
    @BindView(R.id.mobile_et)
    EditText mobileEt;
    @BindView(R.id.pwd_et)
    EditText pwdEt;
    @BindView(R.id.eye_btn)
    ImageView eyeBtn;
    @BindView(R.id.duanxinyzm)
    TextView duanxinyzm;
    @BindView(R.id.xinyonghuzc)
    TextView xinyonghuzc;
    @BindView(R.id.login_btn)
    Button loginBtn;

private Handler handler = new Handler();
    @Override
    public BasePresenter initPresenter() {
        return new LoginP();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void success(Loginentity Loginentity) {

        EventBus.getDefault().post(Loginentity);

        new Handler().postDelayed(new Runnable(){

            public void run() {

             finish();
            }

        }, 500);


    }

    @Override
    public void fail(String msg) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        super.initData();
        xinyonghuzc.setOnClickListener(this);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.login_actvity;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(LoginActvity.this, RzhuceActvity.class));
    }

    @OnClick(R.id.login_btn)
    public void onViewClicked() {
        String s = mobileEt.getText().toString();
        String s1 = pwdEt.getText().toString();
        String s2 = EncryptUtil.encrypt(s1);
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", s);
        map.put("pwd", s2);
        presenter.logindata(map);

    }
}
