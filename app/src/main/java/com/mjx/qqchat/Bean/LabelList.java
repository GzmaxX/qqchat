package com.mjx.qqchat.Bean;

/**
 * Created by Administrator on 2017/3/3.
 */

public class LabelList {

    private String what;
    private int backgroud_color;

    public LabelList(String what, int backgroud_color) {
        this.what = what;
        this.backgroud_color = backgroud_color;
    }

    public String getWhat() {
        return what;
    }

    public int getBackgroud_color() {
        return backgroud_color;
    }
}
