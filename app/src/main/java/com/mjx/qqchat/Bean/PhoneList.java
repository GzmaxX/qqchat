package com.mjx.qqchat.Bean;

/**
 * Created by Administrator on 2017/3/6.
 */

public class PhoneList {

    private int image;
    private String name;
    private String num;

    public PhoneList(int image, String name, String num) {
        this.image = image;
        this.name = name;
        this.num = num;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }
}
