package com.mjx.qqchat.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mjx.qqchat.Activity.MainActivity;
import com.mjx.qqchat.Activity.SearchActivity;
import com.mjx.qqchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/28.
 */

public class MsgFgm extends Fragment implements View.OnClickListener{

    @BindView(R.id.btn_msg_msgbar)
    RadioButton btn_msg_msgbar;
    @BindView(R.id.btn_phone_msgbar)
    RadioButton btn_phone_msgbar;
    @BindView(R.id.user_icon_toolbar)
    ImageView  user_icon_toolbar;
    @BindView(R.id.rl_search_msg)
    RelativeLayout rl_search_msg;
    @BindView(R.id.iv_msg_add)
    ImageView iv_msg_add;


    private MsgMsgFgm msgMsgFgm;
    private MsgPhoneFgm msgPhoneFgm;
    private Handler handler;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        handler = activity.getHandler();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg, null);
        ButterKnife.bind(this,view);

        init();
        return view;
    }

    private void init() {
        msgMsgFgm = new MsgMsgFgm();
        msgPhoneFgm = new MsgPhoneFgm();
        initFragmentChange(msgMsgFgm,msgPhoneFgm);
        btn_msg_msgbar.setChecked(true);

    }

    //设置消息界面上面bar的按钮点击监听事件
    @OnClick({R.id.btn_msg_msgbar,R.id.btn_phone_msgbar,R.id.user_icon_toolbar,R.id.iv_msg_add})
    public void setMsgBarBtn(View v){
        switch (v.getId()){
            case R.id.btn_msg_msgbar:
                setFragmentChange(msgPhoneFgm,msgMsgFgm);
                break;
            case R.id.btn_phone_msgbar:
                setFragmentChange(msgMsgFgm,msgPhoneFgm);
                break;
            case R.id.user_icon_toolbar:
                Message msg = new Message();
                msg.what = 0;
                handler.sendMessage(msg);
                break;
            case R.id.iv_msg_add:
                setMenu(v);
            break;
            default:
                break;
        }
    }

    private void setMenu(View v) {

        View menuview = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow_item, null);

        View create = menuview.findViewById(R.id.create);
        View add = menuview.findViewById(R.id.add);
        View scan = menuview.findViewById(R.id.scan);
        View shoot = menuview.findViewById(R.id.shoot);

        create.setOnClickListener(this);
        add.setOnClickListener(this);
        scan.setOnClickListener(this);
        shoot.setOnClickListener(this);

        PopupWindow pw = new PopupWindow(menuview, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pw.setTouchable(true);

        //设置背景后 才能点击菜单外的地方进行dismiss
        pw.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_bg_popupmenu));
        pw.showAsDropDown(v, 0, v.getHeight());
    }

    //消息和电话之间的转变
    public void setFragmentChange(Fragment from , Fragment to ){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction tc;
        tc = fm.beginTransaction();

        tc.hide(from).show(to).commit();

    }
    //初始化消息和电话
    public void initFragmentChange(Fragment shower , Fragment hider ){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction tc;
        tc = fm.beginTransaction();
        tc.add(R.id.msg_content,shower).add(R.id.msg_content,hider).hide(hider).commit();
    }

    @OnClick(R.id.rl_search_msg)
    public void onClickSearchBar(View v){
        switch(v.getId()){
            case R.id.rl_search_msg:
                Intent intent = new Intent(this.getContext(), SearchActivity.class);
                startActivity(intent);
            break;
            default :
                break;
        }
    }

    //     设置加号的菜单
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create:
                Toast.makeText(getContext(),"你点击了 创建聊天",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(getContext(),"你点击了 添加好友",Toast.LENGTH_SHORT).show();
                break;
            case R.id.scan:
                Toast.makeText(getContext(),"你点击了 扫二维码",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shoot:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}



