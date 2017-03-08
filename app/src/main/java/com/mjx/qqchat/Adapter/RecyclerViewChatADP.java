package com.mjx.qqchat.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mjx.qqchat.Bean.ChatList;
import com.mjx.qqchat.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */

public class RecyclerViewChatADP extends RecyclerView.Adapter<RecyclerViewChatADP.ViewHolder>{

    private List<ChatList> list;
    private int friimage;
    private String friname;
    private int myimage;
    private String myname;

    public RecyclerViewChatADP(List<ChatList> list, int myimage, String myname, int friimage, String friname) {
        this.list = list;
        this.myimage = myimage;
        this.myname = myname;
        this.friimage = friimage;
        this.friname = friname;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_chat_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int who = list.get(position).getWho();

        //0 是当前用户 就是my , 1是对方用户 就是fri
        if(who == 0){
            holder.frichat.setVisibility(View.GONE);
            holder.mychat.setVisibility(View.VISIBLE);
            holder.tv_mycontent.setText(list.get(position).getContent());
        }else if(who == 1){
            holder.frichat.setVisibility(View.VISIBLE);
            holder.mychat.setVisibility(View.GONE);
            holder.tv_fricontent.setText(list.get(position).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RelativeLayout frichat;
        private final ImageView iv_friimage;
        private final TextView tv_friname;
        private final TextView tv_fricontent;

        private final RelativeLayout mychat;
        private final ImageView iv_myimage;
        private final TextView tv_myname;
        private final TextView tv_mycontent;

        public ViewHolder(View view) {
            super(view);

            frichat = (RelativeLayout) view.findViewById(R.id.frichat);
            iv_friimage = (ImageView) view.findViewById(R.id.iv_chat_friimage);
            tv_friname = (TextView) view.findViewById(R.id.tv_chat_friname);
            tv_fricontent = (TextView) view.findViewById(R.id.tv_chat_fricontent);

            mychat = (RelativeLayout) view.findViewById(R.id.mychat);
            iv_myimage = (ImageView) view.findViewById(R.id.iv_chat_myimage);
            tv_myname = (TextView) view.findViewById(R.id.tv_chat_myname);
            tv_mycontent = (TextView) view.findViewById(R.id.tv_chat_mycontent);

            iv_friimage.setImageResource(friimage);
            tv_friname.setText(friname);
            iv_myimage.setImageResource(myimage);
            tv_myname.setText(myname);


        }
    }
}
