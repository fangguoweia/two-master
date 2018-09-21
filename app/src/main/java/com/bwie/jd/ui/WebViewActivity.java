package com.bwie.jd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.bwie.jd.R;
import com.bwie.jd.common.AddshopApi;
import com.bwie.jd.common.Contants;
import com.example.kson.base.base.BaseActivity;
import com.example.kson.base.net.RetrofitUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.web_btn_gouwu)
    Button webBtnGouwu;
    @BindView(R.id.web_btn_add)
    Button webBtnAdd;
    private   String pic;


    @Override
    protected void initData() {
        Intent intent = getIntent();
        String weburl = intent.getStringExtra("webview");
       pic = intent.getStringExtra("pic");



        webView.loadUrl(weburl);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.web_view;
    }

    @OnClick({R.id.web_btn_gouwu, R.id.web_btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.web_btn_gouwu:

                break;
            case R.id.web_btn_add:
                HashMap<String, String> map = new HashMap<>();
                map.put("uid","17421");
                map.put("pic",pic+"");
                RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, AddshopApi.class).ProductData(map);

                break;
        }
    }
}
