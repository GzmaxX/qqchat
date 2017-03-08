package com.mjx.qqchat.Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjx.qqchat.Adapter.RecyclerViewChatADP;
import com.mjx.qqchat.Bean.ActiveUserInformation;
import com.mjx.qqchat.Bean.ChatList;
import com.mjx.qqchat.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mjx on 2017/3/1.
 */

public class ChatActivity extends Activity {

    @BindView(R.id.back_chat)
    TextView back_chat;
    @BindView(R.id.sendmsg_chat)
    Button sendmsg_chat;
    @BindView(R.id.msginput_chat)
    EditText msginput_chat;
    @BindView(R.id.recyclerview_chat)
    RecyclerView recyclerview_chat;
    @BindView(R.id.name_chat)
    TextView name_chat;
    @BindView(R.id.setting_chat)
    ImageView setting_chat;

    private int friimage;
    private String friname;
    private int myimage;
    private String myname;
    private List<ChatList> list;
    private RecyclerViewChatADP adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);
        ButterKnife.bind(this);

        intData();
        setRVChat();
    }

    private void intData() {

        //获取上一个活动传递下来的数据
        Bundle bundle = this.getIntent().getExtras();
        friimage = bundle.getInt("image");
        friname = bundle.getString("name");
        myimage = ActiveUserInformation.getImage();
        myname = ActiveUserInformation.getName();

        name_chat.setText(friname);
    }


    private void setRVChat() {

        list = new ArrayList<ChatList>();
        list.add(new ChatList(0, "我是max"));
        list.add(new ChatList(1, "我是你朋友"));
        list.add(new ChatList(0, "你好呀"));
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerview_chat.setLayoutManager(lm);
        adapter = new RecyclerViewChatADP(list, myimage, myname, friimage, friname);
        recyclerview_chat.setAdapter(adapter);
    }

    @OnClick({R.id.back_chat, R.id.sendmsg_chat,R.id.setting_chat})
    public void setChatView(View view) {
        switch (view.getId()) {
            case R.id.back_chat:
                ChatActivity.this.finish();
                break;
            case R.id.sendmsg_chat:
                list.add(new ChatList(0, msginput_chat.getText().toString().trim()));
                msginput_chat.setText("");
                adapter.notifyDataSetChanged();
                recyclerview_chat.smoothScrollToPosition(list.size());
                break;
            case R.id.setting_chat:

                addDialog();

                break;
            default:
                break;
        }
    }

    private void addDialog() {

        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder.setTitle("注意");
        builder.setMessage("确定清空当前聊天记录？");
        builder.setNegativeButton("取消",null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                list.clear();
                adapter.notifyDataSetChanged();
            }
        });
        builder.show();

    }
}


