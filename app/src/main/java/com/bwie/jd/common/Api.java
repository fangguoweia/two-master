package com.bwie.jd.common;

/**
 * Created by 第一缕阳光 on 2018/8/30.
 */

public class Api {

    public static String HOME_URL = Contants.isRelease==true?Contants.BASE_RELEASE_URL+"home/getHome":Contants.BASE_DEBUG_URL+"home/getHome";
    //public static String PRODUCT_URL = Contants.isRelease==true?Contants.BASE_RELEASE_URL+"product/getCarts":Contants.BASE_DEBUG_URL+"product/getCarts";

}
