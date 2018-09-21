package com.bwie.jd.model;

import android.os.Handler;

import com.bwie.jd.common.Api;
import com.bwie.jd.contract.Cartscontract;
import com.bwie.jd.entity.Cartsentity;
import com.bwie.jd.utils.OkHttpUtils;
import com.bwie.jd.utils.RequestCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class CartsM  implements Cartscontract.IShowModel{

    private Handler handler = new Handler();
    @Override
    public void ShowData(HashMap<String, String> params, final onShowResponse onShowResponse) {

        OkHttpUtils.getInstance().postData(Api.HOME_URL, params, new RequestCallback() {
            @Override
            public void failure(Call call, IOException e) {
                // TODO: 2018/8/30 请求失败没写
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code()==200){

                    String string = response.body().string();

                    perissmJson(string,onShowResponse);

                }

            }
        });

    }

    private void perissmJson(String string, final onShowResponse onShowResponse) {

        if (string!=null){
            Gson gson = new Gson();
            final Cartsentity cartsentity = gson.fromJson(string, Cartsentity.class);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    onShowResponse.success(cartsentity);
                }
            });
        }
    }


    public interface onShowResponse {

        void success(Cartsentity cartsentity);

        void failure(String msg);

    }
}
