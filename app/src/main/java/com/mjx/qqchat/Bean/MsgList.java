package com.mjx.qqchat.Bean;

/**
 * Created by Administrator on 2017/3/1.
 */

public class MsgList {

    private int image;
    private String name;
    private String content;
    private String time;

    public MsgList(int image, String name, String content, String time) {
        this.image = image;
        this.time = time;
        this.content = content;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }
}
