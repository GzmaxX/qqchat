package com.mjx.qqchat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjx.qqchat.Activity.ChatActivity;
import com.mjx.qqchat.Bean.MsgList;
import com.mjx.qqchat.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class RecyclerViewMsgADP extends RecyclerView.Adapter<RecyclerViewMsgADP.ViewHolder> {

    private List<MsgList> list;
    private Context context;

    public RecyclerViewMsgADP(List<MsgList> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewMsgADP.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.rv_msg_item,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewMsgADP.ViewHolder holder, int position) {
        final int image = list.get(position).getImage();
        holder.iv_msg_user.setImageResource(image);
        holder.tv_msg_content.setText(list.get(position).getContent());
        final String name = list.get(position).getName();
        holder.tv_msg_name.setText(name);
        holder.tv_msg_time.setText(list.get(position).getTime());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image",image);
                bundle.putString("name",name);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_msg_user;
        private final TextView tv_msg_name;
        private final TextView tv_msg_content;
        private final TextView tv_msg_time;
        private final View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            iv_msg_user = (ImageView) itemView.findViewById(R.id.iv_msg_user);
            tv_msg_name = (TextView) itemView.findViewById(R.id.tv_msg_name);
            tv_msg_content = (TextView) itemView.findViewById(R.id.tv_msg_content);
            tv_msg_time = (TextView) itemView.findViewById(R.id.tv_msg_time);


        }
    }
}
