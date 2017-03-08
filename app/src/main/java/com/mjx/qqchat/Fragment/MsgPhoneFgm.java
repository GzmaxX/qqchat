package com.mjx.qqchat.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjx.qqchat.Adapter.RVPhoneADP;
import com.mjx.qqchat.Bean.PhoneList;
import com.mjx.qqchat.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/28.
 */
public class MsgPhoneFgm extends Fragment {

    @BindView(R.id.recyclerview_phone)
    RecyclerView recyclerview_phone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg_phone, null);
        ButterKnife.bind(this,view);

        setRVMsg();
        return view;
    }

    private void setRVMsg() {

        List<PhoneList> list = new ArrayList<PhoneList>();
        list.add(new PhoneList(R.mipmap.image_user_1,"陈奕迅","123123123"));
        list.add(new PhoneList(R.mipmap.image_user_2,"周杰伦","565656565"));
        list.add(new PhoneList(R.mipmap.image_user_3,"李易峰","10088"));
        list.add(new PhoneList(R.mipmap.image_user_4,"汪峰","133567890"));
        list.add(new PhoneList(R.mipmap.image_user_5,"德玛西亚之力——盖伦","88888888"));
        list.add(new PhoneList(R.mipmap.image_user_6,"谢霆锋","114114146"));

        LinearLayoutManager lm = new LinearLayoutManager(this.getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_phone.setLayoutManager(lm);
        recyclerview_phone.setAdapter(new RVPhoneADP(list));


    }
}
