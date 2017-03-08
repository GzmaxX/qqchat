package com.mjx.qqchat.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjx.qqchat.Adapter.RecyclerViewMsgADP;
import com.mjx.qqchat.Bean.MsgList;
import com.mjx.qqchat.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/28.
 */

public class MsgMsgFgm extends Fragment {

    @BindView(R.id.recyclerview_msg)
    RecyclerView recyclerview_msg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg_msg, null);
        ButterKnife.bind(this,view);

        setRecyclerView_Msg();
        return view;
    }

    private void setRecyclerView_Msg() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_msg.setLayoutManager(lm);

        recyclerview_msg.setAdapter(new RecyclerViewMsgADP(recyclerView_MsgData()));

    }

    private List<MsgList> recyclerView_MsgData(){
        List<MsgList> list = new ArrayList<MsgList>();
            list.add(new MsgList(R.mipmap.image_user_1,"陈奕迅","你喜欢听我的歌吗","下午2：20"));
            list.add(new MsgList(R.mipmap.image_user_2,"周杰伦","哎哟！不错哟","下午2：26"));
            list.add(new MsgList(R.mipmap.image_user_3,"李易峰","我是盗墓笔记主角哦","上午6：40"));
            list.add(new MsgList(R.mipmap.image_user_4,"汪峰","要来一场摇滚盛宴吗？","下午4：20"));
            list.add(new MsgList(R.mipmap.image_user_5,"德玛西亚之力——盖伦","人在塔在","上午1：30"));
            list.add(new MsgList(R.mipmap.image_user_6,"谢霆锋","什么？谁是陈冠希","下午9：20"));



        return list;
    }
}
