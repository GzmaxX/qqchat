package com.mjx.qqchat.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.mjx.qqchat.Bean.LabelList;
import com.mjx.qqchat.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */

public class RVLabelADP extends RecyclerView.Adapter<RVLabelADP.ViewHolder> {

    private List<LabelList> list ;
    private WebView webview;
    private String url0 ;
    private String url1 ;

    public RVLabelADP(List<LabelList> list, WebView webview, String url0, String url1) {
        this.list = list;
        this.webview = webview;
        this.url0 = url0;
        this.url1 = url1;
    }

    @Override
    public RVLabelADP.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_search_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RVLabelADP.ViewHolder holder, int position) {
        final String what = list.get(position).getWhat();
        holder.tv.setText(what);
        holder.tv.setBackgroundResource(list.get(position).getBackgroud_color());
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl(url0 + what +url1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public ViewHolder(View view) {
            super(view);

            tv = (TextView) view.findViewById(R.id.rl_tv);
        }
    }
}
