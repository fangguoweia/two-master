package com.bwie.jd.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 第一缕阳光 on 2018/8/25.
 */

public interface RequestCallback {

    void failure(Call call, IOException e);
    void  onResponse(Call call, Response response) throws  IOException;

}
