package com.mjx.qqchat.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjx.qqchat.Bean.LeftList;
import com.mjx.qqchat.R;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class RecyclerViewLeftADP extends RecyclerView.Adapter<RecyclerViewLeftADP.ViewHolder> {

    private List<LeftList> list;
    public RecyclerViewLeftADP(List<LeftList> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewLeftADP.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_left_item, parent ,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewLeftADP.ViewHolder holder, int position) {
        holder.cv_iv.setImageResource(list.get(position).getIcon());
        holder.cv_tv.setText(list.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView cv_iv;
        private final TextView cv_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            cv_iv = (ImageView) itemView.findViewById(R.id.cv_iv);
            cv_tv = (TextView) itemView.findViewById(R.id.cv_tv);
        }
    }
}
