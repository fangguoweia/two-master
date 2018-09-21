package com.bwie.jd.common;

import com.bwie.jd.entity.Productentity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 第一缕阳光 on 2018/9/5.
 */

public interface ProductApi  {

    @POST("product/getCarts")
    @FormUrlEncoded
    Observable<Productentity> ProductData(@FieldMap Map<String,String> params);

}
