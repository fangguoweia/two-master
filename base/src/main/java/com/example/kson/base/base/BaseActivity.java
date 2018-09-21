package com.example.kson.base.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.kson.base.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private boolean isFullScreen = false;//是否全屏 没写
    private Unbinder unbinder = null;
    private InputMethodManager imm;
    protected ImmersionBar mImmersionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        unbinder = ButterKnife.bind(this);

        if (isImmersionBarEnabled())
            initImmersionBar();

        initView();

        initData();
    }

    protected abstract void initData();

    public void setFullScreen(boolean isFullScreen){

        //全屏代码
        if (isFullScreen){
//            getWindow().setFlags();
        }
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 绑定根布局
     * @return
     */
    protected abstract int bindLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();

        this.imm = null;
        if (mImmersionBar != null)
            mImmersionBar.destroy();

        if (unbinder!=null){
            unbinder.unbind();//释放资源，回收内存，优化性能
            unbinder = null;
        }
    }



    /**
     * 无参数跳转
     * @param clz
     */
    public void startActivity(Class<? extends Activity> clz){
        startActivity(new Intent(this,clz));
    }
    /**
     * 有参数跳转
     * @param clz
     */
    public void startActivity(Class<? extends Activity> clz,Bundle bundle){
        Intent intent = new Intent(this,clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }
    /**
     * 显示toast、
     * @param msg
     */
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    /**
     * 显示带时间的toast
     * @param msg
     */
    public void showToast(String msg,int time){
        Toast.makeText(this, msg, time).show();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }

    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.imm == null) {
            this.imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.imm != null)) {
            this.imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }


}
