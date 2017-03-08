package com.mjx.qqchat.Bean;

/**
 * Created by Administrator on 2017/3/2.
 */

public class ChatList {

    private int who;
    private String content;

    public ChatList(int who, String content) {
        this.who = who;
        this.content = content;
    }

    public int getWho() {
        return who;
    }

    public String getContent() {
        return content;
    }
}
