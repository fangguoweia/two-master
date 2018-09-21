package com.bwie.jd.frament;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.jd.R;
import com.bwie.jd.entity.Loginentity;
import com.bwie.jd.ui.LoginActvity;
import com.example.kson.base.base.BaseFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Console;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 第一缕阳光 on 2018/8/29.
 */

public class FourFragment extends BaseFragment implements View.OnClickListener {


    @BindView(R.id.shezhi)
    ImageView shezhi;
    @BindView(R.id.duihua)
    ImageView duihua;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.touxiang)
    SimpleDraweeView touxiang;
    @BindView(R.id.denglu)
    TextView denglu;
    Unbinder unbinder;

    @Override
    protected int bindLayoutId() {
        return R.layout.four;
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
        denglu.setOnClickListener(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void show(Loginentity loginentity) {
        String pic = loginentity.getResult().getUserInfo().getHeadPic();
        Log.i("pic",pic+"");
        denglu.setText(loginentity.getResult().getUserInfo().getNickName());
        touxiang.setImageURI(pic);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.denglu:
               startActivity( new Intent(getActivity(),LoginActvity.class));
                break;

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
