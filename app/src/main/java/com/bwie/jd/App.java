package com.bwie.jd;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by 第一缕阳光 on 2018/8/29.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
