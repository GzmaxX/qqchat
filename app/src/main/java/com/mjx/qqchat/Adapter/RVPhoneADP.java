package com.mjx.qqchat.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjx.qqchat.Bean.PhoneList;
import com.mjx.qqchat.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class RVPhoneADP extends RecyclerView.Adapter<RVPhoneADP.ViewHolder> {

    private List<PhoneList> list;
    private Context mcontext;

    public RVPhoneADP(List<PhoneList> list) {
        this.list = list;
    }

    @Override
    public RVPhoneADP.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_phone_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RVPhoneADP.ViewHolder holder, int position) {
        holder.iv_phone_user.setImageResource(list.get(position).getImage());
        holder.tv_phone_name.setText(list.get(position).getName());
        holder.tv_phone_num.setText(list.get(position).getNum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_phone_user;
        private final TextView tv_phone_name;
        private final TextView tv_phone_num;
        private final ImageView iv_phone_call;

        public ViewHolder(View view) {
            super(view);

            iv_phone_user = (ImageView) view.findViewById(R.id.iv_phone_user);
            tv_phone_name = (TextView) view.findViewById(R.id.tv_phone_name);
            tv_phone_num = (TextView) view.findViewById(R.id.tv_phone_num);
            iv_phone_call = (ImageView) view.findViewById(R.id.iv_phone_call);

            iv_phone_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String num = "tel:" + tv_phone_num.getText();
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(num));

                    if (ActivityCompat.checkSelfPermission(mcontext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    mcontext.startActivity(intent);
                }
            });
        }
    }
}
