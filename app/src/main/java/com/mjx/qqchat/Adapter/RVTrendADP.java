package com.mjx.qqchat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjx.qqchat.Bean.TrendList;
import com.mjx.qqchat.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/7.
 */

public class RVTrendADP extends RecyclerView.Adapter<RVTrendADP.ViewHolder> {

    private List<TrendList> list ;
    private Context mcontext;

    public RVTrendADP(List<TrendList> list) {
        this.list = list;
    }

    @Override
    public RVTrendADP.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_trend_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RVTrendADP.ViewHolder holder, int position) {
        holder.iv_trend_image.setBackgroundResource(list.get(position).getImage());
        holder.tv_trend_title.setText(list.get(position).getTitle());
        holder.tv_trend_content.setText(list.get(position).getContent());
        final String url = list.get(position).getUrl();
        holder.tv_trend_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(url));
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_trend_image)
        ImageView iv_trend_image;
        @BindView(R.id.tv_trend_title)
        TextView tv_trend_title;
        @BindView(R.id.tv_trend_content)
        TextView tv_trend_content;
        @BindView(R.id.cb_trend_like)
        CheckBox cb_trend_like;
        @BindView(R.id.tv_trend_more)
        TextView tv_trend_more;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);

        }


    }
}
